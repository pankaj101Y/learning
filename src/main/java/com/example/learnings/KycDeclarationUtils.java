package com.example.learnings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public final class KycDeclarationUtils {

    private KycDeclarationUtils(){}


    /***
     * Assumption consent text is in form
     *  A. OTP which was sent on mobile no: 7532082289 on 2020/07/06 02:43 , verified on: 2020/07/06 02:43 ,
     *  B. OTP which was sent on mobile no: 9560141076 on : 2020/07/06 02:42 , verified on: 2020/07/06 02:42,
     *
     * @param text
     * @return return a list [Mobile No, send on Date, Verified On Date]
     */
    static ArrayList<String> getDeclarationData(String text){
        ArrayList<String>ans=new ArrayList<>();

        String mno=getMobileNumber(text);
        if (mno==null)throw new RuntimeException("No Mobile Number Found for common kyc dsl consent");

        ans.add(mno);

        ArrayList<String>dates=getDates(text);

        if (dates.size()!=2)throw new RuntimeException("Dates mismatch found for common kyc dsl consent");

        ans.add(dates.get(0));
        ans.add(dates.get(1));


        return ans;
    }

    /***
     * ASSUMPTION: date is of format 2020/07/06 02:43 and it returns
     * @param text
     * @return first two,one  dates it found or empty list
     */
    static ArrayList<String> getDates(String text){
        String example="2020/07/06 02:43";

        int n=text.length();
        int len=example.length();

        ArrayList<String>dates=new ArrayList<>();
        String temp;
        for(int i=0;i<n-len;i++){
            temp=text.substring(i,i+len);
            if (isValidDate(temp))dates.add(temp);
            if (dates.size()==2)return dates;
//            System.out.println(temp+" "+dates);
        }
        return dates;
    }


    /***
     *
     * @param text mobile number of 10 digits
     * @return it returns the first mobile no it finds else null
     */
    static String getMobileNumber(String text){
        int len=10;
        int n=text.length();
        String temp;
        for(int i=0;i<n-len;i++){
            temp=text.substring(i,i+len);
            if (isMobileNumber(temp))return temp;
        }
        return null;
    }

    private static boolean isMobileNumber(String mob){
        try {
            Long.parseLong(mob);
            return true;
        }catch (Exception e){
            //todo log
            return false;
        }
    }

    /**
     *
     * @param inDate
     * @return true if date is of form yyyy/dd/MM HH:mm else false
     */
    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;

//        System.out.println(isValidDate("2020/07/19 09:18"));->true
//        System.out.println(isValidDate("20-01-2014"));->false
//        System.out.println(isValidDate("2020/07/06 02:43"));->true
//        System.out.println(isValidDate("1213445543"));->false
    }


}
