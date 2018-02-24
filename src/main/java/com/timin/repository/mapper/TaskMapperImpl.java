package com.timin.repository.mapper;

import com.timin.domain.task.*;
import com.timin.repository.task.write.entity.TaskName;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapperImpl implements TaskMapper {


    @Override
    public Task convert(com.timin.repository.task.read.entity.Task task, List<com.timin.repository.task.write.entity.WorkTime> workTimeList) {
        Name name = Name.builder().value(task.getTaskName().getName()).build();

        List<Period> periodDomainList = workTimeList.stream().map(workTime -> {
            Edge start = Edge.builder().value(workTime.getDataFrom()).build();
            Edge end = Edge.builder().value(workTime.getDataThru()).build();
            return Period.builder()
                    .start(start)
                    .end(end)
                    .build();
        }).collect(Collectors.toList());
        WorkTime workTimeDomain = WorkTime.builder().periods(periodDomainList).build();

        Task target = Task.builder().name(name).workTime(workTimeDomain).build();
        return target;
    }

    @Override
    public com.timin.repository.task.write.entity.Task convertToTask(Task task) {
        return null;
    }

    @Override
    public TaskName convertToTaskName(Task task) {
        return TaskName.builder().name(task.getTitle()).build();
    }
}
