package com.Isha.ContactInfo.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name="Contact_Info")
@Data
public class Contactinfo {
	
	@Id
	@GeneratedValue
	
	private Integer contactId;
	
	
	@Column(name="Contact_Name")
	private String contactName;
	
	@Column(name="Contact_Number")
	private Long  contactNumber;
	
	@Column(name="Contact_Email")
	private String contactEmail;
	
	@Column(name="Create_Date",updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	
	@Column(name="Create_Update",updatable = false)
	@UpdateTimestamp
	private LocalDate updateDate;
	
	@Column(name="isActiveswitch")
	private Character isActive;

	
	
	
	
	

}
