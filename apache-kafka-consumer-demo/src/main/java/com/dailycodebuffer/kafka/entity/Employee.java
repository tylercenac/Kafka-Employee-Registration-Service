package com.dailycodebuffer.kafka.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {

	@Id
	private String email;
	private String firstName;
	private String lastName;
	private String status;
	private String status_date;
	
	
	public Employee() {
		super();
		this.status = "PENDING";
		this.status_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	
	
	/**
	 * @param email
	 * @param firstName
	 * @param lastName
	 */
	public Employee(String email, String firstName, String lastName) {
		this();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * @param email
	 * @param firstName
	 * @param lastName
	 */
	public Employee(String email, String firstName, String lastName, String status, String status_date) {
		this(email, firstName, lastName);
		this.status = status;
		this.status_date = status_date;
	}
	
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the status_date
	 */
	public String getStatus_date() {
		return status_date;
	}
	/**
	 * @param status_date the status_date to set
	 */
	public void setStatus_date(String status_date) {
		this.status_date = status_date;
	}



	@Override
	public String toString() {
		return "Employee [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", status=" + status
				+ ", status_date=" + status_date + "]";
	}
	
	
	
}
