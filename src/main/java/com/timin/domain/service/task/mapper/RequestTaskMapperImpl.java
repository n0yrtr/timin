package com.timin.domain.service.task.mapper;

import com.timin.domain.AddTaskInput;
import com.timin.domain.task.Name;
import com.timin.domain.task.Task;
import org.springframework.stereotype.Component;

@Component
public class RequestTaskMapperImpl implements RequestTaskMapper {
    @Override
    public Task convert(AddTaskInput input) {
        Name name = Name.builder().value(input.getName()).build();

        return Task.builder().name(name).build();
    }
}
