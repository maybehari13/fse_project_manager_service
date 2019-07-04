/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Jun 18, 2019
 */

package com.fse.projectmanager.mapper;

import java.util.Date;

/**
 * @author n0172808
 *
 */
public class ProjectResponse {

	private Long projectId;
	private String projectName;
	private Date projectStartDate;
	private Date projectEndDate;
	private int projectPriority;
	private int numberOfTasks;
	private int completedTasks;
	private Long userId;
	private String firstName;
	private String lastName;
	private int employeeId;
	private boolean status;

	/**
	 * @return the completedTasks
	 */
	public int getCompletedTasks() {
		return completedTasks;
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the numberOfTasks
	 */
	public int getNumberOfTasks() {
		return numberOfTasks;
	}

	/**
	 * @return the projectEndDate
	 */
	public Date getProjectEndDate() {
		return projectEndDate;
	}

	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @return the projectPriority
	 */
	public int getProjectPriority() {
		return projectPriority;
	}

	/**
	 * @return the projectStartDate
	 */
	public Date getProjectStartDate() {
		return projectStartDate;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param completedTasks
	 *            the completedTasks to set
	 */
	public void setCompletedTasks(int completedTasks) {
		this.completedTasks = completedTasks;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param numberOfTasks
	 *            the numberOfTasks to set
	 */
	public void setNumberOfTasks(int numberOfTasks) {
		this.numberOfTasks = numberOfTasks;
	}

	/**
	 * @param projectEndDate
	 *            the projectEndDate to set
	 */
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	/**
	 * @param projectId
	 *            the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String project) {
		this.projectName = project;
	}

	/**
	 * @param projectPriority
	 *            the projectPriority to set
	 */
	public void setProjectPriority(int projectPriority) {
		this.projectPriority = projectPriority;
	}

	/**
	 * @param projectStartDate
	 *            the projectStartDate to set
	 */
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
