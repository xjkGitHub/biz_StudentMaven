package com.biz.std.controller;

import com.biz.std.service.ScoreService;
import com.biz.std.service.StudentService;
import com.biz.std.vo.ScoreVo;
import com.biz.std.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xjk70 on 2017/5/15.
 */
@Controller
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private StudentService studentService;
    @RequestMapping("/getReadInScore")
       public ModelAndView redeInScore(ModelAndView modelAndView, HttpServletRequest request)throws Exception{
        modelAndView.setViewName("readInScore");
        if(scoreService.readInScore(Integer.parseInt(request.getParameter("id"))).size()>0) {
            modelAndView.addObject("readInScore", scoreService.readInScore(Integer.parseInt(request.getParameter("id"))));
        }
        return modelAndView;
    }
    @RequestMapping("/saveReadInScore")
        public ModelAndView saveReadInScore(HttpServletRequest request,ModelAndView modelAndView){
        List<ScoreVo> scoreVoList =  scoreService.readInScore(Integer.parseInt(request.getParameter("id")));
        List<ScoreVo> reScoreList = new ArrayList<ScoreVo>();
        int allScore = 0;
                Iterator it = scoreVoList.iterator();
        while(it.hasNext()){
            ScoreVo scoreVo = new ScoreVo();
            scoreVo = (ScoreVo) it.next();
            scoreVo.setScore( Integer.parseInt( request.getParameter(scoreVo.getSubjectVo().getSubjectName())));
            allScore+=scoreVo.getScore();
            reScoreList.add(scoreVo);
        }
        scoreService.reReadInScore(reScoreList);
        modelAndView.setViewName("redirect:/getAllStudent.action");
        return  modelAndView;
    }
}
