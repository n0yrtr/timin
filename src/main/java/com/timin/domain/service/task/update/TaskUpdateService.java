package com.timin.domain.service.task.update;

import com.timin.domain.AddTaskInput;
import com.timin.domain.task.Task;

public interface TaskUpdateService {

    /**
     * タスクの追加
     * @param addTaskInput
     * @return
     */
    Task add(AddTaskInput addTaskInput);
}
