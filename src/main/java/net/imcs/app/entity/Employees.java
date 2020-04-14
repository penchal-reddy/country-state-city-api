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
@Table(name="employees")
public class Employees {
	
	@Id
	@Column(name="id")
	private int empId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="marital_status")
	private String maritalStatus;
	
	@Column(name="primary_email")
	private String primaryEmail;
	
	@Column(name="primary_contact_phone")
	private String PrimaryContactPhone;
	
	@Column(name="relationship_emails")
	private String relationshipEmails;
	
	@Column(name="relationship_phones")
	private String relationshipPhones;
	
	@Column(name="permanent_address_1")
	private String permanentAddress1;
	
	@Column(name="permanent_address_2")
	private String permanentAddress2;
	
	@Column(name="permanent_city")
	private String permanentCity;
	
	@Column(name="permanent_zip")
	private String permanentZip;
	
	@Column(name="permanent_state")
	private String permanentState;
	
	@Column(name="permanent_country")
	private String permanentCountry;
	
	@Column(name="current_address_1")
	private String currentAddress1;
	
	@Column(name="current_address_2")
	private String currentAddress2;

	@Column(name="current_city")
	private String currentCity;
	
	@Column(name="current_zip")
	private String currentZip;
	
	@Column(name="current_state")
	private String currentState;
	
	@Column(name="current_country")
	private String currentCountry;
	
	@Column(name="relationship_emergencycontacts")
	private String relationshipEmergencyContacts;

	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="modified_by")
	private String modifiedBy;
	
	

	@Column(name="modified_date")
	private Date modifiedDate;
	
	
	/*
	 * @OneToOne(mappedBy = "empId",cascade= CascadeType.ALL) private Immigration
	 * immigration;
	 */
	@OneToOne(mappedBy = "empId",cascade= CascadeType.ALL)
	private Immigration immigration;
	/*
	 * @OneToOne(cascade= CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "emp_id") private Immigration immigration;
	 */
	/*
	 * @ElementCollection private List<Emails> emails = new ArrayList<>();
	 * 
	 * @ElementCollection private List<Phones> phones = new ArrayList<>();
	 * 
	 * @ElementCollection private List<EmergencyContacts> emergencyContacts = new
	 * ArrayList<>();
	 */
	public Immigration getImmigration() {
		return immigration;
	}

	public void setImmigration(Immigration immigration) {
		this.immigration = immigration;
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

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setEmpMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setEmpLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getPrimaryContactPhone() {
		return PrimaryContactPhone;
	}

	public void setPrimaryContactPhone(String primaryContactPhone) {
		PrimaryContactPhone = primaryContactPhone;
	}

	public String getRelationshipEmails() {
		return relationshipEmails;
	}

	public void setRelationshipEmails(String relationshipEmails) {
		this.relationshipEmails = relationshipEmails;
	}

	public String getRelationshipPhones() {
		return relationshipPhones;
	}

	public void setRelationshipPhones(String relationshipPhones) {
		this.relationshipPhones = relationshipPhones;
	}

	public String getPermanentAddress1() {
		return permanentAddress1;
	}

	public void setPermanentAddress1(String permanentAddress1) {
		this.permanentAddress1 = permanentAddress1;
	}

	public String getPermanentAddress2() {
		return permanentAddress2;
	}

	public void setPermanentAddress2(String permanentAddress2) {
		this.permanentAddress2 = permanentAddress2;
	}

	public String getPermanentCity() {
		return permanentCity;
	}

	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}

	public String getPermanentZip() {
		return permanentZip;
	}

	public void setPermanentZip(String permanentZip) {
		this.permanentZip = permanentZip;
	}

	public String getPermanentState() {
		return permanentState;
	}

	public void setPermanentState(String permanentState) {
		this.permanentState = permanentState;
	}

	public String getPermanentCountry() {
		return permanentCountry;
	}

	public void setPermanentCountry(String permanentCountry) {
		this.permanentCountry = permanentCountry;
	}

	public String getCurrentAddress1() {
		return currentAddress1;
	}

	public void setCurrentAddress1(String currentAddress1) {
		this.currentAddress1 = currentAddress1;
	}

	public String getCurrentAddress2() {
		return currentAddress2;
	}

	public void setCurrentAddress2(String currentAddress2) {
		this.currentAddress2 = currentAddress2;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getCurrentZip() {
		return currentZip;
	}

	public void setCurrentZip(String currentZip) {
		this.currentZip = currentZip;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getCurrentCountry() {
		return currentCountry;
	}

	public void setCurrentCountry(String currentCountry) {
		this.currentCountry = currentCountry;
	}

	public String getRelationshipEmergencyContacts() {
		return relationshipEmergencyContacts;
	}

	public void setRelationshipEmergencyContacts(String relationshipEmergencyContacts) {
		this.relationshipEmergencyContacts = relationshipEmergencyContacts;
	}

	
	
	
}
