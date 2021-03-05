package com.example.learnings.edsl.data;//package com.airtel.pe.eDSL.common.exception;


public class EDSLBaseRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 4016401261669137624L;

	private ResponseErrorCode errorCode;
	
	public EDSLBaseRuntimeException(ResponseErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public EDSLBaseRuntimeException(ResponseErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public EDSLBaseRuntimeException(ResponseErrorCode errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public EDSLBaseRuntimeException(ResponseErrorCode errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	protected EDSLBaseRuntimeException(ResponseErrorCode errorCode, String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorCode = errorCode;
	}


	public ResponseErrorCode getErrorCode() {
		return errorCode;
	}


	
	
}
