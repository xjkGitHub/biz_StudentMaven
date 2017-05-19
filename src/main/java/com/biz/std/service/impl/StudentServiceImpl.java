package com.biz.std.service.impl;

import com.biz.std.model.Grade;
import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.repository.GradeRepository;
import com.biz.std.repository.ScoreRepository;
import com.biz.std.repository.StudentRepository;
import com.biz.std.repository.SubjectRepository;
import com.biz.std.service.AvgScoreAndNumService;
import com.biz.std.service.GradeService;
import com.biz.std.service.StudentService;
import com.biz.std.service.SubjectService;

import com.biz.std.utils.ManagePage;
import com.biz.std.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xjk70 on 2017/5/9.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private AvgScoreAndNumService avgScoreAndNumService;

    @Transactional
    public void addStudent(StudentVo studentVo) {
        Student student = new Student();
        student.setStudentId(studentVo.getStudentId());
        student.setName(studentVo.getName());
        student.setSex(studentVo.getSex());
        student.setBirthday(studentVo.getBirthday());
        Grade grade = new Grade();
        grade.setGradeId(studentVo.getGradeVo().getGradeId());
        grade.setGradeName(studentVo.getGradeVo().getGradeName());
        student.setHeaderIm(studentVo.getHeaderIm());
        student.setGrade(grade);
        studentRepository.save(student);
        Grade grade1 = gradeRepository.findOne(grade.getGradeId());
        gradeRepository.save(grade1);
    }

    public StudentVo searchStudent(int id) {
        StudentVo studentVo = new StudentVo();
        Student student = studentRepository.findOne(id);
        studentVo.setId(student.getId());
        studentVo.setStudentId(student.getStudentId());
        studentVo.setName(student.getName());
        studentVo.setSex(student.getSex());
        studentVo.setBirthday(student.getBirthday());
        GradeVo gradeVo = new GradeVo();
        gradeVo.setGradeId(student.getGrade().getGradeId());
        gradeVo.setGradeName(student.getGrade().getGradeName());
        studentVo.setGradeVo(gradeVo);
        studentVo.setSubjectNum(avgScoreAndNumService.studentAvgScore(id).getNum());
        studentVo.setStudentAvgScore(avgScoreAndNumService.studentAvgScore(id).getAvgScore());

        return studentVo;
    }
    @Transactional
    public void modifyStudent(StudentVo studentVo) {
        Student student = studentRepository.findOne(studentVo.getId());
        if(student!=null){
            student.setId(studentVo.getId());
            student.setStudentId(studentVo.getStudentId());
            student.setName(studentVo.getName());
            student.setSex(studentVo.getSex());
            student.setBirthday(studentVo.getBirthday());
            Grade grade = new Grade();
            grade.setGradeId(studentVo.getGradeVo().getGradeId());
            grade.setGradeName(studentVo.getGradeVo().getGradeName());
            student.setGrade(grade);
            studentRepository.save(student);

        }

    }
    @Transactional
    public void deleteStudent(int id) {

        studentRepository.delete(id);
    }

    public List<StudentVo> getAllStudent(ManagePage managePage) {

        PageRequest pageRequest = new PageRequest(managePage.getCurrentPage(),managePage.getPageSize());
        Page<Student> studentPage = studentRepository.findAll(pageRequest);
        List<StudentVo> studentVoList = new ArrayList<StudentVo>();
        Student student = new Student();
        Iterator it = studentPage.iterator();
        while(it.hasNext()){
            student = (Student) it.next();
            StudentVo studentVo = new StudentVo();
            studentVo.setId(student.getId());
            studentVo.setStudentId(student.getStudentId());
            studentVo.setName(student.getName());
            studentVo.setSex(student.getSex());
            studentVo.setBirthday(student.getBirthday());
            GradeVo gradeVo = new GradeVo();
            gradeVo.setGradeId(student.getGrade().getGradeId());
            gradeVo.setGradeName(student.getGrade().getGradeName());
            studentVo.setGradeVo(gradeVo);
            studentVo.setSubjectNum(avgScoreAndNumService.studentAvgScore(student.getId()).getNum());
            studentVo.setStudentAvgScore(avgScoreAndNumService.studentAvgScore(student.getId()).getAvgScore());
            studentVoList.add(0, studentVo);
        }
        return studentVoList;

    }

    public DescVo descStudent(int id) {
        Student student = studentRepository.findOne(id);
        DescVo descVo = new DescVo();
        StudentVo studentVo = new StudentVo();
        studentVo.setName(student.getName());
        studentVo.setSex(student.getSex());
        studentVo.setBirthday(student.getBirthday());
        studentVo.setGradeName(student.getGrade().getGradeName());
        studentVo.setStudentAvgScore(avgScoreAndNumService.studentAvgScore(id).getAvgScore());
        studentVo.setHeaderIm(student.getHeaderIm());
        descVo.setStudentVo(studentVo);
        List<String> stringList = new ArrayList<String>();
        List<Score> scoreListSubjectName = scoreRepository.findByStudent_Id(id);
        Iterator itSubjectName = scoreListSubjectName.iterator();
        Score scoreSubjectName = new Score();
        while (itSubjectName.hasNext()) {
            scoreSubjectName = (Score) itSubjectName.next();
            Subject subject = subjectRepository.findOne(scoreSubjectName.getSubject().getSubjectId());
            stringList.add(subject.getName());
        }
        if(stringList.size() ==0){
            stringList.add("无");
        }
        descVo.setSubjectVoList(stringList);
        return descVo;
    }
}