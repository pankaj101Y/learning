package com.example.learnings.edsl.data;



public class CommonEdslRuntimeException extends EDSLBaseRuntimeException{

	private static final long serialVersionUID = 1L;

	public CommonEdslRuntimeException(ResponseErrorCode errorCode, String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(errorCode, message, cause, enableSuppression, writableStackTrace);
	}
	
	public CommonEdslRuntimeException(ResponseErrorCode errorCode) {
		super(errorCode);
	}

}
