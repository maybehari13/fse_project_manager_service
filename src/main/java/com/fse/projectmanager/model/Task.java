/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Apr 1, 2019
 */

package com.fse.projectmanager.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

/**
 * @author n0172808
 * Task Entity Definition
 */
@Entity
@Table(name="task")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="taskId")
public class Task{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_id")
	private Long taskId;
	@NotNull
	@Column(name="task_desc")
	private String task;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="end_date")
	private Date endDate;
	@Range(min=0, max=30)
	private int priority;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_parent_id")
	private Parent parent;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_project_id")
	private Project project;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_user_id")
	private User user;

	/**
	 * @return the taskId
	 */
	public Long getTaskId() {
		return taskId;
	}

//	/**
//	 * @param taskId the taskId to set
//	 */
//	public void setTaskId(Long taskId) {
//		this.taskId = taskId;
//	}

	/**
	 * @return the task
	 */
	public String getTask() {
		return task;
	}

	/**
	 * @param task the task to set
	 */
	public void setTask(String task) {
		this.task = task;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	/**
	 * @return the parentTask
	 */
	public Parent getParent() {
		return parent;
	}

	/**
	 * @param parentTask the parentTask to set
	 */
	public void setParent(Parent parent) {
		this.parent = parent;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}
