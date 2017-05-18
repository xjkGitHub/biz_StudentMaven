package com.biz.std.vo;

/**
 * Created by xjk70 on 2017/5/11.
 */
public class SubjectVo {
    private Integer subjectId;
    private String SubjectName;
    private Integer subjectNum;
    private float subjectAvgScore;

    public SubjectVo() {
    }

    public SubjectVo(Integer subjectId, String subjectName, Integer subjectNum, float subjectAvgScore) {
        this.subjectId = subjectId;
        SubjectName = subjectName;
        this.subjectNum = subjectNum;
        this.subjectAvgScore = subjectAvgScore;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public Integer getSubjectNum() {
        return subjectNum;
    }

    public void setSubjectNum(Integer subjectNum) {
        this.subjectNum = subjectNum;
    }

    public float getSubjectAvgScore() {
        return subjectAvgScore;
    }

    public void setSubjectAvgScore(float subjectAvgScore) {
        this.subjectAvgScore = subjectAvgScore;
    }
}
