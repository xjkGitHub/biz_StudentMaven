package com.biz.std.vo;

/**
 * Created by xjk70 on 2017/5/18.
 */
public class AvgScoreAndNumVo {
    private Integer Num;
    private float avgScore;

    public AvgScoreAndNumVo() {
    }

    public AvgScoreAndNumVo(Integer num, float avgScore) {
        Num = num;
        this.avgScore = avgScore;
    }

    public Integer getNum() {
        return Num;
    }

    public void setNum(Integer num) {
        Num = num;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }
}
