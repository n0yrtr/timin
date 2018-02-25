package com.timin.domain.task;

import com.timin.presentation.controller.response.CardResponse;
import lombok.Builder;

import java.util.List;

@Builder
public class Tasks {
    private List<Task> values;

    public List<? extends CardResponse> getCardResponse() {
        return values;
    }
}
