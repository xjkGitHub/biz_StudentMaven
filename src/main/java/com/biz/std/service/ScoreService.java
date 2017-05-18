package com.biz.std.service;

import com.biz.std.model.Score;
import com.biz.std.vo.ScoreVo;
import com.biz.std.vo.StudentVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjk70 on 2017/5/15.
 */
public interface ScoreService {
    public void saveSubject(StudentVo studentVo, Integer subjectId);
    public List<ScoreVo> readInScore(int id);
    public void reReadInScore(List<ScoreVo> reScoreVoList);
}
