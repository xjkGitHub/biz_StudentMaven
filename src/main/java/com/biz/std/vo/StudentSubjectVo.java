package com.biz.std.vo;

/**
 * Created by xjk70 on 2017/5/14.
 */
public class StudentSubjectVo {
    private Integer StudentSubjectId;
    private Integer StudentSubjectScore;

    public StudentSubjectVo() {
    }

    public StudentSubjectVo(Integer studentSubjectId, Integer studentSubjectScore) {
        StudentSubjectId = studentSubjectId;
        StudentSubjectScore = studentSubjectScore;
    }

    public Integer getStudentSubjectId() {
        return StudentSubjectId;
    }

    public void setStudentSubjectId(Integer studentSubjectId) {
        StudentSubjectId = studentSubjectId;
    }

    public Integer getStudentSubjectScore() {
        return StudentSubjectScore;
    }

    public void setStudentSubjectScore(Integer studentSubjectScore) {
        StudentSubjectScore = studentSubjectScore;
    }
}
