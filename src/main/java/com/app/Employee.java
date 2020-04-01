package com.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_name")
	private String empName;

	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="loation")
	private String location;
	
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Employee(String empName) {
		super();
		this.empName = empName;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}
	
	

}
