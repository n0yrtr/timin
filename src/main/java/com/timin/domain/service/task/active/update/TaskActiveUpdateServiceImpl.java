package com.timin.domain.service.task.active.update;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timin.repository.Constant;
import com.timin.repository.task.write.entity.Active;
import com.timin.repository.task.write.dao.WriteTaskActiveDao;

@Service
public class TaskActiveUpdateServiceImpl implements TaskActiveUpdateService {

    @Autowired
    WriteTaskActiveDao writeTaskActiveDao;

    /**
     *
     * ({@inheritDoc})
     *
     * @return
     */
    @Override
    public Active active(Long id) {

        LocalDateTime now = LocalDateTime.now();
        Active insertData = Active.builder()
                .taskId(id)
                .dataFrom(now).dataThru(Constant.UNDEFINED_END_DATE)
                .dataIn(now).dataOut(Constant.UNDEFINED_END_DATE)
                .build();
        return writeTaskActiveDao.insert(insertData).getEntity();
    }

}
