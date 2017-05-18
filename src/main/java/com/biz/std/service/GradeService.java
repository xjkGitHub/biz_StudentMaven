package com.biz.std.service;



import java.util.List;

import com.biz.std.vo.GradeVo;
import com.biz.std.vo.StudentVo;

/**
 * Created by xjk70 on 2017/5/9.
 */
public interface GradeService {
    public void addGrade(GradeVo gradeVo);
    public void modifyGrade(GradeVo gradeVo);
    public void deleteGrade(int id);
    public GradeVo getGrade(int id);
    public List<GradeVo> getAllGrade();
    public GradeVo searchGrade(String gradeName);

}
