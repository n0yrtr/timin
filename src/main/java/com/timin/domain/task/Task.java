package com.timin.domain.task;

import com.timin.controller.response.CardResponse;
import lombok.Builder;

@Builder
public class Task implements CardResponse {
    final private Name name;
    final private WorkTime workTime;

    @Override
    public String getTitle() {
        return name.getValue();
    }
}
