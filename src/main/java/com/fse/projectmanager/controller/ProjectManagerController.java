/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Apr 3, 2019
 */

package com.fse.projectmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fse.projectmanager.mapper.ProjectViewResponse;
import com.fse.projectmanager.mapper.TaskResponse;
import com.fse.projectmanager.mapper.UserObject;
import com.fse.projectmanager.model.Parent;
import com.fse.projectmanager.model.Project;
import com.fse.projectmanager.model.User;
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
	
	@GetMapping(value="findAllProjects")
	public List<ProjectViewResponse> findAllProjects(){
		return projectManagerService.findAllProjects();
	}
	
	@GetMapping(value="findAllUsers")
	public List<UserObject> findAllUsers(){
		return projectManagerService.findAllUsers();
	}
	
	@GetMapping(value="getProjectList")
	public List<Project> getProjectList(){
		return projectManagerService.getProjectList();
	}
	
	@GetMapping(value="getParentList")
	public List<Parent> getParentList(){
		return projectManagerService.getParentList();
	}
	
	@GetMapping(value="getManagerList")
	public List<User> getManagerList(){
		return projectManagerService.getManagerList();
	}
	
	@PostMapping(value="addUser")
	public UserObject addUser(@RequestBody UserObject request){
		return projectManagerService.addUser(request);
	}
	
	@PostMapping(value="updateUser")
	public UserObject updateUser(@RequestBody UserObject request){
		return projectManagerService.updateUser(request);
	}
	
	@DeleteMapping(value="deleteUser/{id}")
	public void deleteUser(@PathVariable Long id) {
			projectManagerService.deleteUser(id);
	}
	
}
