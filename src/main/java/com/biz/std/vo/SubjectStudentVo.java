package com.biz.std.vo;

/**
 * Created by xjk70 on 2017/5/14.
 */
public class SubjectStudentVo {
    private Integer subjectStudentId;
    private float subjectStudentAvgScore;

    public SubjectStudentVo() {
    }

    public SubjectStudentVo(Integer subjectStudentId, float subjectStudentAvgScore) {
        this.subjectStudentId = subjectStudentId;
        this.subjectStudentAvgScore = subjectStudentAvgScore;
    }

    public Integer getSubjectStudentId() {
        return subjectStudentId;
    }

    public void setSubjectStudentId(Integer subjectStudentId) {
        this.subjectStudentId = subjectStudentId;
    }

    public float getSubjectStudentAvgScore() {
        return subjectStudentAvgScore;
    }

    public void setSubjectStudentAvgScore(float subjectStudentAvgScore) {
        this.subjectStudentAvgScore = subjectStudentAvgScore;
    }
}
