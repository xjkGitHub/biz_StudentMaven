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

    public Subject() {
    }

    public Subject(String name, List<Score> scores, float subAvgScore,Integer subjectNum) {
        this.name = name;
        this.scores = scores;

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

}
