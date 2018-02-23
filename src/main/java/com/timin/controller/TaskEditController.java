package com.timin.controller;

import com.timin.domain.task.Task;
import com.timin.service.task.update.TaskUpdateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by naoya on 2017/10/29.
 */
@RestController()
@RequestMapping("/task")
public class TaskEditController {

    private static final Logger logger = LogManager.getLogger(TaskEditController.class);

    @Autowired
    TaskUpdateService taskUpdateService;

    @RequestMapping("/add")
    public Task add(@RequestParam("name")String name) {
        Task task = taskUpdateService.add(name);
        return task;
    }

}
