package com.example.learnings.edsl.data;

import java.util.ArrayList;

public class CustomPlanList extends ArrayList<MyDslPlanBean> {


    @Override
    public boolean contains(Object o){
        MyDslPlanBean bean = (MyDslPlanBean)o;
        for(MyDslPlanBean planBean : this){
            if(planBean.getPlanCode().equalsIgnoreCase(bean.getPlanCode())){
                return true;
            }
        }
        return false;
    }
}
