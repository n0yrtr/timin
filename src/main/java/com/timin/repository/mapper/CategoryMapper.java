package com.timin.repository.mapper;

import com.timin.domain.task.Category;
import com.timin.domain.task.Task;

import java.util.List;

public interface CategoryMapper {
    Category convert(com.timin.repository.task.read.entity.Category category, List<Task> tasks);
}
