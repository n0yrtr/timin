package com.timin.repository.task.write.dao;

import com.timin.repository.task.write.entity.TaskName;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Dao
@ConfigAutowireable
@Repository
public interface WriteTaskNameDao {
    @Insert
    Result<TaskName> insert(TaskName entity);

    @Update(excludeNull = true)
    Result<TaskName> update(TaskName entity);
}
