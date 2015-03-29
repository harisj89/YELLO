package com.project.model;

import java.io.Serializable;
import java.sql.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="CONTACTS_THREE")
public class Contact implements Serializable{
     
    private static final long serialVersionUID = -8767337896773261247L;
 
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String cellNo;
//    private Date birthDate;
    private String website;
     
//    private Date createdOn;
//    private String createdBy;
//    private Date updatedOn;
//    private String updatedBy;
 
    @Id
    @GeneratedValue
    @Column(name="P_ID")
    public Long getId() {
        return id;
    }
    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }
    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }
    @Column(name="EMAIL_ID")
    public String getEmailId() {
        return emailId;
    }
    @Column(name="CELL_NO")
    public String getCellNo() {
        return cellNo;
    }

    @Column(name="WEBSITE")
    public String getWebsite() {
        return website;
    }

    
	public void setId(Long id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }


    public void setWebsite(String website) {
        this.website = website;
    }
}