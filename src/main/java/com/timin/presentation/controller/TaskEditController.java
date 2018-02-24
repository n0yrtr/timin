package com.timin.presentation.controller;

import com.timin.domain.task.Task;
import com.timin.domain.service.task.update.TaskUpdateService;
import com.timin.presentation.controller.request.AddTaskForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by naoya on 2017/10/29.
 */
@RestController()
@RequestMapping("/task")
public class TaskEditController {

    private static final Logger logger = LogManager.getLogger(TaskEditController.class);

    @Autowired
    TaskUpdateService taskUpdateService;

    @PostMapping(value = "/add")
    public Task add(@ModelAttribute AddTaskForm taskForm) {
        Task task = taskUpdateService.add(taskForm);
        return task;
    }

}
