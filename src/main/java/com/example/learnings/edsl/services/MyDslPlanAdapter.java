package com.example.learnings.edsl.services;

import com.example.learnings.edsl.data.*;
import com.example.learnings.edsl.data.BillPlanDetail.ProductOfferingPrice;
import com.example.learnings.edsl.data.BillPlanDetail.ProductSpecification;
import com.example.learnings.edsl.data.BillPlanDetail.WebEnabled;
import com.example.learnings.edsl.data.DataArea.GetProspectiveBillPlansForCustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.*;

public class MyDslPlanAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyDslPlanAdapter.class);

    private static final int MAX_ADSL_SPEED = 16;

    private static final double GST_RATE = 18;




    public static List<MyDslPlanBean> parseResponseForDslPlansMonthly(FetchBillPlanDetails fetchBillPlanDetails,
                                                                      Map<String, Integer> planDetails, Map<Integer, BillPlanGrid> planGrid, String distance,List<String> eligibityIdentifiers) {
        LOGGER.debug("Start Parsing response for DSL Bill Plan ,fetchBillPlanDetails:{},planDetails:{},planGrid:{},distance,{}", fetchBillPlanDetails, planDetails, planGrid, distance);
        List<MyDslPlanBean> myDslPlanBeanList = new ArrayList<>();
        GetProspectiveBillPlansForCustomerResMsg getProspectiveBillPlansForCustomerResMsg = fetchBillPlanDetails
                .getGetProspectiveBillPlansForCustomerResMsg();
        DataArea dataArea = getProspectiveBillPlansForCustomerResMsg.getDataArea();
        GetProspectiveBillPlansForCustomerResponse getProspectiveBillPlansForCustomerResponse = dataArea
                .getGetProspectiveBillPlansForCustomerResponse();
        BillPlanDetails billPlanDetails = getProspectiveBillPlansForCustomerResponse.getBillPlandetails().get(0);
        List<BillPlanDetail> billPlanlist = billPlanDetails.getBillPlandetail();
        LOGGER.debug("Bill plan list  : {}", billPlanlist);


        for (BillPlanDetail billPlanDetail : billPlanlist) {
            String planType = null;
            ProductOfferingPrice productOfferingPrice = null;
            ServiceSpecification serviceSpecification = null;
            HashSet<String> set = new HashSet<>();

            if (null != billPlanDetail.getProductOfferingPrice()) {
                productOfferingPrice = billPlanDetail.getProductOfferingPrice();
                planType = productOfferingPrice.getBillPlanCategory();
            }
            if (null != billPlanDetail.getProductSpecification()) {
                ProductSpecification productSpecification = billPlanDetail.getProductSpecification();
                String ProductNumber = productSpecification.getProductNumber();
                if (!set.add(ProductNumber)) {
                    continue;
                }
            }

            boolean isValidPlan = false;
            boolean isValidPlanGrid = false;

            isValidPlan = isValidPlan(billPlanDetail, planDetails,eligibityIdentifiers);
            if (isValidPlan) {
                isValidPlanGrid = isValidGrid(billPlanDetail, planGrid, distance, null);
            }
            LOGGER.info("Checking if valid bill plangrid : {}", billPlanDetail);
            LOGGER.info("checking if valid_plan:{}  & valid_grid :{}", isValidPlan, isValidPlanGrid);

            if (isValidPlan && isValidPlanGrid) {
                MyDslPlanBean myDslPlanBean = new MyDslPlanBean();
                if (null != billPlanDetail.getProductOfferingPrice()) {
                    productOfferingPrice = billPlanDetail.getProductOfferingPrice();
                    myDslPlanBean.setBillPlanRental(Double.parseDouble(productOfferingPrice.getPrice()));
                    myDslPlanBean.setRentalType(planType);
                }

                if (null != billPlanDetail.getProductSpecification()) {
                    ProductSpecification productSpecification = billPlanDetail.getProductSpecification();
                    myDslPlanBean.setPlanDescription(productSpecification.getDescription());
                    myDslPlanBean.setPlanCode(productSpecification.getProductNumber());
                }

                if (null != billPlanDetail.getWebEnabled()) {
                    WebEnabled webEnabled = billPlanDetail.getWebEnabled();
                    if (null != webEnabled.getServiceSpecification()) {
                        serviceSpecification = webEnabled.getServiceSpecification();
                        myDslPlanBean.setPostFupSpeed(serviceSpecification.getBandwidth());
                        myDslPlanBean.setBillPlanSpeed(serviceSpecification.getCurrentSpeed());
                        myDslPlanBean.setBillPlanQuota(serviceSpecification.getUsageLimit());
                    }

                    if (null != webEnabled.getExternalIdentification()) {
                        List<ExternalIdentification> externalIdentifications = webEnabled.getExternalIdentification();
                        for (ExternalIdentification externalIdentification : externalIdentifications) {
                            if (externalIdentification.getName().equalsIgnoreCase(DSLConstant.LDAP_NUMBER)) {
                                myDslPlanBean.setCrmID(externalIdentification.getId());
                                myDslPlanBean.setCrmName(externalIdentification.getName());
                            }
                        }
                    }
                    myDslPlanBean.setArpRentalMonth("0");
                }


                if (null != productOfferingPrice) {
                    myDslPlanBean.setTotalArpAmount(Double.parseDouble(productOfferingPrice.getPrice()));
                }

                myDslPlanBeanList.add(myDslPlanBean);
            }
        }
        return myDslPlanBeanList;
    }

    public static List<MyDslPlanBean> parseResponseForDslPlans(FetchBillPlanDetails fetchBillPlanDetails,
                                                               Map<String, Integer> planDetails, Map<Integer, BillPlanGrid> planGrid, String distance, String agentType, String source, List<String> eligibityIdentifiers) {
        LOGGER.debug("Start Parsing response for DSL Bill Plan,planDetails:{},planGrid:{},distance,{}", planDetails, planGrid, distance);
        List<MyDslPlanBean> myDslPlanBeanList = new ArrayList<>();
        List<MyDslPlanBean> arpList = new ArrayList<>();
        List<MyDslPlanBean> threeMonthsPlan = new ArrayList<>();
        List<MyDslPlanBean> sixMonthsPlan = new ArrayList<>();
        List<MyDslPlanBean> tweleveMonthsPlan = new ArrayList<>();
        CustomPlanList monthlyPlans = new CustomPlanList();
        HashMap<String,List<TopUpDetailsBean>> topUpMap=new HashMap<>(); //Hashmap for storing top up details
        GetProspectiveBillPlansForCustomerResMsg getProspectiveBillPlansForCustomerResMsg = fetchBillPlanDetails
                .getGetProspectiveBillPlansForCustomerResMsg();
        DataArea dataArea = getProspectiveBillPlansForCustomerResMsg.getDataArea();
        GetProspectiveBillPlansForCustomerResponse getProspectiveBillPlansForCustomerResponse = dataArea
                .getGetProspectiveBillPlansForCustomerResponse();


        List<BillPlanDetails> billPlanDetailslist = getProspectiveBillPlansForCustomerResponse.getBillPlandetails();

        for (BillPlanDetails billPlanDetails : billPlanDetailslist) {
            List<BillPlanDetail> billPlanlist = billPlanDetails.getBillPlandetail();
            LOGGER.debug("Bill plan list  : {}", billPlanlist);


            for (BillPlanDetail billPlanDetail : billPlanlist) {
                String planType = null;
                String price = null;
                String actualBillCategory=DSLConstant.MONTHLY;;
                ProductOfferingPrice productOfferingPrice = null;
                ServiceSpecification serviceSpecification = null;
                if (null != billPlanDetail.getProductOfferingPrice()) {
                    productOfferingPrice = billPlanDetail.getProductOfferingPrice();
                    price = productOfferingPrice.getPrice();
                    if (null != billPlanDetail.getProductOffering().getProduct().getOneTimeChargeProdOfferPriceCharge()
                            && productOfferingPrice.getBillPlanCategory().equalsIgnoreCase("ARP")) {
                        planType = DSLConstant.ARP;
                        actualBillCategory=DSLConstant.ARP;
                    } else if (productOfferingPrice.getBillPlanCategory().equalsIgnoreCase("Monthly")
                            && null != billPlanDetail.getProductOffering().getProduct().getOneTimeChargeProdOfferPriceCharge()) {
                    	
                        if(billPlanDetail.getProductOffering()!=null &&  billPlanDetail.getProductOffering().getProduct()!=null && billPlanDetail.getProductOffering().getProduct().getProductSpecification()!=null &&billPlanDetail.getProductOffering().getProduct().getProductSpecification().getProductSpecCharacteristic()!=null &&
                                "NONARP".equalsIgnoreCase(billPlanDetail.getProductOffering().getProduct().getProductSpecification().getProductSpecCharacteristic().getType()))
                        {
                            planType=DSLConstant.MONTHLY;
                        }
                        else {
                            planType = DSLConstant.ARP_MONTHLY;
                        }
                    }else if(agentType.equalsIgnoreCase(DSLConstant.LCO_AGENT)){
                        if(productOfferingPrice.getBillPlanCategory().equalsIgnoreCase("Monthly") &&
                                null!=billPlanDetail.getProductOffering().getProduct().getValidFor() &&
                                billPlanDetail.getProductOffering().getProduct().getValidFor().equalsIgnoreCase("ARP_DETAILS") &&
                                billPlanDetail.getProductOffering().getProduct().getExt()!=null){
                            planType = DSLConstant.ARP_MONTHLY;
                        }else {
                            planType = DSLConstant.MONTHLY;
                        }

                    }else {
                        planType = DSLConstant.MONTHLY;
                    }
                }

                boolean isValidPlan = false;
//				boolean isValidPlanGrid = false;

                isValidPlan = isValidPlan(billPlanDetail, planDetails,eligibityIdentifiers);
                LOGGER.info("Checking if valid bill plangrid : {}", billPlanDetail);

               

//				if (isValidPlan && isValidPlanGrid)
                if (isValidPlan) {

                    if(isThisIsTopUp(billPlanDetail,topUpMap)) {
                        LOGGER.info("This is top up");
                        continue;
                    }
                    LOGGER.info("This is non top up case ");
                    MyDslPlanBean myDslPlanBean = new MyDslPlanBean();
                    myDslPlanBean.setSource(source);
                    myDslPlanBean.setActualPlanType(actualBillCategory);
                    if (null != billPlanDetail.getProductSpecification()) {
                        ProductSpecification productSpecification = billPlanDetail.getProductSpecification();
                        myDslPlanBean.setPlanDescription(productSpecification.getDescription());
                        myDslPlanBean.setPlanCode(productSpecification.getProductNumber());
                    }

                    if (null != billPlanDetail.getWebEnabled()) {
                        WebEnabled webEnabled = billPlanDetail.getWebEnabled();
                        if (null != webEnabled.getServiceSpecification()) {
                            serviceSpecification = webEnabled.getServiceSpecification();
                            myDslPlanBean.setPostFupSpeed(serviceSpecification.getBandwidth());
                            myDslPlanBean.setBillPlanSpeed(serviceSpecification.getCurrentSpeed());
                            myDslPlanBean.setBillPlanQuota(serviceSpecification.getUsageLimit());
                        }

                        if (null != webEnabled.getExternalIdentification()) {
                            List<ExternalIdentification> externalIdentifications = webEnabled.getExternalIdentification();
                            for (ExternalIdentification externalIdentification : externalIdentifications) {
                                if (externalIdentification.getName().equalsIgnoreCase(DSLConstant.LDAP_NUMBER)) {
                                    myDslPlanBean.setCrmID(externalIdentification.getId());
                                    myDslPlanBean.setCrmName(externalIdentification.getName());
                                }
                            }
                        }
                    }

                    myDslPlanBean.setPerMonthCharge(price);

                    if (planType.equalsIgnoreCase(DSLConstant.ARP)) {
                        setArpDetails(billPlanDetail, myDslPlanBean);
                        getAllArpPlans(arpList, threeMonthsPlan, sixMonthsPlan, tweleveMonthsPlan, myDslPlanBean);
                    } else if (planType.equalsIgnoreCase(DSLConstant.ARP_MONTHLY)) {
                        setArpDetails(billPlanDetail, myDslPlanBean);
                        getAllArpPlans(arpList, threeMonthsPlan, sixMonthsPlan, tweleveMonthsPlan, myDslPlanBean);
                        if (!monthlyPlans.contains(myDslPlanBean)) {
                            MyDslPlanBean dslPlanBean = setMonthlyPlan(myDslPlanBean);
                            setMonthlyDetails(billPlanDetail, productOfferingPrice, dslPlanBean);
                            if (checkDifferentAmount(monthlyPlans, myDslPlanBean)) {
                                if (checkMaxSpeedPlan(monthlyPlans, dslPlanBean)) {
                                    monthlyPlans.add(dslPlanBean);
                                }
                            } else {
                                monthlyPlans.add(dslPlanBean);
                            }

                        }
                    } else {
                        setMonthlyDetails(billPlanDetail, productOfferingPrice, myDslPlanBean);
                        if (checkDifferentAmount(monthlyPlans, myDslPlanBean)) {
                            if (checkMaxSpeedPlan(monthlyPlans, myDslPlanBean)) {
                                monthlyPlans.add(myDslPlanBean);
                            }
                        } else {
                            monthlyPlans.add(myDslPlanBean);
                        }
                    }
                }


            }
        }

        myDslPlanBeanList.addAll(sixMonthsPlan);
        myDslPlanBeanList.addAll(threeMonthsPlan);
        myDslPlanBeanList.addAll(tweleveMonthsPlan);
        myDslPlanBeanList.addAll(monthlyPlans);
        myDslPlanBeanList.addAll(arpList);
        
        myDslPlanBeanList=checkIfArpIsThereWithoutMonthly(myDslPlanBeanList,monthlyPlans);

        LOGGER.info("********************************************************");
        LOGGER.info(" Final list that has been prepared for all the plans is ");
        LOGGER.info("Six month {}",sixMonthsPlan.toString());
        LOGGER.info("Three month {}",threeMonthsPlan.toString());
        LOGGER.info("Twelve month {}",tweleveMonthsPlan.toString());
        LOGGER.info("Monthly plan {}",monthlyPlans.toString());
        LOGGER.info("Arp list {}",arpList.toString());
        LOGGER.info("********************************************************");
        for(int i=0;i<topUpMap.size();i++)
        {
            LOGGER.info("{}th top up is ",i);
            LOGGER.info("{}",topUpMap.get(i));
        }

        preparedPlansListWithTopUp(myDslPlanBeanList,topUpMap);
        return myDslPlanBeanList;
    }

	private static void preparedPlansListWithTopUp(List<MyDslPlanBean> myDslPlanBeanList,
                                                   HashMap<String, List<TopUpDetailsBean>> topUpMap) {
        LOGGER.info("Inside preparedPlansListWithTopUp ");
        for (MyDslPlanBean myDslPlanBean : myDslPlanBeanList) {
            if(topUpMap.containsKey(myDslPlanBean.getPlanCode())) {
                myDslPlanBean.setTopUpDetails(topUpMap.get(myDslPlanBean.getPlanCode()));
            }else {
                LOGGER.info("Inside  preparedPlansListWithTopUp  this plan does'nt have topUp"+myDslPlanBean.getPlanCode());
            }

        }
        // TODO Auto-generated method stub

    }

    private static void getAllArpPlans(List<MyDslPlanBean> arpList, List<MyDslPlanBean> threeMonthsPlan, List<MyDslPlanBean> sixMonthsPlan, List<MyDslPlanBean> tweleveMonthsPlan, MyDslPlanBean myDslPlanBean) {
        if (myDslPlanBean.getArpRentalMonth().equalsIgnoreCase("3")) {
            getArpPlans(threeMonthsPlan, myDslPlanBean);
        } else if (myDslPlanBean.getArpRentalMonth().equalsIgnoreCase("6")) {
            getArpPlans(sixMonthsPlan, myDslPlanBean);
        } else if (myDslPlanBean.getArpRentalMonth().equalsIgnoreCase("12")) {
            getArpPlans(tweleveMonthsPlan, myDslPlanBean);
        } else {
            getArpPlans(arpList, myDslPlanBean);
        }
    }

    private static void getArpPlans(List<MyDslPlanBean> plans, MyDslPlanBean myDslPlanBean) {
        if (checkDifferentAmount(plans, myDslPlanBean)) {
            if (checkMaxSpeedPlan(plans, myDslPlanBean)) {
                plans.add(myDslPlanBean);
            }
        } else {
            plans.add(myDslPlanBean);
        }
    }

    private static boolean checkNotDifferentRental(List<MyDslPlanBean> arpList, MyDslPlanBean myDslPlanBean) {
        for (MyDslPlanBean planBean : arpList) {
            double existingPlanRental = Double.parseDouble(planBean.getArpRentalMonth());
            double newPlanRental = Double.parseDouble(myDslPlanBean.getArpRentalMonth());
            if (existingPlanRental == newPlanRental) {
                return true;
            }

        }
        return false;
    }

    private static boolean checkDifferentAmount(List<MyDslPlanBean> arpList, MyDslPlanBean myDslPlanBean) {
        for (MyDslPlanBean planBean : arpList) {
            double existPlanCharge = Double.parseDouble(planBean.getPerMonthCharge());
            double newPlanCharge = Double.parseDouble(myDslPlanBean.getPerMonthCharge());
            if (existPlanCharge == newPlanCharge) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkMaxSpeedPlan(List<MyDslPlanBean> arpList, MyDslPlanBean myDslPlanBean) {
        boolean maxSpeedPlan = false;
        if (arpList.size() == 0) {
            maxSpeedPlan = true;
        }

        Iterator<MyDslPlanBean> myDslPlanBeanIterator = arpList.iterator();
        while (myDslPlanBeanIterator.hasNext()) {
            MyDslPlanBean existingPlan = myDslPlanBeanIterator.next();
            if (existingPlan.getPerMonthCharge() != null) {
                double perMonthCharge = Double.parseDouble(existingPlan.getPerMonthCharge());
                double perMonthNewPlanCharge = Double.parseDouble(myDslPlanBean.getPerMonthCharge());
                double existingPlanSpeed = Double.parseDouble(existingPlan.getBillPlanSpeed());
                double planSpeedOfNewPlan = Double.parseDouble(myDslPlanBean.getBillPlanSpeed());
                double existingPlanRental = Double.parseDouble(existingPlan.getArpRentalMonth());
                double newPlanRental = Double.parseDouble(myDslPlanBean.getArpRentalMonth());
              // LOGGER.info("  plan in list {} current plan ",arpList,myDslPlanBean.toString());
                if ((perMonthCharge == perMonthNewPlanCharge) && (existingPlanSpeed <= planSpeedOfNewPlan) && (existingPlanRental == newPlanRental)) {
                	if(existingPlanRental>0 && myDslPlanBean.getActualPlanType().equalsIgnoreCase(DSLConstant.MONTHLY)) {
                		LOGGER.info("Skipped removing plan  for scheme id  {}",myDslPlanBean.getSchemeId());
                	}else if (!StringUtils.isEmpty(myDslPlanBean.getSource()) && myDslPlanBean.getSource().equalsIgnoreCase("cart")) {
                       LOGGER.info("Skipped removing plan as source - cart ");
                        //Skip removing
                    } else {
                        myDslPlanBeanIterator.remove();
                    }
                    maxSpeedPlan = true;
                }
            }
        }
        return maxSpeedPlan;
    }


    private static double getGstAmount(double amount) {
        double finalAmount = (amount) * (GST_RATE / 100);
        amount = amount + finalAmount;
        return amount;
    }

    private static MyDslPlanBean setMonthlyPlan(MyDslPlanBean myDslPlanBean) {
        MyDslPlanBean dslPlanBean = new MyDslPlanBean();
        dslPlanBean.setPlanDescription(myDslPlanBean.getPlanDescription());
        dslPlanBean.setPlanCode(myDslPlanBean.getPlanCode());
        dslPlanBean.setPostFupSpeed(myDslPlanBean.getPostFupSpeed());
        dslPlanBean.setBillPlanSpeed(myDslPlanBean.getBillPlanSpeed());
        dslPlanBean.setBillPlanQuota(myDslPlanBean.getBillPlanQuota());
        dslPlanBean.setCrmID(myDslPlanBean.getCrmID());
        dslPlanBean.setCrmName(myDslPlanBean.getCrmName());
        dslPlanBean.setPerMonthCharge(myDslPlanBean.getPerMonthCharge());
        dslPlanBean.setActualPlanType(myDslPlanBean.getActualPlanType());
        return dslPlanBean;
    }

    private static void setMonthlyDetails(BillPlanDetail billPlanDetail, ProductOfferingPrice productOfferingPrice, MyDslPlanBean myDslPlanBean) {
        myDslPlanBean.setRentalType(DSLConstant.MONTHLY);
        myDslPlanBean.setArpRentalMonth("0");
        myDslPlanBean.setTotalArpAmount(Double.parseDouble((billPlanDetail.getProductOfferingPrice().getPrice())));
        myDslPlanBean.setSchemeId(null);
        myDslPlanBean.setBillPlanRental(Double.parseDouble(productOfferingPrice.getPrice()));
    }

    private static void setArpDetails(BillPlanDetail billPlanDetail, MyDslPlanBean myDslPlanBean) {
        myDslPlanBean.setRentalType(DSLConstant.ARP);
        if(billPlanDetail.getProductOffering().getProduct().getExt()!=null) {
            for (Attribute attribute : billPlanDetail.getProductOffering().getProduct().getExt()
                    .getAttribute()) {
                if (attribute.getName().equalsIgnoreCase(DSLConstant.ARP_Months_Duration)) {
                    myDslPlanBean.setArpRentalMonth(attribute.getValue());
                }
                if (attribute.getName().equalsIgnoreCase(DSLConstant.ARP_Discount_Precentage)) {
                    myDslPlanBean.setDiscountPercentage(attribute.getValue());
                }
            }
        }
        if(billPlanDetail.getProductOffering().getProduct().getOneTimeChargeProdOfferPriceCharge()!=null) {
            myDslPlanBean.setTotalArpAmount(Double.parseDouble(billPlanDetail.getProductOffering()
                    .getProduct().getOneTimeChargeProdOfferPriceCharge().getPrice()));
        }
        double totalArpAmount = myDslPlanBean.getTotalArpAmount();
        double gstAmount = getGstAmount(totalArpAmount);
        myDslPlanBean.setTotalAmountWithGst(gstAmount);
        if(billPlanDetail.getProductOffering().getProduct().getProductSerialNumber()!=null) {
            myDslPlanBean.setSchemeId(billPlanDetail.getProductOffering().getProduct().getProductSerialNumber());
        }

        if(billPlanDetail.getProductOffering().getProduct().getProdPriceCharge()!=null) {
            myDslPlanBean.setBillPlanRental(Double.parseDouble(
                    (billPlanDetail.getProductOffering().getProduct().getProdPriceCharge().getPrice())));
        }

        double actualPlanCharges = Double.parseDouble(myDslPlanBean.getArpRentalMonth()) *  Double.parseDouble(myDslPlanBean.getPerMonthCharge());
        myDslPlanBean.setActualPlanCharges(Math.round(actualPlanCharges));

        double discount = Double.parseDouble((myDslPlanBean.getDiscountPercentage()))/100;
        double afterDiscount = 1- discount;

        double actualPaymentCharges = Double.parseDouble(myDslPlanBean.getArpRentalMonth()) * Double.parseDouble(myDslPlanBean.getPerMonthCharge()) * afterDiscount ;
        myDslPlanBean.setActualPaymentCharges(Math.round(actualPaymentCharges));

    }

    private static boolean isValidGrid(BillPlanDetail billPlanDetail, Map<Integer, BillPlanGrid> planGrids,
                                       String distance, String dslTech) {

        if (StringUtils.isEmpty(distance) || planGrids.isEmpty()) {
            return true;
        }

        String speed = null;

        if (null != billPlanDetail.getWebEnabled()) {
            WebEnabled webEnabled = billPlanDetail.getWebEnabled();
            if (null != webEnabled.getServiceSpecification()) {
                ServiceSpecification serviceSpecification = webEnabled.getServiceSpecification();
                speed = serviceSpecification.getCurrentSpeed();
            }
        }

        if (StringUtils.isEmpty(speed)) {
            return false;
        }


        int planSpeed = EdslDataUtils.convertStringToInteger(speed);
        planSpeed = planSpeed / 1024;
        BillPlanGrid billPlanGrid = getPlanGrid(planGrids, distance);
        LOGGER.info("BillPlanGrid:{} for plangrid :{},distance :{}", billPlanGrid, planGrids, distance);

        if (billPlanGrid == null) {
            return false;
        }

        if (planSpeed > MAX_ADSL_SPEED) {
            int vdslSpeed = billPlanGrid.getVdslSpeed();
            if (planSpeed <= vdslSpeed) {
                return true;
            }
        } else {
            int adslSpeed = billPlanGrid.getAdslSpeed();
            if (planSpeed <= adslSpeed) {
                return true;
            }
        }

        return false;

    }

    private static BillPlanGrid getPlanGrid(Map<Integer, BillPlanGrid> planGrids, String distance) {
        double actualDistance = EdslDataUtils.convertStringToDouble(distance);
        Iterator<Integer> minDistances = planGrids.keySet().iterator();
        while (minDistances.hasNext()) {
            int minDistance = minDistances.next();
            if (actualDistance >= minDistance) {
                BillPlanGrid planGrid = planGrids.get(minDistance);
                if (planGrid.getMaxDistance() >= actualDistance) {
                    return planGrid;
                }
            }
        }
        return null;
    }

    private static boolean isValidPlan(BillPlanDetail billPlanDetail, Map<String, Integer> fetchPlanDetailsFromDB,List<String> eligibityIdentifiers) {
        if (billPlanDetail.getWebEnabled() != null) {
            WebEnabled webEnabled = billPlanDetail.getWebEnabled();
            if (webEnabled.getServiceSpecification() != null) {
                ServiceSpecification serviceSpecification = webEnabled.getServiceSpecification();
//                if (("E".equals(serviceSpecification.getEligibilty()))) {
//                    return true;
//                }
                if(eligibityIdentifiers.contains(serviceSpecification.getEligibilty())) {
                	 return true;
                }
            }

        }
//		if (null != billPlanDetail.getProductOfferingPrice()) {
//			planType = billPlanDetail.getProductOfferingPrice().getBillPlanCategory();
//		}
//
//		if (null != billPlanDetail.getProductSpecification()) {
//			productNumber = billPlanDetail.getProductSpecification().getProductNumber();
//		}
//
//		switch (planType) {
//		case DSLConstant.MONTHLY_BILL_PLAN:
//			return true;
//		case DSLConstant.ARP_MONTHLY:
//				return true;
//		case DSLConstant.ARP_BILL_PLAN:
//			if (fetchPlanDetailsFromDB.containsKey(productNumber)) {
//				return true;
//			}
//			break;
//		default:
//			return false;
//		}

        return false;

    }


    private static boolean isThisIsTopUp(BillPlanDetail billPlanDetail, HashMap<String, List<TopUpDetailsBean>> touUpMap) {

        if(billPlanDetail.getProductOffering()!=null && billPlanDetail.getProductOffering().getProduct()!=null && billPlanDetail.getProductOffering().getProduct().getProductSpecification()!=null && billPlanDetail.getProductOffering().getProduct().getProductSpecification().getProductSpecCharacteristic()!= null) {
            if("NONARP".equalsIgnoreCase(billPlanDetail.getProductOffering().getProduct().getProductSpecification().getProductSpecCharacteristic().getType())){
                if(touUpMap.containsKey(billPlanDetail.getProductSpecification().getProductNumber())) {
                    TopUpDetailsBean topUpDetails=new TopUpDetailsBean();
                    if(billPlanDetail.getProductOffering().getProduct().getOneTimeChargeProdOfferPriceCharge()!=null) {
                        if(billPlanDetail.getProductOffering().getProduct().getOneTimeChargeProdOfferPriceCharge().getPrice()!=null) {
                            topUpDetails.setAmount(Double.parseDouble(billPlanDetail.getProductOffering().getProduct().getOneTimeChargeProdOfferPriceCharge().getPrice()));
                        }else {
                            topUpDetails.setAmount(0.0);
                        }
                    }else {

                        topUpDetails.setAmount(0.0);//
                    }

                    topUpDetails.setName(billPlanDetail.getProductOffering().getProduct().getProductSpecification().getProductSpecCharacteristic().getName());
                    topUpDetails.setSchemeId(billPlanDetail.getProductOffering().getProduct().getProductSerialNumber());
                    touUpMap.get(billPlanDetail.getProductSpecification().getProductNumber()).add(topUpDetails);

                }else {
                    List<TopUpDetailsBean> toList=new ArrayList<TopUpDetailsBean>();
                    TopUpDetailsBean topUpDetails=new TopUpDetailsBean();
                    if(billPlanDetail.getProductOffering().getProduct().getOneTimeChargeProdOfferPriceCharge()!=null) {
                        if(billPlanDetail.getProductOffering().getProduct().getOneTimeChargeProdOfferPriceCharge().getPrice()!=null) {
                            topUpDetails.setAmount(Double.parseDouble(billPlanDetail.getProductOffering().getProduct().getOneTimeChargeProdOfferPriceCharge().getPrice()));
                        }else {
                            topUpDetails.setAmount(0.0);
                        }
                    }else {

                        topUpDetails.setAmount(0.0);//
                    }

                    topUpDetails.setName(billPlanDetail.getProductOffering().getProduct().getProductSpecification().getProductSpecCharacteristic().getName());
                    topUpDetails.setSchemeId(billPlanDetail.getProductOffering().getProduct().getProductSerialNumber());
                    toList.add(topUpDetails);
                    touUpMap.put(billPlanDetail.getProductSpecification().getProductNumber(), toList);
                }

                if("MONTHLY".equalsIgnoreCase(billPlanDetail.getProductOfferingPrice().getBillPlanCategory())){
                    return false;
                }


                return true;
            }

            return false;
        }
        return false;
    }
    
    private static  List<MyDslPlanBean>  checkIfArpIsThereWithoutMonthly(List<MyDslPlanBean> myDslPlanBeanList, CustomPlanList monthlyPlans) {
    	
  		LOGGER.info("checkIfArpIsThereWithoutMonthly >>>> {}  monthlyPlans {} ",myDslPlanBeanList,monthlyPlans);
  		List<String> planCode=new ArrayList<String>();
  		for (MyDslPlanBean myDslPlanBean : monthlyPlans) {
  			planCode.add(myDslPlanBean.getPlanCode());
  		}

        /***
         * [FLBPL994249, FLBPL994250, FLBPL994257, FLBPL994193, FLBPL994342, FLBPL994536,
         * FLBPL994546, FLBPL994553, FLBPL994561, FLBPL994562, FLBPL994570, FLBPL994571,
         * FLBPL994574, FLBPL994575, FLBPL994578]
         */
  		LOGGER.info("checkIfArpIsThereWithoutMonthly  planCode >>>> {}  ",planCode);

  		  List<MyDslPlanBean> myDslPlanBeanListNew = new ArrayList<>();
  		for (MyDslPlanBean myDslPlanBean : myDslPlanBeanList) {
  			
  			if(myDslPlanBean.getActualPlanType().equalsIgnoreCase(DSLConstant.ARP)) {
  				myDslPlanBeanListNew.add(myDslPlanBean);
  			}else if(planCode.contains(myDslPlanBean.getPlanCode())) {
  				myDslPlanBeanListNew.add(myDslPlanBean);
  			}
  			
  		}
  		LOGGER.info("checkIfArpIsThereWithoutMonthly  myDslPlanBeanListNew >>>> {}  ",myDslPlanBeanListNew);
  		return myDslPlanBeanListNew;
  		
  	}


}