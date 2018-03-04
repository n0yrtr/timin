package com.timin.presentation.controller;

import com.timin.domain.service.task.active.refer.TaskActiveService;
import com.timin.domain.service.task.active.update.TaskActiveUpdateService;
import com.timin.presentation.controller.response.CardResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2017/10/29.
 */
@RestController()
@RequestMapping("/task")
public class TaskActiveController {

    private static final Logger logger = LogManager.getLogger(TaskActiveController.class);

    @Autowired
    TaskActiveUpdateService taskActiveUpdateService;

    @Autowired
    TaskActiveService taskActiveService;

    @RequestMapping(value = "/active/{id}", method = RequestMethod.POST)
    public Long active(@PathVariable("id")Long id) {
        return taskActiveUpdateService.active(id);
    }

    @RequestMapping(value = "/active", method = RequestMethod.GET)
    public CardResponse getActive() {
        return taskActiveService.showActiveTask();
    }
}
