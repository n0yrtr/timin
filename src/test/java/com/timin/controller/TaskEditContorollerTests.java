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

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.timin.TestDataSourceConfig;
import com.timin.TiminApplication;
import com.timin.domain.service.task.update.TaskUpdateService;
import com.timin.presentation.controller.TaskEditController;
import com.timin.presentation.controller.request.AddTaskForm;

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


public class TaskEditContorollerTests {

    private MockMvc mvc;

    @Rule
    public final MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private TaskEditController taskEditController;

    @Mock
    private TaskUpdateService taskUpdateService;

    @Before
    public void setup(){
    	MockitoAnnotations.initMocks(this);
    	mvc = MockMvcBuilders.standaloneSetup(this.taskEditController).build();
    }

    @Test
    public void indexcontroller() throws Exception {
    	AddTaskForm form = new AddTaskForm();
    	form.setName("testName");
    	when(this.taskUpdateService.add(form)).thenReturn(null);

    	mvc.perform(post("/task/add")).andExpect(status().isOk());
    }
}
