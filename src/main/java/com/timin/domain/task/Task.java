package com.timin.domain.task;

import lombok.Builder;

@Builder
public class Task {
    final private Name name;
    final private WorkTime workTime;
}
