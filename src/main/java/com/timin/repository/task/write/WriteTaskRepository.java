package com.timin.repository.task.write;

import com.timin.domain.task.Task;
import com.timin.repository.Constant;
import com.timin.repository.mapper.TaskMapper;
import com.timin.repository.task.write.dao.WriteTaskDao;
import com.timin.repository.task.write.dao.WriteTaskNameDao;
import com.timin.repository.task.write.entity.TaskName;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@ConfigAutowireable
@Repository
public class WriteTaskRepository {
    @Autowired
    private WriteTaskDao writeTaskDao;

    @Autowired
    private WriteTaskNameDao writeTaskNameDao;

    @Autowired
    private TaskMapper taskMapper;

    public void addTask(Task task, LocalDateTime now) {

        com.timin.repository.task.write.entity.Task writingTask = com.timin.repository.task.write.entity.Task.builder()
                .dataFrom(now).dataThru(Constant.UNDEFINED_END_DATE)
                .dataIn(now).dataOut(Constant.UNDEFINED_END_DATE)
                .build();

        Result<com.timin.repository.task.write.entity.Task> addedTask = writeTaskDao.insert(writingTask);

        TaskName convertedTaskName = taskMapper.convertToTaskName(task);

        TaskName writingTaskName = TaskName.builder()
                .taskId(addedTask.getEntity().getId())
                .name(convertedTaskName.getName())
                .dataFrom(now).dataThru(Constant.UNDEFINED_END_DATE)
                .dataIn(now).dataOut(Constant.UNDEFINED_END_DATE)
                .build();

        Result<TaskName> addedTaskName = writeTaskNameDao.insert(writingTaskName);
    }
}
