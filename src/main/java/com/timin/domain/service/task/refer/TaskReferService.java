package com.timin.domain.service.task.refer;


import com.timin.domain.task.Category;
import com.timin.domain.task.Task;

import java.util.List;

public interface TaskReferService {

    /**
     * 初期表示
     */
    List<Task> initDisplay();

    /**
     * カテゴリ
     * @return
     */
    List<Category> showCategory();

    /**
     * カテゴリに紐付かないタスク
     * @return
     */
    List<Task> showNotAssociatedTask();

}
