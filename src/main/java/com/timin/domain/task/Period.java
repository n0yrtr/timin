package com.timin.domain.task;

import lombok.Builder;

@Builder
public class Period {
    private final Edge start;
    private final Edge end;
}
