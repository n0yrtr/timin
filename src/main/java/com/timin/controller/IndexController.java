package com.timin.controller;

import com.timin.controller.response.CardResponse;
import com.timin.domain.task.Task;
import com.timin.service.task.refer.TaskReferService;
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

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<? extends CardResponse> getTaskList() {
        List<? extends CardResponse> taskList = taskReferService.initDisplay();
        logger.debug(taskList);
        return taskList;
    }

}
