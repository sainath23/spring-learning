package com.doitgeek.springformdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerCodeConstraintValidator implements ConstraintValidator<CustomerCode, String> {
	
	private String codePrefix;
	
	public void initialize(CustomerCode customerCode) {
		this.codePrefix = customerCode.value();
	}

	public boolean isValid(String code, ConstraintValidatorContext context) {
		boolean result;
		if(code != null)
			result = code.startsWith(codePrefix);
		else
			result = true;
		return result;
	}

}
