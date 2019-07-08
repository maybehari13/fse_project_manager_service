package com.fse.projectmanager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Date;
import java.util.List;

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
        user.setLastName("FirstNme");
        user.setFirstName("LastNme");
        user.setEmployeeId(12345);
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
    public void testFindAllUser() throws Exception {
        
        ResponseEntity<String> response = testRestTemplate.getForEntity(baseUrl.concat("/findAllUsers"), String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        
        List<User> userList = convertJsonToUserList(response.getBody());
        assertThat(userList.size(), equalTo(1));
    }
    
    private List<User> convertJsonToUserList(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, User.class));
    }    
}
