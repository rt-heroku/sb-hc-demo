package com.heroku.demo.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table(name="account", schema="salesforce")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="_hc_err")
	private String hcErr;

	@Column(name="_hc_lastop")
	private String hcLastop;

	private String accountnumber;

	private String billingcity;

	private String billingcountry;

	private String billingpostalcode;

	private String billingstate;

	private String billingstreet;

	private Timestamp createddate;

	private Boolean isdeleted;

	private String name;

	private String sfid;

	private String sic;

	private String sicdesc;

	private Timestamp systemmodstamp;

	public Account() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHcErr() {
		return hcErr;
	}

	public void setHcErr(String hcErr) {
		this.hcErr = hcErr;
	}

	public String getHcLastop() {
		return hcLastop;
	}

	public void setHcLastop(String hcLastop) {
		this.hcLastop = hcLastop;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getBillingcity() {
		return billingcity;
	}

	public void setBillingcity(String billingcity) {
		this.billingcity = billingcity;
	}

	public String getBillingcountry() {
		return billingcountry;
	}

	public void setBillingcountry(String billingcountry) {
		this.billingcountry = billingcountry;
	}

	public String getBillingpostalcode() {
		return billingpostalcode;
	}

	public void setBillingpostalcode(String billingpostalcode) {
		this.billingpostalcode = billingpostalcode;
	}

	public String getBillingstate() {
		return billingstate;
	}

	public void setBillingstate(String billingstate) {
		this.billingstate = billingstate;
	}

	public String getBillingstreet() {
		return billingstreet;
	}

	public void setBillingstreet(String billingstreet) {
		this.billingstreet = billingstreet;
	}

	public Timestamp getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}

	public Boolean getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSfid() {
		return sfid;
	}

	public void setSfid(String sfid) {
		this.sfid = sfid;
	}

	public String getSic() {
		return sic;
	}

	public void setSic(String sic) {
		this.sic = sic;
	}

	public String getSicdesc() {
		return sicdesc;
	}

	public void setSicdesc(String sicdesc) {
		this.sicdesc = sicdesc;
	}

	public Timestamp getSystemmodstamp() {
		return systemmodstamp;
	}

	public void setSystemmodstamp(Timestamp systemmodstamp) {
		this.systemmodstamp = systemmodstamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}