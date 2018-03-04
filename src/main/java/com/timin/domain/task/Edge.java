package com.timin.domain.task;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Edge {
    final private LocalDateTime value;
}
