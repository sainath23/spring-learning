package com.doitgeek.springformdemo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CustomerCodeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface CustomerCode {

	// Define default customer code
	public String value() default "CUST";
	
	// Define default error message
	public String message() default "must start with CUST";
	
	// Define default groups
	public Class<?>[] groups() default {};
	
	// Define default payloads
	public Class<? extends Payload>[] payload() default{};
}
