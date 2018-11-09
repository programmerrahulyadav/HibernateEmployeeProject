package com.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "employeedb_employeetable")
@Table(name = "employeetable")
public class EmployeeDto {

	public EmployeeDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	Integer empId;
	@Column(name = "first_Name")
	String first_name;
	@Column(name = "last_Name")
	String last_name;
	@Column(name = "email")
	String email;
	
	public EmployeeDto(String first_name,String last_name,String email) {
			this.first_name = first_name;
			this.last_name = last_name;
			this.email = email;
		}
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
