package com.biz.std.repository;

import com.biz.std.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xjk70 on 2017/5/9.
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

}
