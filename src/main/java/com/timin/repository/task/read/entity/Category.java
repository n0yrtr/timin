package com.timin.repository.task.read.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String name;
    private final LocalDateTime dataFrom;
    private final LocalDateTime dataThru;
    private final LocalDateTime dataIn;
    private final LocalDateTime dataOut;
}