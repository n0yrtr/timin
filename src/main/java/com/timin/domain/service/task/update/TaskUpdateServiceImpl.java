package com.timin.domain.service.task.update;

import com.timin.domain.AddTaskInput;
import com.timin.domain.service.task.mapper.RequestTaskMapper;
import com.timin.repository.task.write.WriteTaskRepository;
import com.timin.repository.task.write.dao.WriteTaskNameDao;
import com.timin.repository.task.write.dao.WriteTaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskUpdateServiceImpl implements TaskUpdateService {
    @Autowired
    WriteTaskRepository writeTaskRepository;
    @Autowired
    RequestTaskMapper requestTaskMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public com.timin.domain.task.Task add(AddTaskInput input) {
        LocalDateTime now = LocalDateTime.now();

        com.timin.domain.task.Task task = requestTaskMapper.convert(input);

        writeTaskRepository.addTask(task, now);

        return null;
    }
}
