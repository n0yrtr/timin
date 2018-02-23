package com.timin.repository.task.write;

import com.timin.repository.task.write.entity.Task;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import org.springframework.stereotype.Repository;

@Dao
@ConfigAutowireable
@Repository
public interface WriteTaskDao {
    @Insert
    Result<Task> insert(Task entity);

    @Update(excludeNull = true)
    Result<Task> update(Task entity);
}
