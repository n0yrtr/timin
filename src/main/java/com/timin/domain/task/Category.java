package com.timin.domain.task;

import com.timin.presentation.controller.response.CardResponse;
import com.timin.presentation.controller.response.CategoryResponse;
import lombok.Builder;

import java.util.List;

@Builder
public class Category implements CategoryResponse {
    private String name;

    private Tasks tasks;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<? extends CardResponse> getCards() {
        return tasks.getCardResponse();
    }
}
