/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Apr 5, 2019
 */

package com.fse.projectmanager.mapper;

import java.util.Date;

/**
 * @author n0172808
 *
 */
public class ProjectRequest {

	private Long projectId;
	private String project;
	private Date projectStartDate;
	private Date projectEndDate;
	private int projectPriority;
	private Long userId;
	private String firstName;
	private String lastName;
	private int employeeId;
	
	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}
	/**
	 * @param project the project to set
	 */
	public void setProject(String project) {
		this.project = project;
	}
	/**
	 * @return the projectStartDate
	 */
	public Date getProjectStartDate() {
		return projectStartDate;
	}
	/**
	 * @param projectStartDate the projectStartDate to set
	 */
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	/**
	 * @return the projectEndDate
	 */
	public Date getProjectEndDate() {
		return projectEndDate;
	}
	/**
	 * @param projectEndDate the projectEndDate to set
	 */
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	/**
	 * @return the projectPriority
	 */
	public int getProjectPriority() {
		return projectPriority;
	}
	/**
	 * @param projectPriority the projectPriority to set
	 */
	public void setProjectPriority(int projectPriority) {
		this.projectPriority = projectPriority;
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
	
	
	
}
