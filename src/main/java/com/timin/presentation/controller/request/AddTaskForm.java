package com.timin.presentation.controller.request;

import com.timin.domain.AddTaskInput;

public class AddTaskForm implements AddTaskInput {
    private String value;

    public void setName(String name) {
        this.value = name;
    }

    @Override
    public String getName() {
        return this.value;
    }
}
