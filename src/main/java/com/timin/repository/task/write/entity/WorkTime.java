package com.timin.repository.task.write.entity;

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
    private final LocalDateTime dataFrom;
    private final LocalDateTime dataThru;
    private final LocalDateTime dataIn;
    private final LocalDateTime dataOut;

}
