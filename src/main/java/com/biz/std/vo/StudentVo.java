package com.biz.std.vo;

import com.biz.std.model.Grade;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.File;
import java.util.Date;

/**
 * Created by xjk70 on 2017/5/10.
 */
public class StudentVo {
    private Integer id;
    private String  studentId;
    private String name;
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String gradeName;
    private GradeVo gradeVo;
    private Integer subjectNum;
    private float studentAvgScore;
    private String headerIm;

    public StudentVo() {
    }

    public StudentVo(Integer id, String studentId, String name, String sex, Date birthday, String gradeName, GradeVo gradeVo, Integer subjectNum, float studentAvgScore, String headerIm) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.gradeName = gradeName;
        this.gradeVo = gradeVo;
        this.subjectNum = subjectNum;
        this.studentAvgScore = studentAvgScore;
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

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public GradeVo getGradeVo() {
        return gradeVo;
    }

    public void setGradeVo(GradeVo gradeVo) {
        this.gradeVo = gradeVo;
    }

    public Integer getSubjectNum() {
        return subjectNum;
    }

    public void setSubjectNum(Integer subjectNum) {
        this.subjectNum = subjectNum;
    }

    public float getStudentAvgScore() {
        return studentAvgScore;
    }

    public void setStudentAvgScore(float studentAvgScore) {
        this.studentAvgScore = studentAvgScore;
    }

    public String getHeaderIm() {
        return headerIm;
    }

    public void setHeaderIm(String headerIm) {
        this.headerIm = headerIm;
    }
}