package com.timin.repository.task.write;

import com.timin.domain.task.TaskId;
import com.timin.repository.Constant;
import com.timin.repository.task.write.dao.WriteTaskActiveDao;
import com.timin.repository.task.write.entity.Active;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@ConfigAutowireable
@Repository
public class WriteTaskActiveRepository {

    @Autowired
    WriteTaskActiveDao writeTaskActiveDao;

    public Active active(TaskId taskId, LocalDateTime now) {
        Active active = Active.builder().taskId(taskId.getValue())
                .dataFrom(now).dataThru(Constant.UNDEFINED_END_DATE)
                .dataIn(now).dataOut(Constant.UNDEFINED_END_DATE)
                .build();


        return writeTaskActiveDao.insert(active).getEntity();
    }
}
