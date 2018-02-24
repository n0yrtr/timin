package com.timin.repository.task.read.dao;

import com.timin.repository.task.write.entity.WorkTime;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Dao
@ConfigAutowireable
@Repository
public interface WorkTimeDao {
    @Select
    List<WorkTime> selectByTaskId(Long taskId, LocalDateTime now);
}
