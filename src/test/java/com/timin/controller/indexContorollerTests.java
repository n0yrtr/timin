package com.timin.controller;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.timin.TestDataSourceConfig;
import com.timin.TiminApplication;
import com.timin.domain.task.Task;
import com.timin.service.task.refer.TaskReferService;

/**
 * Created by naoya on 2018/01/02.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        TiminApplication.class,
        TestDataSourceConfig.class
})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@ContextConfiguration(classes = { TestDataSourceConfig.class})
@WebAppConfiguration


public class indexContorollerTests {

    private static final String DATA_FILE_PATH = "/SampleRepository/";

    private MockMvc mvc;

    @Rule
    public final MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private IndexController indexController;

    /*@Mock
    private TaskRepository taskRepository;*/

    @Mock
    private TaskReferService taskReferService;

    /*@Autowired(required=true)
    public TaskDao taskDao;*/

    @Before
    public void setup(){
    	MockitoAnnotations.initMocks(this);
    	mvc = MockMvcBuilders.standaloneSetup(this.indexController).build();
    }

    @Test
    public void indexcontroller() throws Exception {
    	List<Task> test = new ArrayList<Task>();
    	when(this.taskReferService.initDisplay()).thenReturn(null);
    	//when(taskRepository.fetchAllTask()).thenReturn(test);

    	mvc.perform(get("/tasks")).andExpect(status().isOk());
    }
}
