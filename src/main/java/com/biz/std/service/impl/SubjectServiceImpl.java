package com.biz.std.service.impl;

import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.repository.ScoreRepository;
import com.biz.std.repository.StudentRepository;
import com.biz.std.repository.SubjectRepository;
import com.biz.std.service.AvgScoreAndNumService;
import com.biz.std.service.StudentService;
import com.biz.std.service.SubjectService;
import com.biz.std.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private AvgScoreAndNumService avgScoreAndNumService;
    @Autowired
    private  ScoreRepository scoreRepository;

    @Transactional
    public void addSubject(SubjectVo subjectVo) {

        Subject subject = new Subject();
        subject.setSubjectId(subjectVo.getSubjectId());
        subject.setName(subjectVo.getSubjectName());
        subjectRepository.save(subject);
    }
    @Transactional
    public void modifySubject(SubjectVo subjectVo) {
        Subject subject = subjectRepository.findOne(subjectVo.getSubjectId());
        if(subjectVo!=null){
            subject.setSubjectId(subjectVo.getSubjectId());
            subject.setName(subjectVo.getSubjectName());
            subjectRepository.save(subject);
        }
    }

    public SubjectVo searchSubject(int id) {
        SubjectVo subjectVo = new SubjectVo();
        subjectVo.setSubjectId(subjectRepository.findOne(id).getSubjectId());
        subjectVo.setSubjectName(subjectRepository.findOne(id).getName());
        subjectVo.setSubjectNum(avgScoreAndNumService.subjectAvgScore(id).getNum());
        subjectVo.setSubjectAvgScore(avgScoreAndNumService.subjectAvgScore(id).getAvgScore());
        return  subjectVo;
    }

    @Transactional
    public void deleteSubject(int id) {
        List<Score> scoreList = scoreRepository.findBySubject_SubjectId(id);
        //有学生的科目不允许删除
        if(scoreList.size()==0) {
            subjectRepository.delete(id);
        }
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
            subjectVo.setSubjectNum(avgScoreAndNumService.subjectAvgScore(subject.getSubjectId()).getNum());
            subjectVo.setSubjectAvgScore(avgScoreAndNumService.subjectAvgScore(subject.getSubjectId()).getAvgScore());
                subjectVoList.add(subjectVo);
        }
        return subjectVoList;
    }

}
