package com.biz.std.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by xjk70 on 2017/5/9.
 */
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @Column(length = 10, nullable = false)
    private Integer subjectId;
    @Column(length = 40)
    private String name;

    @OneToMany(mappedBy="score",cascade=CascadeType.ALL)
    private List<Score> scores;
    @Column(length = 11)
    private float subAvgScore;
    @Column(length = 10)
    private Integer subjectNum;

    public Subject() {
    }

    public Subject(String name, List<Score> scores, float subAvgScore,Integer subjectNum) {
        this.name = name;
        this.scores = scores;
        this.subAvgScore = subAvgScore;
        this.subjectNum = subjectNum;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public float getSubAvgScore() {
        return subAvgScore;
    }

    public void setSubAvgScore(float subAvgScore) {
        this.subAvgScore = subAvgScore;
    }

    public Integer getSubjectNum() {
        return subjectNum;
    }

    public void setSubjectNum(Integer subjectNum) {
        this.subjectNum = subjectNum;
    }
}
