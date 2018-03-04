package com.timin.repository.task.read;

import com.timin.domain.task.Task;
import com.timin.repository.mapper.TaskMapper;
import com.timin.repository.task.read.dao.ActiveDao;
import com.timin.repository.task.read.dao.TaskDao;
import com.timin.repository.task.read.dao.WorkTimeDao;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ConfigAutowireable
@Repository
public class TaskRepository {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private WorkTimeDao workTimeDao;

    @Autowired
    private ActiveDao activeDao;

    @Autowired
    private TaskMapper taskMapper;

    public List<Task> fetchAllTask() {
        LocalDateTime now = LocalDateTime.now();
        return taskDao.selectAll(now)
                .stream()
                .map(task -> taskMapper.convert(task, workTimeDao.selectByTaskId(task.getId(), now)))
                .collect(Collectors.toList());
    }

    public List<Task> fetchNotAssociatedTask() {
        LocalDateTime now = LocalDateTime.now();
        return taskDao.selectNotAssociatedTask(now)
                .stream()
                .map(task -> taskMapper.convert(task, workTimeDao.selectByTaskId(task.getId(), now)))
                .collect(Collectors.toList());
    }

    public Optional<Task> getActiveTask() {
        LocalDateTime now = LocalDateTime.now();
        Optional<com.timin.repository.task.read.entity.Task> activeTask = activeDao.getActiveTask(now);

        return activeTask.map(task -> taskMapper.convert(task, workTimeDao.selectByTaskId(task.getId(), now)));
    }
}
