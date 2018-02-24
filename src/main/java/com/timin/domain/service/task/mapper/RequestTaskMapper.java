package com.timin.domain.service.task.mapper;

import com.timin.domain.AddTaskInput;
import com.timin.domain.task.Task;

public interface RequestTaskMapper {

    Task convert(AddTaskInput input);
}
