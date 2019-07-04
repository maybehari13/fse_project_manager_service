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
public class TaskRequestResponse {

	private Long id;
	private String taskName;
	private Date startDate;
	private Date endDate;
	private int priority;
	private boolean status;
	private Long parentId;
	private String parentTask;
	private Long projectId;
	private String projectName;
	private Date projectStartDate;
	private Date projectEndDate;
	private int projectPriority;
	private boolean projectStatus;
	private Long userId;
	private String firstName;
	private String lastName;
	private int employeeId;

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @return the parentTask
	 */
	public String getParentTask() {
		return parentTask;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @return the projectStatus
	 */
	public boolean isProjectStatus() {
		return projectStatus;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @param parentTask
	 *            the parentTask to set
	 */
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
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
	 * @param projectStatus
	 *            the projectStatus to set
	 */
	public void setProjectStatus(boolean projectStatus) {
		this.projectStatus = projectStatus;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @param taskName
	 *            the taskName to set
	 */
	public void setTaskName(String task) {
		this.taskName = task;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
