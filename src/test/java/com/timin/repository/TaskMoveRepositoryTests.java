package com.timin.repository;


import static org.hamcrest.Matchers.*;
//staticインポート
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.timin.ReplacementCsvDataSetLoader;
import com.timin.entity.ActiveIn;

/**
 * Created by naoya on 2018/01/02.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DbUnitConfiguration(
        dataSetLoader = ReplacementCsvDataSetLoader.class // ここでCSVでデータ読み込むReplacementDataSetLoaderのクラスを指定
)
@Transactional
public class TaskMoveRepositoryTests {

    private static final String DATA_FILE_PATH = "/SampleRepository/";

    @Autowired(required=true)
    private TaskMoveRepository taskMoveRepository;

    @Test
    @DatabaseSetup(value = DATA_FILE_PATH + "selectAll/")
    public void selectAllテスト() {
        ActiveIn expect1 = ActiveIn.builder().inTime(LocalDateTime.now()).taskId(1L).build();

        List<ActiveIn> actual = taskMoveRepository.selectAll();

        assertThat(actual, samePropertyValuesAs(expect1));



    }
}
