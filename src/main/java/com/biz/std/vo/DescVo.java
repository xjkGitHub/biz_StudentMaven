package com.biz.std.vo;

import com.biz.std.model.Subject;

import java.util.List;

/**
 * Created by xjk70 on 2017/5/17.
 */
public class DescVo {
    private StudentVo studentVo;
    private List<String> subjectVoList;

    public DescVo() {
    }

    public DescVo(StudentVo studentVo, List<String> subjectVoList) {
        this.studentVo = studentVo;
        this.subjectVoList = subjectVoList;
    }

    public StudentVo getStudentVo() {
        return studentVo;
    }

    public void setStudentVo(StudentVo studentVo) {
        this.studentVo = studentVo;
    }

    public List<String> getSubjectVoList() {
        return subjectVoList;
    }

    public void setSubjectVoList(List<String> subjectVoList) {
        this.subjectVoList = subjectVoList;
    }
}