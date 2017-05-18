package com.biz.std.service.impl;

import com.biz.std.model.Grade;
import com.biz.std.model.Student;
import com.biz.std.repository.GradeRepository;
import com.biz.std.repository.StudentRepository;
import com.biz.std.service.GradeService;
import com.biz.std.service.StudentService;
import com.biz.std.vo.GradeStudentVo;
import com.biz.std.vo.GradeVo;
import com.biz.std.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xjk70 on 2017/5/13.
 */
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private StudentRepository studentRepository;
    public void addGrade(GradeVo gradeVo) {
        Grade grade = new Grade();
        grade.setGradeId(gradeVo.getGradeId());
        grade.setGradeName(gradeVo.getGradeName());
        grade.setGradeNum(gradeVo.getGradeNum());
        grade.setGradeAvgScore(gradeVo.getGradeAvgScore());
        gradeRepository.save(grade);
    }

    public void modifyGrade(GradeVo gradeVo) {
        Grade grade = gradeRepository.findOne(gradeVo.getGradeId());
        if(grade!=null){
            grade.setGradeId(gradeVo.getGradeId());
            grade.setGradeName(gradeVo.getGradeName());
            grade.setGradeNum(gradeVo.getGradeNum());
            grade.setGradeAvgScore(gradeVo.getGradeAvgScore());
            gradeRepository.save(grade);
        }

    }

    public void deleteGrade(int id) {
        gradeRepository.delete(id);
    }

    public GradeVo getGrade(int id) {
        GradeVo gradeVo = new GradeVo();
        gradeVo.setGradeId(gradeRepository.findOne(id).getGradeId());
        gradeVo.setGradeName(gradeRepository.findOne(id).getGradeName());
        List<Student> studentList = studentRepository.findByGrade_GradeId(gradeVo.getGradeId());
        int allStudentScore = 0;
        Student student = new Student();

            Iterator it = studentList.iterator();
            while (it.hasNext()) {
                student = (Student) it.next();
                allStudentScore += student.getAvgScore();
            }
        gradeVo.setGradeNum(studentList.size());
        try {
            gradeVo.setGradeAvgScore(allStudentScore / studentList.size());

        }catch (Exception e){

        }
        return gradeVo;
    }

    public List<GradeVo> getAllGrade() {
        List<Grade> gradeList = gradeRepository.findAll();
        List<GradeVo> gradeVoList = new ArrayList<GradeVo>();
        Grade grade = new Grade();
        Iterator itGrade = gradeList.iterator();
        while(itGrade.hasNext()){
            grade = (Grade)itGrade.next();
            GradeVo gradeVo = new GradeVo();
            gradeVo.setGradeId(grade.getGradeId());
            gradeVo.setGradeName(grade.getGradeName());
            List<Student> studentList = studentRepository.findByGrade_GradeId(grade.getGradeId());
            int allStudentScore = 0;
            Student student = new Student();
                Iterator itAllGrade = studentList.iterator();
                while (itAllGrade.hasNext()) {
                    student = (Student) itAllGrade.next();
                    allStudentScore += student.getAvgScore();
                }
            gradeVo.setGradeNum(studentList.size());
            try {
                gradeVo.setGradeAvgScore(allStudentScore / studentList.size());

            }catch (Exception e){

            }
            gradeVoList.add(gradeVo);
        }
        return gradeVoList;
    }

    public GradeVo searchGrade(String gradeName) {

        GradeVo gradeVo = new GradeVo();
        Grade grade = gradeRepository.findByGradeName(gradeName);
        gradeVo.setGradeId(grade.getGradeId());
        gradeVo.setGradeName(grade.getGradeName());
        List<Student> studentList = studentRepository.findByGrade_GradeId(grade.getGradeId());
        int allStudentScore = 0;
        Student student = new Student();

            Iterator itSearchGrade = studentList.iterator();
            while (itSearchGrade.hasNext()) {
                student = (Student) itSearchGrade.next();
                allStudentScore += student.getAvgScore();
            }
        gradeVo.setGradeNum(studentList.size());
        try {
            gradeVo.setGradeAvgScore(allStudentScore / studentList.size());

        }catch (Exception e){

        }
        return gradeVo;
    }

}
