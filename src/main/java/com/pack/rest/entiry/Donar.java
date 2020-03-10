package com.pack.rest.entiry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Donar_Table")
public class Donar {
	
	@Id
	private String email;
	private Long phone;
	
	@Temporal(TemporalType.DATE)
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
