/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Apr 3, 2019
 */

package com.fse.projectmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.projectmanager.mapper.TaskResponse;
import com.fse.projectmanager.model.Task;
import com.fse.projectmanager.repository.ParentTaskJpaRepository;
import com.fse.projectmanager.repository.ProjectJpaRepository;
import com.fse.projectmanager.repository.TaskJpaRepository;
import com.fse.projectmanager.repository.UserJpaRepository;

/**
 * @author n0172808
 *
 */
@Service
public class ProjectManagerServiceImpl implements ProjectManagerService {

	@Autowired
	private TaskJpaRepository taskJpaRepository;

	@Autowired
	private ParentTaskJpaRepository parentTaskJpaRepository;
	
	@Autowired
	private ProjectJpaRepository projectJpaRepository;
	
	@Autowired
	private UserJpaRepository userJpaRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fse.projectmanager.service.ProjectManagerService#findAllTasks()
	 */
	@Override
	public List<TaskResponse> findAllTasks() {

		// Map Entity to required JSON payload
		List<Task> tasks = new ArrayList<>();
		tasks = taskJpaRepository.findAll();

		List<TaskResponse> taskResps = new ArrayList<>();

		for (Task task : tasks) {

			TaskResponse taskResp = taskResponseMapper(task);

			taskResps.add(taskResp);
		}

		return taskResps;
	}

	/**
	 * @param task
	 * @return
	 */
	private TaskResponse taskResponseMapper(Task task) {
		TaskResponse taskResp = new TaskResponse();

		taskResp.setId(task.getTaskId());
		taskResp.setTask(task.getTask());
		taskResp.setStartDate(task.getStartDate());
		taskResp.setEndDate(task.getEndDate());
		taskResp.setPriority(task.getPriority());
		taskResp.setParentId(task.getParent().getParentId());
		taskResp.setParentTask(task.getParent().getParentTask());
		taskResp.setProjectId(task.getProject().getProjectId());
		taskResp.setProject(task.getProject().getProject());
		taskResp.setProjectStartDate(task.getProject().getStartDate());
		taskResp.setProjectEndDate(task.getProject().getEndDate());
		taskResp.setProjectPriority(task.getProject().getPriority());
		taskResp.setUserId(task.getUser().getUserId());
		taskResp.setFirstName(task.getUser().getFirstName());
		taskResp.setLastName(task.getUser().getLastName());
		taskResp.setEmployeeId(task.getUser().getEmployeeId());
		return taskResp;
	}


}
