package com.ezen.mybatis.domain.employee.dto;

import lombok.*;

//@Data
//@Builder
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobId;
	private int salary;
	private double commission;
	private int managerId;
	private int departmentId;

//	public Employee() {}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPhoneNumber() {
//		return phoneNumber;
//	}
//
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//
//	public String getHireDate() {
//		return hireDate;
//	}
//
//	public void setHireDate(String hireDate) {
//		this.hireDate = hireDate;
//	}
//
//	public String getJobId() {
//		return jobId;
//	}
//
//	public void setJobId(String jobId) {
//		this.jobId = jobId;
//	}
//
//	public int getSalary() {
//		return salary;
//	}
//
//	public void setSalary(int salary) {
//		this.salary = salary;
//	}
//
//	public double getCommission() {
//		return commission;
//	}
//
//	public void setCommission(double commission) {
//		this.commission = commission;
//	}
//
//	public int getManagerId() {
//		return managerId;
//	}
//
//	public void setManagerId(int managerId) {
//		this.managerId = managerId;
//	}
//
//	public int getDepartmentId() {
//		return departmentId;
//	}
//
//	public void setDepartmentId(int departmentId) {
//		this.departmentId = departmentId;
//	}
//
//	@Override
//	public String toString() {
//		return "Employee{" +
//				"id=" + id +
//				", firstName='" + firstName + '\'' +
//				", lastName='" + lastName + '\'' +
//				", email='" + email + '\'' +
//				", phoneNumber='" + phoneNumber + '\'' +
//				", hireDate='" + hireDate + '\'' +
//				", jobId='" + jobId + '\'' +
//				", salary=" + salary +
//				", commission=" + commission +
//				", managerId=" + managerId +
//				", departmentId=" + departmentId +
//				'}';
//	}
}
