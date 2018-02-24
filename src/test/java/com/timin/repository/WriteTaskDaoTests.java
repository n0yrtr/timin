package com.timin.repository;


import static org.hamcrest.Matchers.*;
//staticインポート
import static org.junit.Assert.*;

import java.time.LocalDateTime;
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
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.timin.TestDataSourceConfig;
import com.timin.TiminApplication;
import com.timin.repository.task.read.dao.TaskDao;
import com.timin.repository.task.read.entity.Task;
import com.timin.repository.task.read.entity.embeddable.TaskName;

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

    @Autowired(required=true)
    public TaskDao taskDao;

    @Test
    @DatabaseSetup(value = DATA_FILE_PATH + "selectAll/task.xml")
    public void 期待している件数が取得できているか() {
        Integer expect1 = 2;

        List<Task> actual = taskDao.selectAll(LocalDateTime.of(2000,1,1,0,00));

        assertThat(actual.size(), is(expect1));
    }

    @Test
    @DatabaseSetup(value = DATA_FILE_PATH + "selectAll/task.xml")
    public void 期待している件数が取得できている() {
        Task expect1 = Task.builder()
                .id(1L)
                .dataIn(LocalDateTime.of(1996,10,11,00,22,33))
                .dataOut(LocalDateTime.of(2018,10,11,00,22,33))
                .dataFrom(LocalDateTime.of(1996,10,11,00,22,33))
                .dataThru(LocalDateTime.of(2018,10,11,00,22,33))
                .taskName(new TaskName("Name"))
                .build();

        List<Task> actual = taskDao.selectAll(LocalDateTime.of(2000,1,1,0,00));

        assertThat(actual.get(0), samePropertyValuesAs(expect1));
    }
}
