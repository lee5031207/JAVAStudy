package common.exception;

import common.code.ErrorCode;

public class ToAlertException extends CustomException{

	public ToAlertException(ErrorCode error) {
		super(error);
	}
	
	public ToAlertException(ErrorCode error, Exception e) {
		super(error,e);
	}
}
