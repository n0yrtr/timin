package com.timin.presentation.controller;

import com.timin.domain.service.task.refer.TaskReferService;
import com.timin.domain.service.task.update.TaskUpdateService;
import com.timin.presentation.controller.response.CardResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by naoya on 2017/10/29.
 */
@Controller("/")
public class IndexController {

    private static final Logger logger = LogManager.getLogger(IndexController.class);

    @Autowired
    TaskReferService taskReferService;

    @Autowired
    TaskUpdateService taskUpdateService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<? extends CardResponse> getTaskList() {
    	logger.debug(taskReferService);
        List<? extends CardResponse> taskList = taskReferService.initDisplay();
        logger.debug(taskList);
        return taskList;
    }
    
}
