package com.biz.std.service.impl;

import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.repository.ScoreRepository;
import com.biz.std.repository.StudentRepository;
import com.biz.std.repository.SubjectRepository;
import com.biz.std.service.StudentService;
import com.biz.std.service.SubjectService;
import com.biz.std.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by xjk70 on 2017/5/14.
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private StudentRepository studentRepository;
    public void addSubject(SubjectVo subjectVo) {

        Subject subject = new Subject();
        subject.setSubjectId(subjectVo.getSubjectId());
        subject.setName(subjectVo.getSubjectName());
        subject.setSubjectNum(0);
        subject.setSubAvgScore(0);
        subjectRepository.save(subject);
    }

    public void modifySubject(SubjectVo subjectVo) {
        Subject subject = subjectRepository.findOne(subjectVo.getSubjectId());
        if(subjectVo!=null){
            subject.setSubjectId(subjectVo.getSubjectId());
            subject.setName(subjectVo.getSubjectName());
            subject.setSubjectNum(subjectVo.getSubjectNum());
            subject.setSubAvgScore(subjectVo.getSubjectAvgScore());
            subjectRepository.save(subject);
        }
    }

    public SubjectVo searchSubject(int id) {

        SubjectVo subjectVo = new SubjectVo();
        subjectVo.setSubjectId(subjectRepository.findOne(id).getSubjectId());
        subjectVo.setSubjectName(subjectRepository.findOne(id).getName());
        List<Score>scoreList = scoreRepository.findBySubject_SubjectId(subjectVo.getSubjectId());
        Score score = new Score();
        int allSubjectScore = 0;


            Iterator it = scoreList.iterator();
            while (it.hasNext()) {
                score = (Score) it.next();
                allSubjectScore += score.getScore();
            }
            subjectVo.setSubjectNum(scoreList.size());
            subjectVo.setSubjectAvgScore(allSubjectScore / scoreList.size());
        return  subjectVo;
    }


    public void deleteSubject(int id) {

        subjectRepository.delete(id);
    }


    public List<SubjectVo> getAllSubject() {
        List<Subject> subjectList = subjectRepository.findAll();
        List<SubjectVo> subjectVoList = new ArrayList<SubjectVo>();
        Subject subject = new Subject();
        Iterator it = subjectList.iterator();
        while (it.hasNext()) {
            subject = (Subject) it.next();
            SubjectVo subjectVo = new SubjectVo();
            subjectVo.setSubjectId(subject.getSubjectId());
            subjectVo.setSubjectName(subject.getName());
            List<Score>scoreList = scoreRepository.findBySubject_SubjectId(subjectVo.getSubjectId());
            Score score = new Score();
            int allSubjectScore = 0;
                Iterator itScores = scoreList.iterator();
                while (itScores.hasNext()) {
                    score = (Score) itScores.next();
                    allSubjectScore += score.getScore();
                }
                subjectVo.setSubjectNum(scoreList.size());
                try {
                    subjectVo.setSubjectAvgScore(allSubjectScore / scoreList.size());
                }catch (Exception e){

                }
                subjectVoList.add(subjectVo);

        }
        return subjectVoList;
    }

}
