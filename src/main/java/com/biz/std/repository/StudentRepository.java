package com.biz.std.repository;

import com.biz.std.model.Grade;
import com.biz.std.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xjk70 on 2017/5/9.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>,PagingAndSortingRepository<Student,Integer> {

    List<Student> findByGrade_GradeId(Integer gradeId);
}
