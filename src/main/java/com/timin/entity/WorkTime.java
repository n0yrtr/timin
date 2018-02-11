package com.timin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

import java.time.LocalDateTime;

@Entity(immutable = true, naming = NamingType.SNAKE_LOWER_CASE)
@Builder
@AllArgsConstructor
@Getter
public class WorkTime {

    @Id
    private final Long id;
    private final Long taskId;
    private final LocalDateTime from;
    private final LocalDateTime thru;
    private final LocalDateTime in;
    private final LocalDateTime out;

}
