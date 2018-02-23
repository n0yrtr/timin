package com.timin.repository.task.write;

import com.timin.repository.task.write.entity.TaskName;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import org.springframework.stereotype.Repository;

@Dao
@ConfigAutowireable
@Repository
public interface TaskNameRepository {
    @Insert
    Result<TaskName> insert(TaskName entity);

    @Update(excludeNull = true)
    Result<TaskName> update(TaskName entity);
}
