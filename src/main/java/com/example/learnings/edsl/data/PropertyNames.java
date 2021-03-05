package com.example.learnings.edsl.data;//package com.airtel.pe.eDSL.common.constant;

public interface PropertyNames {


	public String REDIS_MAX_TOTAL = "com.redis.max.total";
	public String REDIS_MAX_IDLE = "com.redis.max.idle";
	public String REDIS_MIN_IDLE = "com.redis.min.idle";

	public String SENTINEL_IP_VALUE = "com.redis.sentinal.ip";
	public String MASTER_SENTINEL = "com.redis.sentinel.master";

	public String PUBLIC_ENCRYPTION_KEY_PATH = "com.interceptors.security.public.keypath";
	public String ENCRYPTION_KEY_PATH = "com.interceptors.security.keypath";
	public String GET_RESOURCE_LIST_URL = "esb.dsl.resource.list.url";
	public String RESOURCE_FEASIBILITY_URL = "esb.dsl.resource.feasibility.url";
	public String NEW_GET_RESOURCE_LIST_URL = "esb.dsl.new.resource.list.url";
	public String DSL_BILL_PLAN_URL = "esb.dsl.my.plan.url";
	public String ONLINE_PAYMENT_URL = "online.payment.url";
	public String NMS_URL = "esb.dsl.nms.url";
	//public String SUBMIT_ORDER_URL = "esb.dsl.submit.order.url";
	public String OPUS_SUBMIT_TASK_URL = "opus.submit.task.url";

	public String AADHAR_AUTH_URL = "esb.dsl.aadhaar.auth.url";
	public String AADHAR_KYC_URL = "esb.dsl.aadhaar.kyc.url";
	
	public String AADHAR_AUTH2_URL = "esb.dsl.aadhaar.auth2.url";
	public String AADHAR_KYC2_URL = "esb.dsl.aadhaar.kyc2.url";
	
	public String SOLACE_QUEUE_URL = "dsl.solace.queue.url";
	
	public String SOLACE_QUEUE_USERNAME = "dsl.solace.queue.username";
	public String SOLACE_QUEUE_PASSWORD = "dsl.solace.queue.password";
	
	public String SOLACE_CONNECTION_FACTORY = "dsl.solace.connection.factory";
	public String SOLACE_QUEUE_NAME = "dsl.solace.queue.name";

	public String AADHAAR_REGEX = "aadhaar.regex";

	public String STUB_LIST = "dsl.stub.list";
	public String CHEQUE_FILE_PATH = "cheque.file.path";

	public String HTTP_CONNECTION_TIME_OUT = "http.connection.request.timeout";
	public String HTTP_READ_TIME_OUT = "http.read.timeout";
	public String HTTP_SOCKET_TIME_OUT = "http.socket.timeout";

	public String NDS_PROFILE_URL = "nds.customer.profile.url";
	public String NDS_PROFILE_SERVICE_NAME = "nds.customer.profile.service.name";
	public String NDS_PROFILE_PORT_NAME = "nds.customer.profile.port.name";

	public String REQUEST_ID_STRING = "request.id.thread";

	public String SHORT_CODE_NAME = "short.code.name";
	public String MB_TEXT_FORMAT = "mb.sms.format.ftl";
	public String MB_USERNAME = "mb.username";
	public String MB_PASSWORD = "mb.password";
	public String MB_URL = "mb.url";
	public String PAYMENT_MSG_URL = "payment.message.online";
	public String ONLINE_PAYMENT_LINK = "Online.Payment.Link";
	public String ORDER_SUBMITTED_SUCCESS_MSG = "order.submit.message.online";
	public String ONLINE_PAYMENT_MESSAGE = "online.payment.messgae";
	public String TOP_UP="topup.name";
	
	public String FEASIBILITY_TASK_POOL_SIZE = "feasibility.task.pool.size";
	
	public String CAF_PDF_FORM_PATH = "edsl.caf.pdf.form.path";
	public String CAF_PDF_CREATION_PATH = "edsl.caf.pdf.creation.path";
	
	public String DEFAULT_INBOX_DAYS = "default.edsl.inbox.days";
	public String FAILED_TASK_SUBMIT_DELAY = "failed.task.submit.delay.minutes";
	public String FAILED_TASK_PROCESS_DELAY = "failed.task.process.delay.minutes";
	public String FAILED_TASK_SUBMIT_PERIOD = "failed.task.submit.period.minutes";
	public String FAILED_TASK_PROCESS_PERIOD = "failed.task.process.period.minutes";
	public String FAILED_TASK_RETRY_ATTEMPTS = "failed.task.retry.attempts";
	public String IS_NEW_FEASIBILITY_WORKING = "is.new.feasibility.working";
	public String GST_RATE = "gst.rate";
	
	public String CIRCUIT_BREAKER_THRESHOLD = "circuit.breaker.threshold";
	public String CIRCUIT_BREAKER_TIMEOUT = "circuit.breaker.timeout(in seconds)";
	
	
	public String VID_AADHAR_REGEX = "eDSL.vid.regex";
	public String VID_AUTH_URL = "eDSL.vid.auth.url";
	public String VID_KYC_URL = "eDSL.vid.kyc.url";
	public String VID_OTP_URL = "eDSL.vid.otp.url";


	String CMS_AGENT_DETAILS_URL = "cms.agent.details.url";
	String CMS_AGENT_DETAILS_UPDATE_URL = "cms.agent.details.update.url";

	String FTTH_DSL_TECH = "ftth.dsl.tech";
	String FTL_DIRECTORY_PATH = "ftl.directory.path";

	String CAF_NO_PREFIX = "caf.no.prefix";

	String  CAF_NO_REPUSH_DAYS_THRESOLD = "caf.no.repush.days.thresold";
	
	String FEASIBILITY_URL="feasibility.url";
	String NO_OF_NE="no.of.network.element";
	public String DSL_BILL_PLAN_URL_NEW = "esb.dsl.my.plan.new.url";
	public String ONLINE_PAYMENT_LINK_NEW = "Online.Payment.Link.new";
	
	
	
	// LMS config
	String LMS_CREATE_LEAD_TOPIC_URL="dsl.solace.lms.create.http.topic";
	String LMS_CREATE_LEAD_TOPIC_USER="dsl.solace.lms.topic.producer.username";
	String LMS_CREATE_LEAD_TOPIC_PASS="dsl.solace.lms.topic.producer.password";
	String LMS_UPDATE_MILSTONE_TOPIC_URL="dsl.solace.lms.ml.http.topic";
	String LMS_UPDATE_MILSTONE_TOPIC_USER="dsl.solace.lms.topic.ml.username";
	String LMS_UPDATE_MILSTONE_TOPIC_PASS="dsl.solace.lms.topic.ml.password";
	
	
	//SMS RETRIGGERED PROP
	String ONLINE_PAYMENT_LINK_RETRY_TIME="payment.sms.retry.time";
	String DELAY_SOLACE_QUEUE_NAME="retry.queue.name";
	//retry nms delayed time
	String RETRY_NMS_DELAYED_TIME="retry.submit.queue.time";
	
	
	//List of configured gender type
	String GENDER_TYPE_LIST="edsl.gender.type.list";
	//Profiling flag


	String PROFILING_FLAG="profiling.flag";

	interface ProfileType {
		String LOCAL = "local";
		String DEV = "dev";
		String SIT = "sit";
		String BETA = "beta";
		String PROD = "prod";
	}

	
	//Eligible identifiers for plans
	String PLANS_ELIGIBLE_IDENTIFIERS="edsl.plans.eligible.indentifiers";
	String ELIGIBLILITY_CATEGORY_SOURCES_LIST = "edsl.plans.eligible.sources.list";
	
	//source mapping for CRM
	
	String CRM_SOURCE_MAPPING="edsl.crm.source.mapping";
	
	
	//new Message property 
	
	public String EDSL_ORDER_SUBMITTED_SUCCESS_MSG = "edsl.order.submit.message";
	
	public String EDSL_OTP_SMS = "edsl.otp.send.message";
	public String EDSL_OTP_SMS_BETA = "edsl.otp.send.message.beta";
	public String EDSL_CUTOMER_OTP_SMS = "edsl.cutomer.otp.message";
	public String EDSL_CUTOMER_OTP_SMS_BETA = "edsl.cutomer.otp.message.beta";
	public String EDSL_RSUTYPE_SPEED = "edsl.rsu.type.speed";
	
	
	public String EDSL_UPFRONT_AMOUNT_FLAG = "edsl.upfront.amount.flag";
	public String EDSL_UPFRONT_AMOUNT_FLAG_BETA = "edsl.upfront.amount.flag.beta";
	public String EDSL_OTPSMS_ADDRESS_FLAG = "edsl.otp.sms.address.flag";
	public String EDSL_OTPSMS_ADDRESS_FLAG_BETA= "edsl.otp.sms.address.flag.beta";
	
	//rabbitMQ config
    String CART_RABBITMQ_QUEUE = "cart.edsl.rabbitMQ.queue";
    String CART_RABBITMQ_QUEUE_EXCHANGE = "edsl.cart.rabbitMQ.exchange";
    String CART_RABBITMQ_QUEUE_ROUTINGKEY = "edsl.cart.rabbitMQ.routingkey";
    
    String CART_RABBITMQ_QUEUE_ENABLED = "edsl.cart.rabbitMQ.enabled";
    
    
    //CRM Commercail submit order
    public String SUBMIT_ORDER_URL_BETA = "edsl.crm.submitorder.url.beta";
    
    //New crm submitorder URL
    public String SUBMIT_ORDER_URL = "edsl.crm.submitorder.url";
	public String CRM_SUBMIT_ORDER_URL_USERNAME = "edsl.crm.submitorder.url.username";
	public String CRM_SUBMIT_ORDER_URL_PASSWORD = "edsl.crm.submitorder.url.password";
    
    
   
    //New Feasibility flow fetch building URL
    public String EDSL_BUILDING_NE_BY_RSU = "edsl.building.rsu.url";
    
    public String EDSL_FIND_FEASIBILITY_URL = "edsl.find.feasiblity.url";
    
    public String ADDRESS_LOGIC_FLAG = "edsl.address.division.flag";
    public String EDSL_TECH_LIST = "edsl.tech.list";
    
    //Cart rabbit config
    String EDSL_CART_RABBITMQ_HOST = "edsl.cart.rabbitmq.host";
	String EDSL_CART_RABBITMQ_PORT = "edsl.cart.rabbitmq.port";
	String EDSL_CART_RABBITMQ_VIRTUALHOST = "edsl.cart.rabbitmq.virtual-host";
	String EDSL_CART_RABBITMQ_USERNAME = "edsl.cart.rabbitmq.username";
	String EDSL_CART_RABBITMQ_PASSWORD = "edsl.cart.rabbitmq.password";
	String EDSL_CART_RABBITMQ_QUEUENAME = "edsl.cart.rabbitmq.queue";
	String EDSL_CART_RABBITMQ_EXCHANGE = "edsl.cart.rabbitmq.exchange";
	String EDSL_CART_RABBITMQ_ROUTINGKEY = "edsl.cart.rabbitmq.routingKey";
	String EDSL_CART_RABBITMQ_MAX_THREAD_POOL_SIZE = "edsl.cart.rabbitmq.max.threadpool.size";
	String EDSL_CART_RABBITMQ_CORE_THREAD_POOL_SIZE = "edsl.cart.rabbitmq.core.threadpool.size";
	String EDSL_CART_RABBITMQ_EXCHANGE_TYPE = "edsl.cart.rabbitmq.exchange.type";
	String EDSL_CART_RABBITMQ_CONNECTION_TIMEOUT = "edsl.cart.rabbitmq.connection.timeout";
	String EDSL_CART_RABBITMQ_REQUEST_TIMEOUT = "edsl.cart.rabbitmq.request.timeout";
	String EDSL_CART_RABBITMQ_MAX_QUEUE_SIZE = "edsl.cart.rabbitmq.max.queue.size";
	String EDSL_CART_CAMEL_CONFIG_FLAG="edsl.cart.camel.config.flag";
	
	
	///Rsu config
	String EDSL_RSU_RADIUS_VALUE="edsl.rsu.radius.value";
	String EDSL_NE_TYPE_LIST="edsl.ne.type.list";
	String EDSL_GET_NEAREST_RSU_URL="edsl.get.nearest.rsu.url";

	// specail char list to be removed
	String EDSL_TRADE_NAME_SPECAIL_CHAR="edsl.tradename.specail.characters";
	String EDSL_NAME_SPECAIL_CHAR="edsl.name.specail.characters";
	String EDSL_ADDRESS_SPECAIL_CHAR="edsl.address.specail.characters";
	
	String EDSL_RSU_VALIDATION_FLG="edsl.rsu.city.validation.flag";
	//Cart plans flags

	String EDSL_CART_PLAN_SPEED_FLAG="edsl.cart.plan.speed.flag";
	
	String EDSL_CRM_TECH_CONFIG_LIST="edsl.crm.tech.config.list";
	String EDSL_TECH_WISE_NE_TYPE="edsl.tech.wise.ne.type";

	


}
