package com.timin.service.task.active.update;


import com.timin.repository.task.write.entity.Active;

public interface TaskActiveUpdateService {

    /**
     * タスクのアクティブ化
     *
     * @param id
     */
    Active active(Long id);

}
