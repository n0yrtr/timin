package com.timin.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;

public class WorkTimeRepository {

	private static final String DATA_FILE_PATH = "/TaskRepository/";

	@Autowired
	private WorkTimeRepository workTimeRepository;

	@Test
	@DatabaseSetup(value = DATA_FILE_PATH + "selectAll/task.xml")
	public void 取得できるIDを指定した場合取得できる() {
		//workTimeRepositor
	}

}
