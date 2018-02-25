package com.timin.presentation.controller;

import com.timin.domain.service.task.refer.TaskReferService;
import com.timin.presentation.controller.response.CardResponse;
import com.timin.presentation.controller.response.CategoryResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/task")
public class TaskReferController {
    private static final Logger logger = LogManager.getLogger(TaskReferController.class);

    @Autowired
    TaskReferService taskReferService;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<? extends CardResponse> getTaskList() {
        List<? extends CardResponse> taskList = taskReferService.initDisplay();
        logger.debug(taskList);
        return taskList;
    }

    @RequestMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<? extends CategoryResponse> getCategoryList() {
        List<? extends CategoryResponse> categories = taskReferService.showCategory();
        logger.debug(categories);
        return categories;
    }

    @RequestMapping(value = "/not_associated", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<? extends CardResponse> getNotAssociatedTaskList() {
        List<? extends CardResponse> tasks = taskReferService.showNotAssociatedTask();
        logger.debug(tasks);
        return tasks;
    }

}
