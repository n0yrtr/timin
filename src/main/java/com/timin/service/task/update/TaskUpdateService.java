package com.timin.service.task.update;

import com.timin.domain.task.Task;

public interface TaskUpdateService {

    /**
     * タスクの追加
     * @param name
     * @return
     */
    Task add(String name);
}
