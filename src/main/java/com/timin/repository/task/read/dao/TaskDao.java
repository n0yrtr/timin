package com.timin.repository.task.read.dao;

import com.timin.repository.task.read.entity.Task;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Dao
@ConfigAutowireable
@Repository
public interface TaskDao {

    @Select
    List<Task> selectAll(LocalDateTime now);

    @Select
    List<Task> selectByCategoryId(Long categoryId, LocalDateTime now);

    @Select
    List<Task> selectNotAssociatedTask(LocalDateTime now);
}
