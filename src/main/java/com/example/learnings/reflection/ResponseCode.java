package com.example.learnings.reflection;

public enum ResponseCode {

    SUCCESS(200, "SUCCESS"),

    CART_SAVE(200, "Cart Saved successfully"),

    //4-5 REQUEST_ERROR
    INVALID_PARAMETER(4000, "Your request could not be served by the system. Please try again!"),

    CART_NOT_FOUND(201, "Cart for mobile no[%s with status[%s] not found!"),

    EMPTY_CART_ID(201, "Input Cart Id is empty"),

    COMMON_CART_NOT_FETCHED(201, "Cart for mobile no[%s' with status[%s] not fetched!"),

    CART_FOR_ID_NOT_FOUND(201, "Cart[%s] not found!"),

    CART_WITH_CART_ID_NOT_FOUND(201, "Cart[%s] with status [%s] not found!"),

    CART_REQUEST_IS_NULL(202, "Cart request received is empty"),

    ALTERNATE_NO_IS_MISSING(203, "Missing phone number in request"),

    CART_STATUS_EXPECTED_AND_FOUND_MISMATCH(204, "Please go to Inbox and try again for cartId [%s] "),

    CREATE_ORDER_ALL_TASK_NOT_COMPLETED(4008, "All tasks are not completed in cart[%s] to create order!"),

    POSTPAID_NUMBER_RESERVE_EXCEPTION(4009, "Not able to reserve number"),

    PREPAID_NUMBER_RESERVE_EXCEPTION(4009, "Not able to reserve number"),

    PREPAID_DUE_DATE_FORMAT_EXCEPTION(4010, "Invalid Due Date [%s] format for PreBooked number"),

    PREPAID_DOWNSTREAM_ERROR(5001, "%s"),

    //5-6 SERVER_ERROR
    INTERNAL_SERVER_ERROR(5000, "Your request could not be served by the system. Please try again!"),

    CONVERTOR_INITIALIZATION_EXCEPTION(5010, "Error while initializing Convertor constructor."),

    CONVERTOR_TARGET_NEW_INSTANCE_CREATION_EXCEPTION(5011, "Error while creating new instance of target in convertor!"),

    //Service down
    ESB_SERVICE_UNREACHABLE(6000, "Timeout from downstream.Please try after sometime!"),

    MBOSS_SERVICE_UNREACHABLE(6001, "Timeout from downstream.Please try after sometime!"),

    MBOSS_SERVICE_EXTERNAL_EXCEPTION(6002, "Your request could not be served by the system. Please try again!"),

    //6-7 SCHEDULER JOB ERROR
    REQUEST_FLOODING(8000, "Multiple request with same data. Please try again!"),

    KYC_WITH_KYC_ID_NOT_FOUND(4015, "Kyc[%s] not found"),

    CLUB_NEW_KYC_WITH_REPUSH_KYC_ERROR(4018, "Can not club new kyc case with repush case"),

    MORE_THAN_ONE_KYC_FOUND_FOR_REPUSH(4019, "More than one kyc found for repush"),

    KYC_STATUS_NOT_REJECTED_FOR_REPUSH(4019, "Kyc state is not in REJECTED state to repush"),

    CART_ITEM_NOT_MATCHED(4020, "Cart item [%s] not present in cart[%s]"),

    CART_SUB_ITEM_NOT_MATCHED(4021, "Cart sub item [%s] not present in cart[%s]"),

    PLAN_UPDATE_TYPE_NOT_VALID(4022, "Plan update type [%s] is not valid"),

    TASK_NOT_FOUND(4023, "task[%s] not found in cart[%s] or cart is in draft state"),

    NO_CART_SUBITEM_FOUND(4024, "No cart sub item found in cart sub ids [%s]"),

    NO_PP_SUBITEM_FOUND(4025, "No Postpaid cart sub item found in cart sub ids [%s]"),

    MORE_THAN_ONE_PP_SUBITEM_FOUND(4026, "More than one postpaid cart sub item found in cart sub ids [%s]"),

    VALIDATION_ERROR(5000, "Request validation failed"),

    HOMES_VALIDATION_ERROR(5000, "Homes order validation failed"),

    HOMES_DOWNSTREAM_ERROR(5001, "%s"),

    SUBMIT_ERROR(4027, "Error while submitting data in back end service"),

    NO_RESPONSE(201, "Could not retrieve data for lead"),

    ALL_TASK_AND_KYC_DONE(203,"All tasks are done and Kyc is completed"),

    INVALID_SIM_NUMBER(409, "Sim is invalid"),

    SIM_VALIDATION(410, "Sim validation: %s"),

    NUMBER_RESERVE(411, "Number reserve: %s"),

    SIM_ERROR(4028, "Error while validating Sim"),

    HOMES_LOB_NOT_FOUND(404, "HomesLob[%s] not found!"),

    HOMES_DTH_DETAILS_FETCH_ERROR(500,"Error while fetching DTH boxes details for Bundle Id = [%s]"),

    CART_IS_NOT_IN_ACTIVE_STATE(4029, "Cart is not in active state"),

    OTP_VALIDATION_ERROR(5000, "OTP validation failed for [%s]"),

    CMS_PROFILE_NOT_FOUND(4004,"No profile found in CMS"),

    TASK_NOT_COMPLETED(4004, "Task[%s] not found in cartSubItem[%s]"),

    HOMES_ORDER_ERROR(5000, "Homes order failed"),

    PENDING_ORDER_FOUND(4030, "Homes pending order found for Si[%s]"),

    PENDING_ORDER_ERROR(5000, "Homes pending order failed for Si[%s]"),

    PENDING_ORDER_HOMES_ERROR(7000, "Error while Fetching Homes pending orders for Si[%s]"),

    ERROR_ADDON_SERVICE_DOWN(4034, "Addon plans service is down, please try later."),

    PLAN_NOT_FOUND(4030, "Selected plan not available - 4030"),

    PLAN_PRICE_NOT_FOUND(4031, "Selected plan not available - 4031"),

    PLAN_PRICE_PARSING_ERROR(4032, "Selected plan not available - 4032"),

    ADDON_PLAN_NOT_FOUND(4033, "Selected addon plan not available - 4033"),

    BOOSTER_PLAN_NOT_FOUND(4035, "Selected booster plan not available."),

    ERROR_BOOSTER_PLAN_SERVICE_DOWN(4036, "Booster plans service is down, please try later."),

    NO_TASKS_FOUND(4040, "No tasks found"),

    CART_ITEMS_NOT_FOUND(4043, "Cart is invalid!"),

    CART_SUB_ITEMS_NOT_FOUND(4044, "Cart is invalid!"),

    INVALID_MAP_STRUCTURE(4036, "Invalid keyVal format"),

    SIM_SWAP_NUMBER_MISSING(4052, "Sim swap number is missing."),

    SIM_SWAP_NUMBER_VERIFICATION_EXCEPTION(4053, "Error occurred while calling simswap number verification request"),

    SIM_SWAP_NUMBER_INVALID(4054, "Selected Simswap number is not Airtel number."),

    SIM_SWAP_SIM_VALIDATION_REQUEST_EXCEPTION(4055, "Error occurred while populating simswap sim validation request"),

    SIM_SWAP_SIM_VALIDATION_API_EXCEPTION(4056, "Error occurred while calling simswap sim validation api"),

    SIM_SWAP_SIM_VALIDATION_ERROR(4057, "Sim Validation Error: [%s]"),

    API_ERROR(5001, "Your request could not be served by the system. Please try again!"),

    INCORRECT_SOURCE(4041, "Source is incorrect"),

    NO_COCP_CART(6000, "No COCP Cart found"),

    NO_MSISDN_IN_CART(6000, "No MSISDN in Cart"),

    EXCEPTION_OCCURRED_IN_MSISDN_LIST(6000, "Error while fetching MsisdnList from Cart"),

    EXCEPTION_OCCURRED_IN_CART_XA(6000, "Error while fetching Msisdn List from Cart"),

    EXCEPTION_OCCURRED_IN_CART_QUOTE_DETAILS(6000, "Error while fetching MsisdnList from Cart"),

    CANCELLED_CART_ERROR(6001,"The cart is in Cancelled state");



    private int code;
    private String description;

     ResponseCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public ResponseCode getCode(final int code) {
        for (final ResponseCode responseCode : ResponseCode.values()) {
            if (responseCode.getCode() == code) {
                return responseCode;
            }
        }
        return INTERNAL_SERVER_ERROR;
    }

    public ResponseCode getResponseCodeByMessage(final String message) {
        for (final ResponseCode responseCode : ResponseCode.values()) {
            if (message.equals(responseCode.getDescription())) {
                return responseCode;
            }
        }
        return INTERNAL_SERVER_ERROR;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
