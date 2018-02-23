package com.timin.service.task.update;

import com.timin.repository.task.write.entity.Task;
import com.timin.repository.task.write.entity.TaskName;
import com.timin.repository.Constant;
import com.timin.repository.task.write.TaskNameRepository;
import com.timin.repository.task.write.WriteTaskDao;
import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskUpdateServiceImpl implements TaskUpdateService {
    @Autowired
    WriteTaskDao taskDao;
    @Autowired
    TaskNameRepository taskNameRepository;


    /**
     * {@inheritDoc}
     */
    @Override
    public com.timin.domain.task.Task add(String name) {
        LocalDateTime now = LocalDateTime.now();

        Task task = Task.builder()
                .dataFrom(now).dataThru(Constant.UNDEFINED_END_DATE)
                .dataIn(now).dataOut(Constant.UNDEFINED_END_DATE)
                .build();

        Result<Task> result = taskDao.insert(task);

        TaskName nameData = TaskName.builder()
                .name(name)
                .dataFrom(now).dataThru(Constant.UNDEFINED_END_DATE)
                .dataIn(now).dataOut(Constant.UNDEFINED_END_DATE)
                .build();

        Result<TaskName> nameResult = taskNameRepository.insert(nameData);

        // FIXME
        return null;
    }
}
