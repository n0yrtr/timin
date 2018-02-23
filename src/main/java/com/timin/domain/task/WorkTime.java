package com.timin.domain.task;

import lombok.Builder;

import java.util.List;

@Builder
public class WorkTime {
    private final List<Period> periods;
}
