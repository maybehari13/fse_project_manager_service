/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Apr 3, 2019
 */

package com.fse.projectmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.projectmanager.mapper.ProjectRequest;
import com.fse.projectmanager.mapper.ProjectResponse;
import com.fse.projectmanager.mapper.TaskRequestResponse;
import com.fse.projectmanager.model.Parent;
import com.fse.projectmanager.model.Project;
import com.fse.projectmanager.model.Task;
import com.fse.projectmanager.model.User;
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
	 * @see
	 * com.fse.projectmanager.service.ProjectManagerService#addParentTask(com.
	 * fse.projectmanager.model.Parent)
	 */
	@Override
	@Transactional
	public Parent addParentTask(Parent request) {
		return parentTaskJpaRepository.saveAndFlush(request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fse.projectmanager.service.ProjectManagerService#addProject(com.fse.
	 * projectmanager.mapper.ProjectRequest)
	 */
	@Override
	@Transactional
	public List<ProjectResponse> addProject(ProjectRequest request) {

		Project projectReq = new Project();

		projectReq.setProjectName(request.getProjectName());
		projectReq.setStartDate(request.getProjectStartDate());
		projectReq.setEndDate(request.getProjectEndDate());
		projectReq.setPriority(request.getProjectPriority());
		projectReq.setUser(userJpaRepository.getOne(request.getUserId()));

		projectJpaRepository.saveAndFlush(projectReq);

		List<ProjectResponse> projectResps = findAllProjects();

		return projectResps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fse.projectmanager.service.ProjectManagerService#addTask(com.fse.
	 * projectmanager.mapper.TaskRequestResponse)
	 */
	@Override
	@Transactional
	public TaskRequestResponse addTask(TaskRequestResponse request) {
		Task task = new Task();

		task.setTaskName(request.getTaskName());
		task.setStartDate(request.getStartDate());
		task.setEndDate(request.getEndDate());
		task.setPriority(request.getPriority());
		if (request.getParentId() != 0) {
			task.setParent(parentTaskJpaRepository.getOne(request.getParentId()));
		}
		task.setProject(projectJpaRepository.getOne(request.getProjectId()));
		task.setUser(userJpaRepository.getOne(request.getUserId()));

		return taskResponseMapper(taskJpaRepository.saveAndFlush(task));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fse.projectmanager.service.ProjectManagerService#addUser(com.fse.
	 * projectmanager.mapper.UserObject)
	 */
	@Override
	@Transactional
	public User addUser(User request) {
		User user = new User();

		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmployeeId(request.getEmployeeId());
		user.setManager(request.isManager());

		return userJpaRepository.saveAndFlush(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fse.projectmanager.service.ProjectManagerService#deleteUser(java.lang
	 * .Long)
	 */
	@Override
	@Transactional
	public void deleteUser(Long id) {
		userJpaRepository.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fse.projectmanager.service.ProjectManagerService#findAllProjects()
	 */
	@Override
	public List<ProjectResponse> findAllProjects() {

		List<Project> projects = projectJpaRepository.findAll();

		List<ProjectResponse> projectResps = new ArrayList<>();

		for (Project project : projects) {

			ProjectResponse resp = new ProjectResponse();

			resp.setProjectId(project.getProjectId());
			resp.setProjectName(project.getProjectName());
			resp.setProjectStartDate(project.getStartDate());
			resp.setProjectEndDate(project.getEndDate());
			resp.setProjectPriority(project.getPriority());
			resp.setUserId(project.getUser().getUserId());
			resp.setFirstName(project.getUser().getFirstName());
			resp.setLastName(project.getUser().getLastName());
			resp.setEmployeeId(project.getUser().getEmployeeId());
			resp.setNumberOfTasks(taskJpaRepository.countByProjectProjectId(project.getProjectId()));
			resp.setCompletedTasks(taskJpaRepository.countByProjectProjectIdAndStatus(project.getProjectId(), true));
			resp.setStatus(project.isStatus());

			projectResps.add(resp);
		}

		return projectResps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fse.projectmanager.service.ProjectManagerService#findAllTasks()
	 */
	@Override
	public List<TaskRequestResponse> findAllTasks() {

		// Map Entity to required JSON payload
		List<Task> tasks = new ArrayList<>();
		tasks = taskJpaRepository.findAll();

		List<TaskRequestResponse> taskResps = new ArrayList<>();

		for (Task task : tasks) {

			TaskRequestResponse taskResp = taskResponseMapper(task);

			taskResps.add(taskResp);
		}

		return taskResps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fse.projectmanager.service.ProjectManagerService#findAllUsers()
	 */
	@Override
	public List<User> findAllUsers() {
		return userJpaRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fse.projectmanager.service.ProjectManagerService#getManagerList()
	 */
	@Override
	public List<User> getManagerList() {
		return userJpaRepository.findByManager(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fse.projectmanager.service.ProjectManagerService#getParentList()
	 */
	@Override
	public List<Parent> getParentList() {
		return parentTaskJpaRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fse.projectmanager.service.ProjectManagerService#getUserList()
	 */
	@Override
	public List<String> getUserList() {
		List<User> users = new ArrayList<>();
		users = userJpaRepository.findAll();

		List<String> userList = new ArrayList<>();

		for (User user : users) {
			userList.add(user.getFirstName() + ' ' + user.getLastName());
		}

		return userList;
	}

	/**
	 * @param task
	 * @return
	 */
	private TaskRequestResponse taskResponseMapper(Task task) {
		TaskRequestResponse taskResp = new TaskRequestResponse();

		taskResp.setId(task.getTaskId());
		taskResp.setTaskName(task.getTaskName());
		taskResp.setStartDate(task.getStartDate());
		taskResp.setEndDate(task.getEndDate());
		taskResp.setPriority(task.getPriority());
		taskResp.setStatus(task.isStatus());
		taskResp.setParentId(task.getParent().getParentId());
		taskResp.setParentTask(task.getParent().getParentTask());
		taskResp.setProjectId(task.getProject().getProjectId());
		taskResp.setProjectName(task.getProject().getProjectName());
		taskResp.setProjectStartDate(task.getProject().getStartDate());
		taskResp.setProjectEndDate(task.getProject().getEndDate());
		taskResp.setProjectPriority(task.getProject().getPriority());
		taskResp.setProjectStatus(task.getProject().isStatus());
		taskResp.setUserId(task.getUser().getUserId());
		taskResp.setFirstName(task.getUser().getFirstName());
		taskResp.setLastName(task.getUser().getLastName());
		taskResp.setEmployeeId(task.getUser().getEmployeeId());
		return taskResp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fse.projectmanager.service.ProjectManagerService#updateProject(com.
	 * fse.projectmanager.mapper.ProjectRequest)
	 */
	@Override
	@Transactional
	public List<ProjectResponse> updateProject(ProjectRequest request) {

		Project projectReq = new Project();
		
		Optional<Project> fetchProject = projectJpaRepository.findById(request.getProjectId());
		
		if(fetchProject.isPresent()){
			projectReq = fetchProject.get();
		}

		projectReq.setProjectName(request.getProjectName());
		projectReq.setStartDate(request.getProjectStartDate());
		projectReq.setEndDate(request.getProjectEndDate());
		projectReq.setPriority(request.getProjectPriority());
		projectReq.setStatus(request.isStatus());
		projectReq.setUser(userJpaRepository.getOne(request.getUserId()));

		projectJpaRepository.save(projectReq);

		List<ProjectResponse> projectResps = findAllProjects();

		return projectResps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fse.projectmanager.service.ProjectManagerService#updateTask(com.fse.
	 * projectmanager.mapper.TaskRequestResponse)
	 */
	@Override
	@Transactional
	public TaskRequestResponse updateTask(TaskRequestResponse request) {
		
		Task task = new Task();

		Optional<Task> fetchTask = taskJpaRepository.findById(request.getId());
		
		if(fetchTask.isPresent()){
			task = fetchTask.get();
		}
		
		task.setTaskName(request.getTaskName());
		task.setStartDate(request.getStartDate());
		task.setEndDate(request.getEndDate());
		task.setPriority(request.getPriority());
		task.setStatus(request.isStatus());
		if (request.getParentId() != 0) {
			task.setParent(parentTaskJpaRepository.getOne(request.getParentId()));
		}
		task.setProject(projectJpaRepository.getOne(request.getProjectId()));
		task.setUser(userJpaRepository.getOne(request.getUserId()));

		return taskResponseMapper(taskJpaRepository.save(task));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fse.projectmanager.service.ProjectManagerService#updateUser(java.lang
	 * .Long, com.fse.projectmanager.mapper.UserObject)
	 */
	@Override
	@Transactional
	public User updateUser(User request) {
		Optional<User> fetchuser = userJpaRepository.findById(request.getUserId());
		User user = new User();

		if (fetchuser.isPresent()) {
			user = fetchuser.get();
		}

		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmployeeId(request.getEmployeeId());
		user.setManager(request.isManager());

		return userJpaRepository.save(user);
	}

}
