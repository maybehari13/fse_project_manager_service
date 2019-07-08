/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Apr 3, 2019
 */

package com.fse.projectmanager.service;

import java.util.List;

import com.fse.projectmanager.mapper.ProjectRequest;
import com.fse.projectmanager.mapper.ProjectResponse;
import com.fse.projectmanager.mapper.TaskRequestResponse;
import com.fse.projectmanager.model.Parent;
import com.fse.projectmanager.model.User;

/**
 * @author n0172808
 *
 */
public interface ProjectManagerService {

	/**
	 * @param request
	 * @return
	 */
	Parent addParentTask(Parent request);

	/**
	 * @param request
	 * @return
	 */
	List<ProjectResponse> addProject(ProjectRequest request);

	/**
	 * @param request
	 * @return
	 */
	TaskRequestResponse addTask(TaskRequestResponse request);

	/**
	 * @param request
	 * @return
	 */
	User addUser(User request);

	/**
	 * @param id
	 */
	void deleteUser(Long id);

	/**
	 * @return
	 */
	List<ProjectResponse> findAllProjects();

	/**
	 * 
	 */
	List<TaskRequestResponse> findAllTasks();

	/**
	 * @return
	 */
	List<User> findAllUsers();

	/**
	 * @return
	 */
	List<Parent> getParentList();

	/**
	 * @param request
	 * @return
	 */
	List<ProjectResponse> updateProject(ProjectRequest request);

	/**
	 * @param request
	 * @return
	 */
	TaskRequestResponse updateTask(TaskRequestResponse request);

	/**
	 * @param id
	 * @param request
	 * @return
	 */
	User updateUser(User request);

}
