package com.timin.repository.task.read.entity.embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.seasar.doma.Embeddable;

@Embeddable
@AllArgsConstructor
@Getter
public class TaskName {
    private final String name;
}
