package com.project.model;

import java.io.Serializable;
import java.sql.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="RESTAURANTS")
public class Restaurants implements Serializable{
     
    private static final long serialVersionUID = -8767337896773261247L;
 
    private Long res_id;
    private String resName;
    private String resAddress;
    private String resPhoneNo;
    private String resReserveOne;
    
    @Id
    @GeneratedValue
    @Column(name="RES_ID")
	public Long getRes_id() {
		return res_id;
	}
	public void setRes_id(Long res_id) {
		this.res_id = res_id;
	}
	
	@Column(name="NAME")
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	
	@Column(name="ADDRESS")
	public String getResAddress() {
		return resAddress;
	}
	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}
	
	@Column(name="PHONE_NO")
	public String getResPhoneNo() {
		return resPhoneNo;
	}
	public void setResPhoneNo(String resPhoneNo) {
		this.resPhoneNo = resPhoneNo;
	}
	
	@Column(name="RESERVE_ONE")
	public String getResReserveOne() {
		return resReserveOne;
	}
	public void setResReserveOne(String resReserveOne) {
		this.resReserveOne = resReserveOne;
	}
	
}