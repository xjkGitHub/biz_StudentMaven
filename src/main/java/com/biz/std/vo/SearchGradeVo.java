package com.biz.std.vo;

/**
 * Created by xjk70 on 2017/5/11.
 */
public class SearchGradeVo {

    private Integer gradeId;
    private String gradeName;
    private float gradeAvgScore;
    private Integer gradeNum;

    public SearchGradeVo() {
    }

    public SearchGradeVo(Integer gradeId, String gradeName, float gradeAvgScore, Integer gradeNum) {
        this.gradeId = gradeId;
        this.gradeName = gradeName;
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
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
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
