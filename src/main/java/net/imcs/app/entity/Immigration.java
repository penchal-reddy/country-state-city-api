package net.imcs.app.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="immigration")
public class Immigration {

	@Id
	@Column(name="id")
	private int id;
	
	@OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "emp_id")
	//@Column(name="emp_id")
	//@OneToOne(mappedBy = "id")
	private Employees  empId;
	
	@OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "visa_id")
	//@Column(name="emp_id")
	private VisaTypes  visaId;
	
	@Column(name="passport")
	private String Passport;
	
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="modified_by")
	private String modifiedBy;
	
	@Column(name="modified_date")
	private Date modifiedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public Employees getEmpId() { return empId; }
	 * 
	 * public void setEmpId(Employees empId) { this.empId = empId; }
	 */

	public String getPassport() {
		return Passport;
	}

	public void setPassport(String passport) {
		Passport = passport;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public VisaTypes getVisaId() {
		return visaId;
	}

	public void setVisaId(VisaTypes visaId) {
		this.visaId = visaId;
	}
	
	
}
