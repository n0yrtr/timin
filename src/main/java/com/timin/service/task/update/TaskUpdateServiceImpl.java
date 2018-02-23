package com.timin.service.task.update;

import com.timin.repository.task.write.entity.Task;
import com.timin.repository.task.write.entity.TaskName;
import com.timin.repository.Constant;
import com.timin.repository.task.write.TaskNameRepository;
import com.timin.repository.task.write.TaskRepository;
import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskUpdateServiceImpl implements TaskUpdateService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskNameRepository taskNameRepository;


    /**
     * {@inheritDoc}
     */
    @Override
    public com.timin.domain.task.Task add(String name) {
        LocalDateTime now = LocalDateTime.now();

        Task task = Task.builder()
                .from(now).thru(Constant.UNDEFINED_END_DATE)
                .in(now).out(Constant.UNDEFINED_END_DATE)
                .build();

        Result<Task> result = taskRepository.insert(task);

        TaskName nameData = TaskName.builder()
                .name(name)
                .from(now).thru(Constant.UNDEFINED_END_DATE)
                .in(now).out(Constant.UNDEFINED_END_DATE)
                .build();

        Result<TaskName> nameResult = taskNameRepository.insert(nameData);

        // FIXME
        return null;
    }
}
