package com.example.learnings.edsl.data;//package com.airtel.pe.eDSL.common.constant;

import org.springframework.http.HttpStatus;

public enum ResponseErrorCode {

	// response code corresponding to valid case of data not found
	NO_DATA_FOUND(4041, "No Data Found", HttpStatus.BAD_REQUEST),
	
	CAF_ALREADY_PRESENT(4131, "Caf number is already generated. Please try again from the login page", HttpStatus.BAD_REQUEST),
	
	ONLINE_PAYMENT_CALLBACK(4543, "Your Payment is not Processed Properly", HttpStatus.CONFLICT),


	IFSC_CODE_NOT_FOUND(4090, "Invalid entry! Please enter a valid IFSC code", HttpStatus.BAD_REQUEST),
	// this response code is expected when data store is not consistent
	ERRORED_DATA(4042, "Corrupted data", HttpStatus.BAD_REQUEST),

	INVALID_CASE_STATEMENT(4043, "Invalid case statement", HttpStatus.NOT_FOUND),

	RUNTIME_BUSINESS_EXCEPTION(4171, "Some error occur while processing", HttpStatus.EXPECTATION_FAILED),

	DATA_ACCESS_EXCEPTION(4172, "Some error occur while database operation", HttpStatus.EXPECTATION_FAILED),

	EDSL_SERVICE_EXCEPTION(4174, "Error while calling edsl service", HttpStatus.EXPECTATION_FAILED),

	EDSL_RESPONSE_PARSE_EXCEPTION(4175, "Error while parsing reponse from edsl", HttpStatus.EXPECTATION_FAILED),

	INVALID_REQUEST(4001, "Invalid Request, please try again with valid request", HttpStatus.BAD_REQUEST),

	INVALID_MSISDN(4002, "Invalid number. Please enter a valid mobile number.", HttpStatus.BAD_REQUEST),

	INVALID_PINCODE(4003, "Invalid Request, Enter a valid Pin Code. ", HttpStatus.BAD_REQUEST),

	INVALID_GENDER(4004, "Invalid Request, Enter a valid Gender Field. ", HttpStatus.BAD_REQUEST),

	TOKEN_EXPIRED(4011, "Token is expired", HttpStatus.UNAUTHORIZED),

	TOKEN_INTEGRITY_FAILED(4012, "Token integrity failed", HttpStatus.UNAUTHORIZED),

	TOKEN_INVALID(4013, "Invalid Token. ", HttpStatus.UNAUTHORIZED),

	INVALID_USER_ROLE(4014, "Selected Role is not assigned to user", HttpStatus.UNAUTHORIZED),

	AUTHENTICATION_FAILED(4045, "Username or password is incorrect", HttpStatus.UNAUTHORIZED),

	OTP_VERIFICATION_FAILED(4046, "OTP couldnot be verified", HttpStatus.UNAUTHORIZED),

	FILE_HANDELING_ERROR(4173, "Error while file handling operations in system ", HttpStatus.EXPECTATION_FAILED),

	EMPTY_FILE(4001, "File is empty, please upload correct file", HttpStatus.BAD_REQUEST),

	DUPLICATE_ENTITY(4091, "Entity already exist", HttpStatus.CONFLICT),

	CAF_ALREADY_SUBMITTED(4092, "Caf already submitted", HttpStatus.CONFLICT),

	OTP_EXPIRED(4093, "OTP Expired. Please Re-generate OTP.", HttpStatus.UNAUTHORIZED),

	MOBILE_NOT_FOUND(4094, "Mobile Number is not updated in the system. Please contact system administrator",
			HttpStatus.UNAUTHORIZED),

	INTERNAL_SERVICE_ERROR(5001, "Internal Service error has occurred", HttpStatus.INTERNAL_SERVER_ERROR),

	BAD_GATEWAY(5021, "Unknown/Uncaught error has occurred", HttpStatus.BAD_GATEWAY),

	GATEWAY_TIMEOUT(5041, "Service call has timed out. Please try again later", HttpStatus.GATEWAY_TIMEOUT),

	FILE_EXTENSION_INVALID(4010, "File Extension is not valid", HttpStatus.BAD_REQUEST),

	FSE_PINCODE_INVALID(4020, "Sorry! This is an outstation pincode.", HttpStatus.BAD_REQUEST),

	PINCODE_STDCODE_INVALID(4030, "No valid std code found for pincode", HttpStatus.BAD_REQUEST),

	DONGLE_ERROR(4042, "Sorry! This is a data card number. Please enter a valid mobile number only.",
			HttpStatus.NOT_FOUND),
	
	INVALID_ONLINE_PAYMENT(5004, "Online Payment deposited is not valid.",
			HttpStatus.INTERNAL_SERVER_ERROR),

	AADHAAR_ERROR(3501, null, HttpStatus.BAD_REQUEST),

	BILL_PLAN_INVALID_RESPONSE(3502, null, HttpStatus.BAD_REQUEST),

	FAULT_INVALID(3053, null, HttpStatus.CONFLICT),

	DATA_EXCEPTION(3054, null, HttpStatus.EXPECTATION_FAILED),
	
	INBOX_EXCEPTION(3054, "Error fetching inbox details", HttpStatus.EXPECTATION_FAILED),
	INBOX_FSE_EXCEPTION(5008, "FSE Code not found", HttpStatus.EXPECTATION_FAILED),
	INBOX_FSE_DATA_EXCEPTION(5009, "No data found for the provided criteria", HttpStatus.EXPECTATION_FAILED),
	FTTH_DATA_NOT_FOUND(5010, "No data found for the given RSU in the fse circle", HttpStatus.NOT_FOUND),


	STD_CODE_NOT_FOUND(3055, "Sorry! The entered pincode is not a serviceable area.", HttpStatus.BAD_REQUEST),

	AREA_NOT_WIRED(3056, "Sorry! This area is not wired.", HttpStatus.BAD_REQUEST),

	SYSTEM_NOT_WORKING(5002, "Oops! There seems to be some issue in the system. Please try again",
			HttpStatus.INTERNAL_SERVER_ERROR),

	NETWORK_CHOKED(5003, "Sorry! This network element is currently choked. Please select another network element",
			HttpStatus.INTERNAL_SERVER_ERROR),

	NETWORK_NOT_AVAILABLE(5004,
			"Sorry! This network element is currently not available. Please select another network element",
			HttpStatus.INTERNAL_SERVER_ERROR),
	
	INVALID_SFO_CODE(5005, "SFO Code is invalid", HttpStatus.BAD_REQUEST),
	
	INVALID_POS_CODE(5005, "Pos Code is invalid", HttpStatus.BAD_REQUEST),
	
	INVALID_SALES_CHANNELID_CODE(5005, "Sales Channel Id is invalid", HttpStatus.BAD_REQUEST),
	
	INVALID_CIRCLEID_CODE(5005, "Circle Id is invalid", HttpStatus.BAD_REQUEST),

	AGE_NOT_VALID(5005, "Customer don't have valid age to get connection", HttpStatus.INTERNAL_SERVER_ERROR),
	
	INVALID_VERSION(5006, "Version is not Updated", HttpStatus.BAD_REQUEST),
	
	SERVICE_NOT_AVAILABLE(5007, "Service is not available",HttpStatus.INTERNAL_SERVER_ERROR),
	
	NMS_SERVICE_NOT_AVAILABLE(5007, "NMS Service is not available",HttpStatus.INTERNAL_SERVER_ERROR),
	
	CRM_SERVICE_NOT_AVAILABLE(5007, "CRM Service is not available",HttpStatus.INTERNAL_SERVER_ERROR),
	
	SERVICE_DOWN(5008, "Service is down",HttpStatus.INTERNAL_SERVER_ERROR),
	
	GOLD_RUSH_OFFER_NOT_AVAILABLE(5008, "Gold Rush Offer is not available", HttpStatus.INTERNAL_SERVER_ERROR),
	
	ENCRYPTION_ERROR(5009, "Error while encrypting response", HttpStatus.INTERNAL_SERVER_ERROR),

	PINCODE_NOT_FOUND(5010, "Pincode not found", HttpStatus.BAD_REQUEST),

	ADDRESS_NOT_VALID(5011,"Address length should be less than 275",HttpStatus.INTERNAL_SERVER_ERROR),
	BAD_REQUEST_ERROR(400,"Bad request error",HttpStatus.BAD_REQUEST),
	INVALID_INSTALLATION_ADDRESS(5012,"Please provide Installation Address",HttpStatus.BAD_REQUEST),
	INVALID_FEASIBILITY_RESPONSE(5013,"Invalid Feasibility response",HttpStatus.BAD_REQUEST),
	AGENT_NOT_VALID(5014,"Access denied due to invalid mapping of SFO/POS/CHANNEL code between eCAF and CRM/NMS.Please contact circle spoc.",HttpStatus.INTERNAL_SERVER_ERROR),
	TM_CIRCLE_NOT_FOUND(5015,"circle code not valid",HttpStatus.INTERNAL_SERVER_ERROR),
	RSU_NOT_VALID(5016,"RSU does not serve in entered install pincode",HttpStatus.INTERNAL_SERVER_ERROR),
	NETWORK_CITY_NOT_FOUND(5017,"Network city not found for this pincode",HttpStatus.INTERNAL_SERVER_ERROR),
	PAYMENT_ALREADY_RECIEVED(5018,"Payment for this caf is already recieved",HttpStatus.INTERNAL_SERVER_ERROR),
	OTP_SEND_LIMIT_REACHED(5019,"Your otp resend limit reached.Please wait for 20 minutes",HttpStatus.INTERNAL_SERVER_ERROR),
	NO_STD_CODE_FOUND(5020, "No std code found for store pincode.Please contact circle spoc", HttpStatus.BAD_REQUEST),
	NMS_CITY_NOT_FOUND(5021, "Nms city against installation pincode is not valid.", HttpStatus.BAD_REQUEST),
	PINCODE_NOT_FOUND_CRM(5010, "Mismatch of   pincode or city between ecaf and crm", HttpStatus.BAD_REQUEST),
	PDF_CONSUME_ERROR(5011, "consumed response from PDF is null", HttpStatus.BAD_REQUEST),
	CITY_MISMATCH_CRM(5012, "city name mismatch for this pincode in CRM", HttpStatus.BAD_REQUEST),
	MAX_RETRY_ATTEMPTS_REACHED(5013,"maximum retry for this order reached",HttpStatus.BAD_REQUEST),
	RSU_INVALID(5014,"RSU code is invalid",HttpStatus.BAD_REQUEST),
	TECHNOLOGY_INVALID(5015,"Technology is not valid",HttpStatus.BAD_REQUEST),
	CONTACT_ADDRESS_NOT_VALID(5016,"Contact address length should be less than 225",HttpStatus.BAD_REQUEST),
	INSTALLATION_ADDRESS_NOT_VALID(5017,"Installation address length should be less than 225",HttpStatus.BAD_REQUEST),
	BILLTO_ADDRESS_NOT_VALID(5018,"Billing  address length should be less than 225",HttpStatus.BAD_REQUEST),
	SCHEME_ID_INVALID(5019,"SchemeId for the order  is invalid",HttpStatus.BAD_REQUEST),
	CIRCLE_PROPERTY_ERROR(5020,"Invalid Circle Id",HttpStatus.BAD_REQUEST),
	NE_NAME_NOT_VALID(5021,"Invalid ne name",HttpStatus.BAD_REQUEST),
	ADDRESS_EDIT_ERROR(5022,"Installation address can not be edited",HttpStatus.INTERNAL_SERVER_ERROR),
	BILLPLAN_EDIT_ERROR(5023,"bill plan  can not be edited",HttpStatus.INTERNAL_SERVER_ERROR),
	TELEPHONE_NUMBER_EDIT_ERROR(5024,"customer number can not be edited",HttpStatus.INTERNAL_SERVER_ERROR),
	CAF_NUMBER_EDIT_ERROR(5025,"caf number can not be edited",HttpStatus.INTERNAL_SERVER_ERROR),
	REPUSH_LIMIT_ERROR(5026,"repush limit surpassed.",HttpStatus.INTERNAL_SERVER_ERROR),
	REPUSH_STATUS_ERROR(5027,"Mismatch of repush status.",HttpStatus.INTERNAL_SERVER_ERROR),
	ACTIVATION_COST_PINCODE_ERROR(5028,"Activation cost not found for given pincode",HttpStatus.BAD_REQUEST),
	
	EV_STATUS_NOT_VALIDE_ERROR(5029,"EV status is not accepted ",HttpStatus.BAD_REQUEST),
	GST_TRADENAME_INVALID(5030,"GST trade name is invalid",HttpStatus.BAD_REQUEST),
	GST_NUMBER_INVALID(5031,"GST number is invalid",HttpStatus.BAD_REQUEST),
	GST_NUMBER_OUTSTATION(5032, "Installation address and GSTIN address should be of same state/UT", HttpStatus.BAD_REQUEST),
	//for Cart
	PLAN_REQUEST_NULL(201,"Plan request is null",HttpStatus.BAD_REQUEST),
	REQUEST_NULL(201,"Request is null",HttpStatus.BAD_REQUEST),
	CRM_PLAN_FETCH_FAIL(201,"Error fetching plans/Pincode not valid",HttpStatus.BAD_REQUEST),
	PLAN_NOT_FEASIBILE(201,"No plans found",HttpStatus.BAD_REQUEST),
	FETCH_BUILDING_RSU_ERROR(5033,"Error While fetching data",HttpStatus.BAD_REQUEST),
	FETCH_BUILDING_RSU_INVALID_REQ(5034,"Invalid request ",HttpStatus.BAD_REQUEST),
	FETCH_BUILDING_RSU_INVALID(5035,"rsu can't be null or empty",HttpStatus.BAD_REQUEST),
	FETCH_BUILDING_RSU_NO_DATA(5036,"No data found for given rsu",HttpStatus.BAD_REQUEST),
	OTP_VALIDATION_ERROR(5000, "Error while validating OTP", HttpStatus.INTERNAL_SERVER_ERROR),
	POA_POI_VALIDATION(5037,"POA POI can't be null or empty",HttpStatus.BAD_REQUEST),
	INVALID_POA_VALIDATION(5038,"Invalid POA type",HttpStatus.BAD_REQUEST),
	INVALID_POI_VALIDATION(5039,"Invalid POI type",HttpStatus.BAD_REQUEST),
	DSL_CONFIG_VALIDATION_ERROR(5040,"DSL config value can't be null",HttpStatus.BAD_REQUEST),
	INVALID_DSL_CONFIG(5040,"Invalid Dsl config value",HttpStatus.BAD_REQUEST),
	POA_VALIDATION(5037,"POA can't be null or empty",HttpStatus.BAD_REQUEST),
	POI_VALIDATION(5037,"POI can't be null or empty",HttpStatus.BAD_REQUEST),
	SOURCE_ELIGIBILITY_MAPPING_NOT_EXIST(5041,"Eligibility identifiers not mapped with requested source in eDSL",HttpStatus.BAD_REQUEST),
	RSU_CITY_MISMATCH(5042,"Mismatch in Installation City & RSU City details. Kindly enter correct values.",HttpStatus.BAD_REQUEST);




	ResponseErrorCode(int code, String description, HttpStatus httpStatus) {
		this.code = code;
		this.description = description;
		this.httpStatus = httpStatus;
	}

	private int code;
	private String description;
	private HttpStatus httpStatus;

	public int getCode() {
		return code;
	}


	public String getDescription() {
		return description;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	@Override
	public String toString() {
		return String.valueOf(this.code);
	}
}
