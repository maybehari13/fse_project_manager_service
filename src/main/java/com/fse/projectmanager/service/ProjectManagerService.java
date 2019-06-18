/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Apr 3, 2019
 */

package com.fse.projectmanager.service;

import java.util.List;

import com.fse.projectmanager.mapper.TaskResponse;

/**
 * @author n0172808
 *
 */
public interface ProjectManagerService {

	/**
	 * 
	 */
	List<TaskResponse> findAllTasks();

}
