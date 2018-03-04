package com.timin.domain.service.task.active.refer;

import com.timin.domain.task.Task;
import com.timin.repository.task.read.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskActiveServiceImpl implements TaskActiveService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task showActiveTask() {
        return taskRepository.getActiveTask().orElse(null);
    }
}
