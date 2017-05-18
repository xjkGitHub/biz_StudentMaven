package com.biz.std.vo;

import java.util.List;

/**
 * Created by xjk70 on 2017/5/15.
 */
public class ChooseSubjectsVo {
     private Integer chooseStudentId;
     private Integer chooseSubjectId;
     private String chooseSubjectName;
     private Integer chooseSubjectNum;

    public ChooseSubjectsVo() {
    }

    public ChooseSubjectsVo(Integer chooseStudentId, Integer chooseSubjectId, String chooseSubjectName, Integer chooseSubjectNum) {
        this.chooseStudentId = chooseStudentId;
        this.chooseSubjectId = chooseSubjectId;
        this.chooseSubjectName = chooseSubjectName;
        this.chooseSubjectNum = chooseSubjectNum;
    }

    public Integer getChooseStudentId() {
        return chooseStudentId;
    }

    public void setChooseStudentId(Integer chooseStudentId) {
        this.chooseStudentId = chooseStudentId;
    }

    public Integer getChooseSubjectId() {
        return chooseSubjectId;
    }

    public void setChooseSubjectId(Integer chooseSubjectId) {
        this.chooseSubjectId = chooseSubjectId;
    }

    public String getChooseSubjectName() {
        return chooseSubjectName;
    }

    public void setChooseSubjectName(String chooseSubjectName) {
        this.chooseSubjectName = chooseSubjectName;
    }

    public Integer getChooseSubjectNum() {
        return chooseSubjectNum;
    }

    public void setChooseSubjectNum(Integer chooseSubjectNum) {
        this.chooseSubjectNum = chooseSubjectNum;
    }
}
