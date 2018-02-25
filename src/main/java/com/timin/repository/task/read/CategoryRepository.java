package com.timin.repository.task.read;

import com.timin.domain.task.Category;
import com.timin.repository.mapper.CategoryMapper;
import com.timin.repository.mapper.TaskMapper;
import com.timin.repository.task.read.dao.CategoryDao;
import com.timin.repository.task.read.dao.TaskDao;
import com.timin.repository.task.read.dao.WorkTimeDao;
import com.timin.repository.task.read.entity.Task;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ConfigAutowireable
@Repository
public class CategoryRepository {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    TaskDao taskDao;

    @Autowired
    WorkTimeDao workTimeDao;

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> fetchAllTask() {
        LocalDateTime now = LocalDateTime.now();
        List<com.timin.repository.task.read.entity.Category> categories = categoryDao.selectAll(now);
        return categories.stream().map(category -> {
            Long categoryId = category.getId();
            List<Task> entityTasks = taskDao.selectByCategoryId(categoryId, now);

            List<com.timin.domain.task.Task> tasks = entityTasks.stream().map(entityTask ->
                    taskMapper.convert(entityTask, workTimeDao.selectByTaskId(entityTask.getId(), now))
            ).collect(Collectors.toList());

            return categoryMapper.convert(category, tasks);
        }).collect(Collectors.toList());
    }
}
