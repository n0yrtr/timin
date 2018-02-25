package com.timin.domain.service.task.active.update;

import com.timin.domain.task.TaskId;
import com.timin.repository.task.write.WriteTaskActiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class TaskActiveUpdateServiceImpl implements TaskActiveUpdateService {

    @Autowired
    WriteTaskActiveRepository writeTaskActiveRepository;

    /**
     *
     * ({@inheritDoc})
     *
     * @return
     */
    @Override
    public Long active(Long id) {

        LocalDateTime now = LocalDateTime.now();
        return writeTaskActiveRepository.active(TaskId.builder().value(id).build(), now).getId();
    }

}
