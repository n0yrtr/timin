package com.timin.repository.task.read.dao;

import com.timin.repository.task.read.entity.Task;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Dao
@ConfigAutowireable
@Repository
public interface ActiveDao {
    @Select
    Optional<Task> getActiveTask(LocalDateTime now);
}
