package com.biz.std.service;

import com.biz.std.model.Grade;
import com.biz.std.model.Student;
import com.biz.std.utils.ManagePage;
import com.biz.std.vo.*;

import java.util.List;

/**
 * Created by xjk70 on 2017/5/9.
 */
public interface StudentService {
    public void addStudent(StudentVo studentVo);
    public StudentVo searchStudent(int id);
    public void modifyStudent(StudentVo studentVo);
    public void deleteStudent(int id);
    public List<StudentVo> getAllStudent(ManagePage managePage);
    public DescVo descStudent(int id);

}
