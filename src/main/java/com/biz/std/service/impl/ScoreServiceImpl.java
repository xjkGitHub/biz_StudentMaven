package com.biz.std.service.impl;

import com.biz.std.model.Grade;
import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.repository.GradeRepository;
import com.biz.std.repository.ScoreRepository;
import com.biz.std.repository.StudentRepository;
import com.biz.std.repository.SubjectRepository;
import com.biz.std.service.ScoreService;
import com.biz.std.vo.ScoreVo;
import com.biz.std.vo.StudentVo;
import com.biz.std.vo.SubjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by xjk70 on 2017/5/15.
 */
@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private GradeRepository gradeRepository;

    public void saveSubject(StudentVo studentVo,Integer subjectId) {
        Student student = studentRepository.findOne(studentVo.getId());
        Subject subject = subjectRepository.findOne(subjectId);
        if( scoreRepository.findByStudent_IdAndSubject_SubjectId(student.getId(),subject.getSubjectId())==null){
            Score score = new Score();
            score.setScore(0);
            score.setStudent(student);
            score.setSubject(subject);
            scoreRepository.save(score);
            List<Score> scoreSubjectList = scoreRepository.findByStudent_Id(student.getId());
            subject.setSubjectNum(scoreSubjectList.size());
            subjectRepository.save(subject);
            List<Score> scoreStudentList = scoreRepository.findBySubject_SubjectId(subject.getSubjectId());
            student.setSubjectCounts(scoreStudentList.size());
            studentRepository.save(student);
        }
    }

    public List<ScoreVo> readInScore(int id) {
        List<ScoreVo> scoreVoList = new ArrayList<ScoreVo>();
        List<Score> scoreList = new ArrayList<Score>();
        Score score = new Score();
        scoreList = scoreRepository.findByStudent_Id(id);
        Iterator it = scoreList.iterator();
        while(it.hasNext()){
            score =(Score)it.next();
            ScoreVo scoreVo = new ScoreVo();
            scoreVo.setScoreId(score.getScore());
            scoreVo.setStudentId(score.getStudent().getId());
            SubjectVo subjectVo = new SubjectVo();
            subjectVo.setSubjectId(score.getSubject().getSubjectId());
            subjectVo.setSubjectName(score.getSubject().getName());
            subjectVo.setSubjectNum(scoreList.size());
            subjectVo.setSubjectAvgScore(score.getSubject().getSubAvgScore());
            scoreVo.setSubjectVo(subjectVo);
            scoreVo.setScore(score.getScore());
            scoreVoList.add(scoreVo);
        }
        return scoreVoList;
    }
    /*
    * 录入分数，并计算平均分*/
    public void reReadInScore(List<ScoreVo> reScoreVoList) {
        List<Score> scoreList = new ArrayList<Score>();
        scoreList = scoreRepository.findByStudent_Id(reScoreVoList.get(0).getStudentId());
        float allScore = 0;
        if(scoreList.size()>0) {
            for (int count = 0; count < scoreList.size(); count++) {
               Score score = scoreList.get(count);
               score.setScore(reScoreVoList.get(count).getScore());
               scoreRepository.save(score);
               allScore+=score.getScore();
            }
            //学生平均分
            Student student =  studentRepository.findOne(scoreList.get(0).getStudent().getId());
            student.setAvgScore(allScore/scoreList.size());
            studentRepository.save(student);

            //班级平均分
            List<Student> studentList = studentRepository.findByGrade_GradeId(student.getGrade().getGradeId());
            int gradeScoreSum = 0;
            for(int studentCounts = 0;studentCounts<studentList.size();studentCounts++){
                gradeScoreSum+=studentList.get(studentCounts).getAvgScore();
            }
            Grade grade =  gradeRepository.findOne(student.getGrade().getGradeId());
            try {

                grade.setGradeAvgScore(gradeScoreSum / studentList.size());
            }catch (Exception e){

            }
            gradeRepository.save(grade);

            //学科平均分

            List<Score> scoreSubjectList = scoreRepository.findBySubject_SubjectId(scoreList.get(0).getSubject().getSubjectId());
            float allSubjectScore = 0;
            for(int studentCounts = 0;studentCounts<scoreSubjectList.size();studentCounts++){
                allSubjectScore+=scoreSubjectList.get(studentCounts).getScore();
            }
            Subject subject = subjectRepository.findOne(scoreSubjectList.get(0).getSubject().getSubjectId());
            try {

                subject.setSubAvgScore(allSubjectScore / scoreSubjectList.size());
            }catch (Exception e){

            }
            subjectRepository.save(subject);

        }

    }
}
