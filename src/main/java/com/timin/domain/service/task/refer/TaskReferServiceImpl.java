package com.timin.domain.service.task.refer;


import com.timin.domain.task.Task;
import com.timin.repository.task.read.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskReferServiceImpl implements TaskReferService {

    @Autowired
    private TaskRepository taskRepository;


    /**
     * ({@inheritDoc})
     *
     * @return
     */
    @Override
    public List<Task> initDisplay() {
        return taskRepository.fetchAllTask();
    }
}
