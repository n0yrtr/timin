package com.timin.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.timin.TestDataSourceConfig;
import com.timin.TiminApplication;
import com.timin.repository.task.read.TaskRepository;
import com.timin.repository.task.write.TaskActiveRepository;
import com.timin.repository.task.write.entity.Active;
import com.timin.service.task.active.update.TaskActiveUpdateService;

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
public class TaskActiveUpdateServiceTests {

	private static final String DATA_FILE_PATH = "/TaskRepository/";

	@Autowired
	private TaskActiveUpdateService taskActiveUpdateService;
	@Autowired
	private TaskRepository taskRepository;

	@Autowired
    TaskActiveRepository taskActiveRepository;

	@Test
	@DatabaseSetup(value = DATA_FILE_PATH + "fetchAll/task.xml")
	@Transactional
	public void アクティブ化できてる() {
		Long addId = 5L;
		System.out.println(taskRepository.fetchAllTask());
		Active task = taskActiveUpdateService.active(addId);
		assertThat(task.getTaskId(), is(addId));
	}

}
