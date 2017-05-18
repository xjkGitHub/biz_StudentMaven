package com.biz.std.model;

import javax.persistence.*;

/**
 * Created by xjk70 on 2017/5/11.
 */
@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10, nullable = false)
    private Integer scoreId;
    @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "student_id",nullable = true)
    private Student student;
    @ManyToOne(cascade =CascadeType.REFRESH,optional = false)
    @JoinColumn(name = "subject_id",nullable = true)
    private Subject subject;
    @Column(length = 10)
    private Integer score;

    public Score() {
    }

    public Score(Integer scoreId, Student student, Subject subject,Integer score) {
        this.scoreId = scoreId;
        this.student = student;
        this.subject = subject;
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}