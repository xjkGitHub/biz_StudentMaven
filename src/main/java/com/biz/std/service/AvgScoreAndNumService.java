package com.biz.std.service;

import com.biz.std.vo.AvgScoreAndNumVo;

import java.util.List;

/**
 * Created by xjk70 on 2017/5/18.
 */
public interface AvgScoreAndNumService {
    public AvgScoreAndNumVo studentAvgScore(int id);
    public AvgScoreAndNumVo gradeAvgScore(int id);
    public AvgScoreAndNumVo subjectAvgScore(int id);
}
