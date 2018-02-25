package com.timin.repository.task.read.dao;

import com.timin.repository.task.read.entity.Category;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Dao
@ConfigAutowireable
@Repository
public interface CategoryDao {

    @Select
    List<Category> selectAll(LocalDateTime now);
}
