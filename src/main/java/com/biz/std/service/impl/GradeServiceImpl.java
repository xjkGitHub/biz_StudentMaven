package com.biz.std.service.impl;

import com.biz.std.model.Grade;
import com.biz.std.model.Student;
import com.biz.std.repository.GradeRepository;
import com.biz.std.repository.StudentRepository;
import com.biz.std.service.AvgScoreAndNumService;
import com.biz.std.service.GradeService;
import com.biz.std.service.StudentService;
import com.biz.std.vo.GradeStudentVo;
import com.biz.std.vo.GradeVo;
import com.biz.std.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private AvgScoreAndNumService avgScoreAndNumService;
    @Autowired
    private  StudentRepository studentRepository;

    @Transactional
    public void addGrade(GradeVo gradeVo) {
        Grade grade = new Grade();
        grade.setGradeId(gradeVo.getGradeId());
        grade.setGradeName(gradeVo.getGradeName());
        gradeRepository.save(grade);
    }

    @Transactional
    public void modifyGrade(GradeVo gradeVo) {
        Grade grade = gradeRepository.findOne(gradeVo.getGradeId());
        if(grade!=null){
            grade.setGradeId(gradeVo.getGradeId());
            grade.setGradeName(gradeVo.getGradeName());
            gradeRepository.save(grade);
        }

    }

    @Transactional
    public void deleteGrade(int id) {
        List<Student> studentList = studentRepository.findByGrade_GradeId(id);
        if(studentList.size()==0) {
            gradeRepository.delete(id);
        }
    }

    public GradeVo getGrade(int id) {
        GradeVo gradeVo = new GradeVo();
        gradeVo.setGradeId(gradeRepository.findOne(id).getGradeId());
        gradeVo.setGradeName(gradeRepository.findOne(id).getGradeName());
        gradeVo.setGradeNum(avgScoreAndNumService.gradeAvgScore(id).getNum());
        gradeVo.setGradeAvgScore(avgScoreAndNumService.gradeAvgScore(id).getAvgScore());
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
            gradeVo.setGradeNum(avgScoreAndNumService.gradeAvgScore(grade.getGradeId()).getNum());
            gradeVo.setGradeAvgScore(avgScoreAndNumService.gradeAvgScore(grade.getGradeId()).getAvgScore());
            gradeVoList.add(gradeVo);
        }
        return gradeVoList;
    }

    public GradeVo searchGrade(String gradeName) {

        GradeVo gradeVo = new GradeVo();
        Grade grade = gradeRepository.findByGradeName(gradeName);
        gradeVo.setGradeId(grade.getGradeId());
        gradeVo.setGradeName(grade.getGradeName());
        gradeVo.setGradeNum(avgScoreAndNumService.gradeAvgScore(grade.getGradeId()).getNum());
        gradeVo.setGradeAvgScore(avgScoreAndNumService.gradeAvgScore(grade.getGradeId()).getAvgScore());
        return gradeVo;
    }

}
