package com.biz.std.model;

import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by xjk70 on 2017/5/9.
 */
@Entity
@Table(name ="grade")
public class Grade {
    @Id
    @Column(length = 10, nullable = false)
    private Integer gradeId;
    @Column(length = 40)
    private String gradeName;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "grade")
    private List<Student> students;

    public Grade() {
    }

    public Grade(String gradeName, List<Student> students, float gradeAvgScore,Integer gradeNum) {
        this.gradeName = gradeName;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
