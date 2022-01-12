package com.example.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String company_name;

	private String fb;

	private String instagram;

	@Column(name="password_to")
	private String passwordTo;

	private String twitter;

	private String username;

	public Company() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompany_name() {
		return this.company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getFb() {
		return this.fb;
	}

	public void setFb(String fb) {
		this.fb = fb;
	}

	public String getInstagram() {
		return this.instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getPasswordTo() {
		return this.passwordTo;
	}

	public void setPasswordTo(String passwordTo) {
		this.passwordTo = passwordTo;
	}

	public String getTwitter() {
		return this.twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}