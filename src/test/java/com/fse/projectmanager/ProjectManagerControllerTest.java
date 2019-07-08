package com.fse.projectmanager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
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

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = FseProjectManagerApplication.class)
@ActiveProfiles("test")
public class ProjectManagerControllerTest extends TestCase {
	
	@Value("${local.server.port}")
    private Integer port;
    private String baseUrl;
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ProjectJpaRepository projectRepository;

    @Autowired
    private UserJpaRepository userRepository;

    @Autowired
    private ParentTaskJpaRepository parentTaskRepository;

    @Autowired
    private TaskJpaRepository taskRepository;
    
    @Before
    public void setUp() throws Exception {
        super.setUp();
        baseUrl = "http://localhost:".concat(port.toString()).concat("/api/projectManager");
        testRestTemplate = new TestRestTemplate();
    }
    
    @Test
    public void testAddUser() {

        User user = new User();
        user.setManager(true);
        user.setLastName("FirstNme");
        user.setFirstName("LastNme");
        user.setEmployeeId(12345);
        
        ResponseEntity<String> response = testRestTemplate.postForEntity(baseUrl.concat("/addUser"), user, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
    
    @Test
    public void testAddProject() {

        User user = new User();
        user.setManager(true);
        user.setLastName("FirstUsr");
        user.setFirstName("LastUsr");
        user.setEmployeeId(22345);
        User savedUser = userRepository.save(user);

        ProjectRequest project = new ProjectRequest();
        project.setProjectName("Test Project");
        project.setProjectStartDate(new Date());
        project.setProjectEndDate(new Date());
        project.setProjectPriority(3);
        project.setStatus(true);
        project.setUserId(savedUser.getUserId());

        ResponseEntity<String> response = testRestTemplate.postForEntity(baseUrl.concat("/addProject"), project, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
    
    @Test
    public void testAddTask() {

    	Parent pTask = new Parent();
    	pTask.setParentTask("Test Parent");
    	Parent savedParent = parentTaskRepository.save(pTask);
    	
    	User user = new User();
		user.setManager(true);
		user.setLastName("FirstUsr");
		user.setFirstName("LastUsr");
		user.setEmployeeId(22345);
		User savedUser = userRepository.save(user);
		
		Project project = new Project();
		project.setProjectName("Test Project");
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		project.setPriority(3);
		project.setStatus(true);
		project.setUser(savedUser);
		Project savedProject = projectRepository.save(project);
		
		TaskRequestResponse task = new TaskRequestResponse();
		task.setEndDate(new Date());
		task.setPriority(3);
		task.setStartDate(new Date());
		task.setStatus(true);
		task.setTaskName("Test Task");
		task.setParentId(savedParent.getParentId());
		task.setProjectId(savedProject.getProjectId());
		task.setUserId(savedUser.getUserId());
		
		ResponseEntity<String> response = testRestTemplate.postForEntity(baseUrl.concat("/addTask"), task, String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
    
    @Test
    public void testUpdateTask() {
    	Parent pTask = new Parent();
    	pTask.setParentTask("Test Parent");
    	Parent savedParent = parentTaskRepository.save(pTask);
    	
    	User user = new User();
		user.setManager(true);
		user.setLastName("FirstUsr");
		user.setFirstName("LastUsr");
		user.setEmployeeId(22345);
		User savedUser = userRepository.save(user);
		
		Project project = new Project();
		project.setProjectName("Test Project");
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		project.setPriority(3);
		project.setStatus(true);
		project.setUser(savedUser);
		Project savedProject = projectRepository.save(project);
		
		Task task = new Task();
		task.setEndDate(new Date());
		task.setPriority(8);
		task.setStartDate(new Date());
		task.setStatus(true);
		task.setTaskName("Test Task");
		task.setParent(savedParent);
		task.setProject(savedProject);
		task.setUser(savedUser);
		Task savedTask = taskRepository.save(task);
		
		TaskRequestResponse taskRR = new TaskRequestResponse();
		taskRR.setId(savedTask.getTaskId());
		taskRR.setEndDate(new Date());
		taskRR.setPriority(12);
		taskRR.setStartDate(new Date());
		taskRR.setStatus(true);
		taskRR.setTaskName("Test Task upd");
		taskRR.setParentId(savedParent.getParentId());
		taskRR.setProjectId(savedProject.getProjectId());
		taskRR.setUserId(savedUser.getUserId());
		
		ResponseEntity<String> response = testRestTemplate.postForEntity(baseUrl.concat("/updateTask"), taskRR, String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
    
    @Test
    public void testUpdateProject() {
    	User user = new User();
        user.setManager(true);
        user.setLastName("FirstUsr");
        user.setFirstName("LastUsr");
        user.setEmployeeId(22345);
        User savedUser = userRepository.save(user);

        Project project = new Project();
        project.setProjectName("Test Proj Name");
        project.setPriority(3);
        project.setStartDate(new Date());
        project.setEndDate(new Date());
        project.setStatus(true);
        project.setUser(savedUser);
        Project savedProject = projectRepository.save(project);
        
        ProjectRequest projectR = new ProjectRequest();
        projectR.setProjectName("Test Project Update");
        projectR.setProjectStartDate(new Date());
        projectR.setProjectEndDate(new Date());
        projectR.setProjectPriority(3);
        projectR.setStatus(true);
        projectR.setUserId(savedUser.getUserId());
        projectR.setProjectId(savedProject.getProjectId());
        

        ResponseEntity<String> response = testRestTemplate.postForEntity(baseUrl.concat("/updateProject"), projectR, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
    
    @Test
    public void testAddParent() {

    	Parent pTask = new Parent();
    	pTask.setParentTask("Test Parent");
        
        ResponseEntity<String> response = testRestTemplate.postForEntity(baseUrl.concat("/addParentTask"), pTask, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));        
    }
    
    @Test
    public void testUpdateUser() {
    	User user = new User();
        user.setManager(true);
        user.setLastName("FirstNmeUpd");
        user.setFirstName("LastNmeUpd");
        user.setEmployeeId(12345);
        User savedUser = userRepository.save(user);
        
        ResponseEntity<String> response = testRestTemplate.postForEntity(baseUrl.concat("/updateUser"), savedUser, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
    
    @Test
    public void testFindAllUser() throws Exception {
    	
    	User user = new User();
        user.setManager(true);
        user.setLastName("FirstNmeUpd");
        user.setFirstName("LastNmeUpd");
        user.setEmployeeId(12345);
        userRepository.save(user);
                
        ResponseEntity<String> response = testRestTemplate.getForEntity(baseUrl.concat("/findAllUsers"), String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        
        List<User> userList = convertJsonToUserList(response.getBody());
        assertThat(userList.size(), equalTo(1));
    }
    
    @Test
	public void testFindAllProjects() throws Exception {
	    
    	User user = new User();
		user.setManager(true);
		user.setLastName("FirstUsr");
		user.setFirstName("LastUsr");
		user.setEmployeeId(22345);
		User savedUser = userRepository.save(user);
		
		Project project = new Project();
		project.setProjectName("Test Project");
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		project.setPriority(3);
		project.setStatus(true);
		project.setUser(savedUser);
		projectRepository.save(project);
		
	    ResponseEntity<String> response = testRestTemplate.getForEntity(baseUrl.concat("/findAllProjects"), String.class);
	    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	    
	    List<ProjectResponse> projectList = convertJsonToProjectList(response.getBody());
	    assertThat(projectList.size(), equalTo(1));
	}
    
    
    @Test
    public void testfindAllTasks() throws Exception {
    	
    	Parent pTask = new Parent();
    	pTask.setParentTask("Test Parent");
    	Parent savedParent = parentTaskRepository.save(pTask);
    	
    	User user = new User();
		user.setManager(true);
		user.setLastName("FirstUsr");
		user.setFirstName("LastUsr");
		user.setEmployeeId(22345);
		User savedUser = userRepository.save(user);
		
		Project project = new Project();
		project.setProjectName("Test Project");
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		project.setPriority(3);
		project.setStatus(true);
		project.setUser(savedUser);
		Project savedProject = projectRepository.save(project);
		
		Task task = new Task();
		task.setEndDate(new Date());
		task.setPriority(8);
		task.setStartDate(new Date());
		task.setStatus(true);
		task.setTaskName("Test Task");
		task.setParent(savedParent);
		task.setProject(savedProject);
		task.setUser(savedUser);
		taskRepository.save(task);
		
    	ResponseEntity<String> response = testRestTemplate.getForEntity(baseUrl.concat("/findAllTasks"), String.class);
	    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	    
	    List<TaskRequestResponse> taskList = convertJsonToTaskList(response.getBody());
	    assertThat(taskList.size(), equalTo(1));
    }
    
    @Test
    public void testGetParentList() throws Exception {
    	
    	Parent pTask = new Parent();
    	pTask.setParentTask("Test Parent");
    	parentTaskRepository.save(pTask);
    	
    	ResponseEntity<String> response = testRestTemplate.getForEntity(baseUrl.concat("/getParentList"), String.class);
	    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	    
	    List<Parent> taskList = convertJsonToParentList(response.getBody());
	    assertThat(taskList.size(), equalTo(1));
    }
            
	private List<User> convertJsonToUserList(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, User.class));
    }
	
	private List<ProjectResponse> convertJsonToProjectList(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, ProjectResponse.class));
    }
	
	private List<TaskRequestResponse> convertJsonToTaskList(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, TaskRequestResponse.class));
    }
	
	private List<Parent> convertJsonToParentList(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, Parent.class));
    }
	
	@After
    public void tearDown() throws Exception {
        super.tearDown();
        baseUrl = null;
        testRestTemplate = null;
        taskRepository.deleteAll();
        projectRepository.deleteAll();
        userRepository.deleteAll();
        parentTaskRepository.deleteAll();
    }
    
}
