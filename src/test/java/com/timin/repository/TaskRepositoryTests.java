package com.timin.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.timin.TestDataSourceConfig;
import com.timin.TiminApplication;
import com.timin.domain.task.Task;
import com.timin.repository.task.read.TaskRepository;
import com.timin.repository.task.read.dao.TaskDao;

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
public class TaskRepositoryTests {

	private static final String DATA_FILE_PATH = "/TaskRepository/";

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private TaskDao taskDao;

	@Test
	@DatabaseSetup(value = DATA_FILE_PATH + "fetchAll/task.xml")
	public void fetchAllTaskテスト() {
		List<Task> actual = taskRepository.fetchAllTask();

		assertThat(actual.size(), is(2));
	}

}
