package com.biz.std.vo;

import java.util.List;

/**
 * Created by xjk70 on 2017/5/14.
 */
public class GradeStudentVo {
    private Integer gradeStudentId;
    private float gradeStudentAvgScore;

    public GradeStudentVo() {
    }

    public GradeStudentVo(Integer gradeStudentId, float gradeStudentAvgScore) {
        this.gradeStudentId = gradeStudentId;
        this.gradeStudentAvgScore = gradeStudentAvgScore;
    }

    public Integer getGradeStudentId() {
        return gradeStudentId;
    }

    public void setGradeStudentId(Integer gradeStudentId) {
        this.gradeStudentId = gradeStudentId;
    }

    public float getGradeStudentAvgScore() {
        return gradeStudentAvgScore;
    }

    public void setGradeStudentAvgScore(float gradeStudentAvgScore) {
        this.gradeStudentAvgScore = gradeStudentAvgScore;
    }
}