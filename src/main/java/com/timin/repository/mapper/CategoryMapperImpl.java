package com.timin.repository.mapper;

import com.timin.domain.task.Category;
import com.timin.domain.task.Task;
import com.timin.domain.task.Tasks;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category convert(com.timin.repository.task.read.entity.Category category, List<Task> entityTasks) {

        Tasks tasks = Tasks.builder().values(entityTasks).build();

        return Category.builder().name(category.getName()).tasks(tasks).build();
    }
}
