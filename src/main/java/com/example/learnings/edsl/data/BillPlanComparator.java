package com.example.learnings.edsl.data;

import java.util.Comparator;



public class BillPlanComparator implements Comparator<MyDslPlanBean> {

	@Override
	public int compare(MyDslPlanBean plan1, MyDslPlanBean plan2) {
		int speed1 = EdslDataUtils.convertStringToInteger(plan1.getBillPlanSpeed());
		int speed2 = EdslDataUtils.convertStringToInteger(plan2.getBillPlanSpeed());
		
		int usageLimit1 = EdslDataUtils.convertStringToInteger(plan1.getBillPlanQuota());
		int usageLimit2 = EdslDataUtils.convertStringToInteger(plan2.getBillPlanQuota());
		
		if(speed1 == speed2){
			return usageLimit1 - usageLimit2;
		}else{
			return speed1 - speed2 ;	
		}
	}
}


