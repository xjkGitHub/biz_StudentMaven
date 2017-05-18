package com.biz.std.vo;

/**
 * Created by xjk70 on 2017/5/15.
 */
public class ScoreVo {
    private Integer scoreId;
    private Integer score;
    private SubjectVo subjectVo;
    private Integer studentId;

    public ScoreVo() {
    }

    public ScoreVo(Integer scoreId, Integer score, SubjectVo subjectVo, Integer studentId) {
        this.scoreId = scoreId;
        this.score = score;
        this.subjectVo = subjectVo;
        this.studentId = studentId;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public SubjectVo getSubjectVo() {
        return subjectVo;
    }

    public void setSubjectVo(SubjectVo subjectVo) {
        this.subjectVo = subjectVo;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
