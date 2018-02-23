package com.timin.repository.mapper;

import com.timin.domain.task.Task;
import com.timin.repository.task.write.entity.WorkTime;

import java.util.List;

public interface TaskMapper {
    Task convert(com.timin.repository.task.read.entity.Task task, List<WorkTime> workTimeList);
}
