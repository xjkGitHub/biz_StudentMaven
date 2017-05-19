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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by xjk70 on 2017/5/15.
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;


    @Transactional
    public void saveSubject(StudentVo studentVo, Integer subjectId) {
        Student student = studentRepository.findOne(studentVo.getId());
        Subject subject = subjectRepository.findOne(subjectId);
        if (scoreRepository.findByStudent_IdAndSubject_SubjectId(student.getId(), subject.getSubjectId()) == null) {
            Score score = new Score();
            score.setScore(0);
            score.setStudent(student);
            score.setSubject(subject);
            scoreRepository.save(score);
        }
    }

    public List<ScoreVo> readInScore(int id) {
        List<ScoreVo> scoreVoList = new ArrayList<ScoreVo>();
        //用于查询学生的各科成绩
        List<Score> scoreList = new ArrayList<Score>();
        //用于查询学科平均分
        List<Score> scoreList1 = new ArrayList<Score>();
        Score score = new Score();
        int allScore = 0;
        scoreList = scoreRepository.findByStudent_Id(id);

        Iterator it = scoreList.iterator();
        while (it.hasNext()) {
            score = (Score) it.next();
            ScoreVo scoreVo = new ScoreVo();
            scoreVo.setScoreId(score.getScore());
            scoreVo.setStudentId(score.getStudent().getId());
            SubjectVo subjectVo = new SubjectVo();
            subjectVo.setSubjectId(score.getSubject().getSubjectId());
            subjectVo.setSubjectName(score.getSubject().getName());
            subjectVo.setSubjectNum(scoreList.size());
            Score score1 = new Score();
            Iterator itSubjectScore = scoreList1.iterator();
            while(itSubjectScore.hasNext()){
                score1 = (Score) itSubjectScore.next();
                allScore+=score1.getScore();
            }
            try {

                subjectVo.setSubjectAvgScore(allScore / scoreList1.size());
            }catch (Exception e){

            }
            scoreVo.setSubjectVo(subjectVo);
            scoreVo.setScore(score.getScore());
            scoreVoList.add(scoreVo);
        }
        return scoreVoList;
    }

    /**
     * 录入分数
     */
    @Transactional
    public void reReadInScore(List<ScoreVo> reScoreVoList) {
        List<Score> scoreList = new ArrayList<Score>();
        scoreList = scoreRepository.findByStudent_Id(reScoreVoList.get(0).getStudentId());
        float allScore = 0;
        if (scoreList.size() > 0) {
            for (int count = 0; count < scoreList.size(); count++) {
                Score score = scoreList.get(count);
                score.setScore(reScoreVoList.get(count).getScore());
                scoreRepository.save(score);
            }
        }
    }
}


