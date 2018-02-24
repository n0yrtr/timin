package com.timin.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.timin.repository.task.read.dao.WorkTimeDao;
import com.timin.repository.task.write.entity.WorkTime;

public class WorkTimeDaoTests {

	private static final String DATA_FILE_PATH = "/WorkTimeDao/";

	@Autowired
	WorkTimeDao workTimeDao;

	@Test
	@DatabaseSetup(value = DATA_FILE_PATH + "selectByTaskId/task.xml")
	public void taskIdが5の場合1件取得する() {
		Long taskId = 5L;
		LocalDateTime now = LocalDateTime.now();
		List<WorkTime> actual = workTimeDao.selectByTaskId(taskId, now);

		assertThat(actual.size(), is(1));
	}

	@Test
	@DatabaseSetup(value = DATA_FILE_PATH + "selectByTaskId/task.xml")
	public void taskIdが2の場合取得できない() {
		Long taskId = 2L;
		LocalDateTime now = LocalDateTime.now();
		List<WorkTime> actual = workTimeDao.selectByTaskId(taskId, now);

		assertThat(actual.size(), is(0));
	}

}
