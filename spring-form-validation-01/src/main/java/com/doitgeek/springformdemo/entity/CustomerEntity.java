package com.doitgeek.springformdemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.doitgeek.springformdemo.validation.CustomerCode;

@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {

	private static final long serialVersionUID = 4771411636288761089L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull(message = "is required")
	@Pattern(regexp = "^[0-9]{10}", message = "Only 10 digits")
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "email")
	private String email;
	
	@NotNull(message = "is required")
	@Min(value = 3, message = "must be greater than or equal to 3")
	@Max(value = 10, message = "must be less than or equal to 10")
	@Column(name = "free_passes")
	private Integer freePasses;
	
	@CustomerCode(value = "MYCUST", message = "must start with MYCUST")
	@Column(name = "customer_code")
	private String customerCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", email=" + email + ", freePasses=" + freePasses + ", customerCode=" + customerCode + "]";
	}
	
}
