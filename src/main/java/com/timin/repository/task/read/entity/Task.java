package com.timin.repository.task.read.entity;

import com.timin.repository.task.read.entity.embeddable.TaskName;
import lombok.*;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

import java.time.LocalDateTime;

@Entity(immutable = true, naming = NamingType.SNAKE_LOWER_CASE)
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final TaskName taskName;
    private final LocalDateTime from;
    private final LocalDateTime thru;
    private final LocalDateTime in;
    private final LocalDateTime out;


}
