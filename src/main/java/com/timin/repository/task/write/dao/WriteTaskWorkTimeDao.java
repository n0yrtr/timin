package com.timin.repository.task.write.dao;

import com.timin.repository.task.write.entity.WorkTime;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import org.springframework.stereotype.Repository;

@Dao
@ConfigAutowireable
@Repository
public interface WriteTaskWorkTimeDao {
    @Insert
    Result<WorkTime> insert(WorkTime entity);

    @Update(excludeNull = false)
    Result<WorkTime> update(WorkTime entity);
}
