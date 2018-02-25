package com.timin.presentation.controller;

import com.timin.presentation.controller.response.CardResponse;
import com.timin.presentation.controller.response.CategoryResponse;
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

    @RequestMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<? extends CategoryResponse> getCategoryList() {
        List<? extends CategoryResponse> categories = taskReferService.showCategory();
        logger.debug(categories);
        return categories;
    }
    
}