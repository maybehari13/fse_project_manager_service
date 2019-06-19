/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Jun 18, 2019
 */

package com.fse.projectmanager.mapper;

/**
 * @author n0172808
 *
 */
public class UserObject {

	private Long userId;
	private String firstName;
	private String lastName;
	private int employeeId;
	private boolean manager;

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
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the manager
	 */
	public boolean isManager() {
		return manager;
	}
	/**
	 * @param manager the manager to set
	 */
	public void setManager(boolean manager) {
		this.manager = manager;
	}
	
}
