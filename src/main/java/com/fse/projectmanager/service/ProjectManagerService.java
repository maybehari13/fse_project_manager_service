/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Apr 3, 2019
 */

package com.fse.projectmanager.service;

import java.util.List;

import com.fse.projectmanager.mapper.ProjectResponse;
import com.fse.projectmanager.mapper.TaskRequestResponse;
import com.fse.projectmanager.model.Parent;
import com.fse.projectmanager.model.Project;
import com.fse.projectmanager.model.User;

/**
 * @author n0172808
 *
 */
public interface ProjectManagerService {

	/**
	 * 
	 */
	List<TaskRequestResponse> findAllTasks();

	/**
	 * @return
	 */
	List<ProjectResponse> findAllProjects();

	/**
	 * @return
	 */
	List<User> findAllUsers();

	/**
	 * @return
	 */
	List<Project> getProjectList();

	/**
	 * @return
	 */
	List<String> getUserList();

	/**
	 * @return
	 */
	List<Parent> getParentList();

	/**
	 * @return
	 */
	List<User> getManagerList();
	
	/**
	 * @param request
	 * @return
	 */
	User addUser(User request);

	/**
	 * @param id
	 * @param request
	 * @return
	 */
	User updateUser(User request);

	/**
	 * @param id
	 */
	void deleteUser(Long id);

	/**
	 * @param request
	 * @return
	 */
	TaskRequestResponse addTask(TaskRequestResponse request);

	/**
	 * @param request
	 * @return
	 */
	TaskRequestResponse updateTask(TaskRequestResponse request);




}
