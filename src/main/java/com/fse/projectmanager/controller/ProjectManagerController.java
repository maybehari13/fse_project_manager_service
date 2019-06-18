/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Apr 3, 2019
 */

package com.fse.projectmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fse.projectmanager.mapper.TaskResponse;
import com.fse.projectmanager.service.ProjectManagerService;

/**
 * @author n0172808
 *
 */
@RestController  //@Response body is default with this annotation
@RequestMapping("api/projectManager/")
public class ProjectManagerController {

	@Autowired
	private ProjectManagerService projectManagerService;
	
	@GetMapping(value="findAllTasks")
	public List<TaskResponse> findAllTasks(){
		return projectManagerService.findAllTasks();
	}
	
}
