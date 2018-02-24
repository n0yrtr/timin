package com.timin.repository;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.timin.TestDataSourceConfig;
import com.timin.TiminApplication;
import com.timin.repository.task.write.dao.WriteTaskDao;
import com.timin.repository.task.write.entity.Task;

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
@Transactional
public class WriteTaskDaoTests {

    private static final String DATA_FILE_PATH = "/SampleRepository/";

    @Autowired
    public WriteTaskDao writeTaskDao;

    @Test
    @DatabaseSetup(value = DATA_FILE_PATH + "selectAll/task.xml")
    @Transactional
    public void 一件登録する() {
    	LocalDateTime now = LocalDateTime.now();
    	Task insertData = Task.builder()
                .dataFrom(now).dataThru(Constant.UNDEFINED_END_DATE)
                .dataIn(now).dataOut(Constant.UNDEFINED_END_DATE)
                .build();
    	assertThat(writeTaskDao.insert(insertData).getCount(), is(1));
    }
}
