/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Apr 3, 2019
 */

package com.fse.projectmanager.service;

import java.util.List;

import com.fse.projectmanager.mapper.ProjectViewResponse;
import com.fse.projectmanager.mapper.TaskResponse;
import com.fse.projectmanager.mapper.UserObject;
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
	List<TaskResponse> findAllTasks();

	/**
	 * @return
	 */
	List<ProjectViewResponse> findAllProjects();

	/**
	 * @return
	 */
	List<UserObject> findAllUsers();

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
	UserObject addUser(UserObject request);

	/**
	 * @param id
	 * @param request
	 * @return
	 */
	UserObject updateUser(UserObject request);

	/**
	 * @param id
	 */
	void deleteUser(Long id);




}
