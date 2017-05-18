package com.biz.std.repository;

import com.biz.std.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xjk70 on 2017/5/9.
 */
@Repository
public interface GradeRepository extends JpaRepository<Grade,Integer> {
    Grade findByGradeName(String gradeName);
}
