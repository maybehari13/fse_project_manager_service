/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Apr 1, 2019
 */

package com.fse.projectmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author n0172808
 *
 */
@Entity
@Table(name="parent")
public class Parent{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="parent_id")
	private Long parentId;
	@Column(name="parent_task_desc")
	private String parentTask;
	
	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}
//	/**
//	 * @param parentId the parentId to set
//	 */
//	public void setParentId(Long parentId) {
//		this.parentId = parentId;
//	}
	/**
	 * @return the parentTask
	 */
	public String getParentTask() {
		return parentTask;
	}
	/**
	 * @param parentTask the parentTask to set
	 */
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	
	
}
