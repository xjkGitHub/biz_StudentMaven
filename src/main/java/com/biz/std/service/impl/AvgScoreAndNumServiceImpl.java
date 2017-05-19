package com.biz.std.service.impl;

import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.repository.ScoreRepository;
import com.biz.std.repository.StudentRepository;
import com.biz.std.service.AvgScoreAndNumService;
import com.biz.std.vo.AvgScoreAndNumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by xjk70 on 2017/5/18.
 */
@Service
public class AvgScoreAndNumServiceImpl implements AvgScoreAndNumService {
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private StudentRepository studentRepository;

    public AvgScoreAndNumVo studentAvgScore(int id) {
        List<Score> scoreList = scoreRepository.findByStudent_Id(id);
        Score score = new Score();
        int allStudentScore = 0;
        Iterator it = scoreList.iterator();
        while (it.hasNext()) {
            score = (Score) it.next();
            allStudentScore += score.getScore();
        }
        int avgStudentScore = 0;
        try {
            avgStudentScore = allStudentScore/scoreList.size();
        }catch (Exception e){

        }
        AvgScoreAndNumVo avgScoreAndNumVo = new AvgScoreAndNumVo();
        avgScoreAndNumVo.setNum(scoreList.size());
        avgScoreAndNumVo.setAvgScore(avgStudentScore);
        return avgScoreAndNumVo;
    }

    public AvgScoreAndNumVo gradeAvgScore(int id) {
        List<Student> studentList = studentRepository.findByGrade_GradeId(id);
        Iterator it = studentList.iterator();
        int allStudentScore = 0;
        Student student = new Student();
        while (it.hasNext()) {
            student = (Student) it.next();
           allStudentScore += this.studentAvgScore(student.getId()).getAvgScore();
        }
        AvgScoreAndNumVo avgScoreAndNumVo = new AvgScoreAndNumVo();
        try {
            avgScoreAndNumVo.setAvgScore(allStudentScore / studentList.size());
        } catch (Exception e) {
        }
        avgScoreAndNumVo.setNum(studentList.size());
        return  avgScoreAndNumVo;
    }

    public AvgScoreAndNumVo subjectAvgScore(int id) {
        List<Score>scoreList = scoreRepository.findBySubject_SubjectId(id);
        Score score = new Score();
        int allSubjectScore = 0;
        Iterator it = scoreList.iterator();
        while (it.hasNext()) {
            score = (Score) it.next();
            allSubjectScore += score.getScore();
        }
         int avgSubjectScore = 0;
        try {
             avgSubjectScore = allSubjectScore/scoreList.size();
        }catch (Exception e){

        }
        AvgScoreAndNumVo avgScoreAndNumVo = new AvgScoreAndNumVo();
        avgScoreAndNumVo.setNum(scoreList.size());
        avgScoreAndNumVo.setAvgScore(avgSubjectScore);
        return  avgScoreAndNumVo;
    }
}
