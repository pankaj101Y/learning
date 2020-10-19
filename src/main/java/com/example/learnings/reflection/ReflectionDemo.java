package com.example.learnings.reflection;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class ReflectionDemo {


    public static void main(String[] args) throws IllegalAccessException {
        Class<?> codeClass=ResponseCode.class;

        Map<String,ResponseCode> responseCodeMap=getKeyValue(codeClass);
        Map<String,String> dbKeyValue=getDbKeyValue(responseCodeMap);

        ArrayList<String>generatedFields=getGeneratedFields(responseCodeMap,dbKeyValue);
        for (String f:generatedFields)System.out.println(f);

        ArrayList<String> inserts=prepareSqlInserts("config_master","cart",dbKeyValue,"sit");
//        for (String str:inserts)System.out.println(str);
    }

    private static ArrayList<String> prepareSqlInserts(String table, String app, Map<String, String> dbKeyValue,String profile) {
        ArrayList<String> res=new ArrayList<>();

        for(String key:dbKeyValue.keySet()){

            res.add("INSERT INTO "+ table +" (application, profile, key, value) VALUES"+ " ("+app +","+ profile+","+ key+","+dbKeyValue.get(key)+");");
        }

        log.info("sql inserts size= "+res.size());
        return res;
    }

    private static ArrayList<String> getGeneratedFields(Map<String, ResponseCode> responseCodeMap, Map<String, String> dbKeyValue) {
        ArrayList<String>ans=new ArrayList<>();

        for (String field:responseCodeMap.keySet()){
            String res="public static final "+field+" = "+"initResponseCode("+ "\""+ getDbKey(field)+ "\");";
            ans.add(res);
        }

        log.info("generated fields = "+ans.size());
        return ans;
    }

    public static Map<String,ResponseCode> getKeyValue(Class<?> c) throws IllegalAccessException {
        Map<String,ResponseCode>dbKeyValue=new HashMap<>();

        Field[] fields=c.getFields();
        log.info("number of fields = "+fields.length);

        for (Field field:fields){
            dbKeyValue.put(field.getName(),(ResponseCode) field.get(null));
        }
        return dbKeyValue;
    }

    public static Map<String,String> getDbKeyValue(Map<String,ResponseCode> map){
        Map<String,String>dbKeyValue=new HashMap<>();

        for (String key:map.keySet()){
            dbKeyValue.put(getDbKey(key),getDbValue(map.get(key)));
        }
        return dbKeyValue;
    }

    private static String getDbValue(ResponseCode responseCode) {
        String value=responseCode.getCode()+";"+responseCode.getDescription();
        return value;
    }

    private static String getDbKey(String str) {
        str=str.toLowerCase();
        String[] A=str.split("_");
        StringBuilder res=new StringBuilder();

        for (String temp:A)res.append(temp).append('.');
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }

}
