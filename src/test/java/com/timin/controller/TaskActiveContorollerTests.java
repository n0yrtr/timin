package com.timin.controller;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.timin.TestDataSourceConfig;
import com.timin.TiminApplication;
import com.timin.service.task.active.update.TaskActiveUpdateService;

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


public class TaskActiveContorollerTests {

    private static final String DATA_FILE_PATH = "/SampleRepository/";

    private MockMvc mvc;

    @Rule
    public final MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private TaskActiveController taskActiveController;

    /*@Mock
    private TaskRepository taskRepository;*/

    @Mock
    private TaskActiveUpdateService taskActiveUpdateService;

    /*@Autowired(required=true)
    public TaskDao taskDao;*/

    @Before
    public void setup(){
    	MockitoAnnotations.initMocks(this);
    	mvc = MockMvcBuilders.standaloneSetup(this.taskActiveController).build();
    }

    @Test
    @Transactional
    public void indexcontroller() throws Exception {
    	Long taskId = 5L;
    	when(this.taskActiveUpdateService.active(taskId)).thenReturn(null);

    	mvc.perform(get("/active/" + taskId)).andExpect(status().isOk());
    }
}
