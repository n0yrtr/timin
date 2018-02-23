package com.timin.service.task.active.update;

import java.time.LocalDateTime;

import com.timin.repository.Constant;
import com.timin.repository.task.write.entity.Active;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timin.repository.task.write.TaskActiveRepository;

@Service
public class TaskActiveUpdateServiceImpl implements TaskActiveUpdateService {

    @Autowired
    TaskActiveRepository taskActiveRepository;

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
                .from(now).thru(Constant.UNDEFINED_END_DATE)
                .in(now).out(Constant.UNDEFINED_END_DATE)
                .build();
        return taskActiveRepository.insert(insertData).getEntity();
    }

}
