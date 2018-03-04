package com.timin.domain.task;

import com.timin.presentation.controller.response.ActiveResponse;
import com.timin.presentation.controller.response.CardResponse;
import lombok.Builder;

@Builder
public class Task implements CardResponse, ActiveResponse {
    final private TaskId id;
    final private Name name;
    final private WorkTime workTime;

    @Override
    public String getId() {
        return id.getValue().toString();
    }

    @Override
    public String getTitle() {
        return name.getValue();
    }

    @Override
    public String getActiveStartTime() {
        // TODO
        return null;
    }

    @Override
    public String getElapsedTime() {
        // TODO
        return null;
    }

    @Override
    public String isActive() {
        // TODO
        return null;
    }
}
