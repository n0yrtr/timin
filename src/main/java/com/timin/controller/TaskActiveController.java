package com.timin.controller;

import com.timin.repository.task.write.entity.Active;
import com.timin.service.task.active.update.TaskActiveUpdateService;
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

    @RequestMapping(value = "/active/{id}", method = RequestMethod.POST)
    public Active active(@PathVariable("id")Long id) {
        return taskActiveUpdateService.active(id);
    }

}
