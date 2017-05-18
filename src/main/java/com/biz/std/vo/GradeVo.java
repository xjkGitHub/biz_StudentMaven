package com.biz.std.vo;

/**
 * Created by xjk70 on 2017/5/13.
 */
public class GradeVo {
    private Integer gradeId;
    private String GradeName;
    private float gradeAvgScore;
    private Integer gradeNum;

    public GradeVo() {
    }

    public GradeVo(Integer gradeId, String gradeName, float gradeAvgScore, Integer gradeNum) {
        this.gradeId = gradeId;
        GradeName = gradeName;
        this.gradeAvgScore = gradeAvgScore;
        this.gradeNum = gradeNum;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return GradeName;
    }

    public void setGradeName(String gradeName) {
        GradeName = gradeName;
    }

    public float getGradeAvgScore() {
        return gradeAvgScore;
    }

    public void setGradeAvgScore(float gradeAvgScore) {
        this.gradeAvgScore = gradeAvgScore;
    }

    public Integer getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(Integer gradeNum) {
        this.gradeNum = gradeNum;
    }
}
