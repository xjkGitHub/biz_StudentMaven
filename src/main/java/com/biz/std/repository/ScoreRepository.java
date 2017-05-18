package com.biz.std.repository;

import com.biz.std.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xjk70 on 2017/5/14.
 */
@Repository
public interface ScoreRepository  extends JpaRepository<Score,Integer>{
    List<Score> findBySubject_SubjectId(Integer subjectId);
    List<Score> findByStudent_Id(Integer studentId);
    Score findByStudent_IdAndSubject_SubjectId(Integer studentId,Integer Subject);
}
