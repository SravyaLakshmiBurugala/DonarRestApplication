package com.pack.entity.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="A Donar DTO Model Class")
public class DonarDto {
	
	@ApiModelProperty(notes="Email id of Donar Class")
	private String email;
	
	@ApiModelProperty(notes="Phone Number of Donar")
	private Long phone;
	
	@ApiModelProperty(notes="LastDonationDate of Donar")
	private Date lastDonationDate;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Date getLastDonationDate() {
		return lastDonationDate;
	}
	public void setLastDonationDate(Date lastDonationDate) {
		this.lastDonationDate = lastDonationDate;
	}
	
	
}
