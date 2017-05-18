package com.biz.std.service;

import com.biz.std.vo.StudentSubjectVo;
import com.biz.std.vo.StudentVo;
import com.biz.std.vo.SubjectVo;

import java.util.List;

/**
 * Created by xjk70 on 2017/5/9.
 */
public interface SubjectService {


    public void addSubject(SubjectVo subjectVo);
    public void modifySubject(SubjectVo subjectVo);
    public void deleteSubject(int id);
    public SubjectVo searchSubject(int id);
    public List<SubjectVo> getAllSubject();


}
