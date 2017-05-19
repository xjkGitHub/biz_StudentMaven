package com.biz.std.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by xjk70 on 2017/5/8.
 */
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10, nullable = false)
    private Integer id;
    @Column(length = 40, nullable = false)
    private String studentId;
    @Column(length = 40)
    private String name;
    @Column(length = 2)
    private String sex;
    @Temporal(TemporalType.DATE)
    @Column(length = 40)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Score> scores;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "grade_id")
    private Grade grade;
    @Column(length =254)
    private String headerIm;

    public Student() {
    }

    public Student(String studentId, String name, String sex, Date birthday, List<Score> scores, Grade grade, float avgScore, Integer subjectCounts, String headerIm) {
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.scores = scores;
        this.grade = grade;
        this.headerIm = headerIm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getHeaderIm() {
        return headerIm;
    }

    public void setHeaderIm(String headerIm) {
        this.headerIm = headerIm;
    }
}
