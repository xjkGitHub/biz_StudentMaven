package com.biz.std.controller;

import com.biz.std.service.GradeService;
import com.biz.std.service.StudentService;
import com.biz.std.vo.GradeStudentVo;
import com.biz.std.vo.GradeVo;
import com.biz.std.vo.SearchGradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xjk70 on 2017/5/13.
 */
@Controller
public class GradeController {
    @Autowired
    private GradeService gradeService;
//    @Autowired
//    private StudentService studentService;
    @RequestMapping("/addGrade")
    public ModelAndView addGrade(ModelAndView modelAndView,GradeVo gradeVo)throws Exception {

        gradeService.addGrade(gradeVo);
        modelAndView.setViewName("redirect:/getAllGrade.action");
        return  modelAndView;
    }
    @RequestMapping("/modifyGrade")
    public ModelAndView modifyGrade(HttpServletRequest request, ModelAndView modelAndView, GradeVo gradeVo) {

        gradeService.modifyGrade(gradeVo);
        modelAndView.setViewName("redirect:/getAllGrade.action");
        return modelAndView;
    }
    @RequestMapping("/searchGrade")
    public ModelAndView searchGrade(ModelAndView modelAndView,HttpServletRequest request){

        modelAndView.setViewName("modifyGrade");
        modelAndView.addObject( "grade",gradeService.getGrade(Integer.parseInt(request.getParameter("id"))));
        return  modelAndView;

    }
    @RequestMapping("/deleteGrade")
    public ModelAndView deleteGrade(HttpServletRequest request,ModelAndView modelAndView) {
        String stringId = request.getParameter("id");
        int id = Integer.parseInt(stringId);
        gradeService.deleteGrade(id);
        modelAndView.setViewName("redirect:/getAllGrade.action");
        return  modelAndView;
    }
    /**
     * 展示grades
     */
    @RequestMapping("/getAllGrade")
    public ModelAndView getAllGrade(ModelAndView modelAndView) {
        modelAndView.setViewName("tables2");
        modelAndView.addObject("grades",gradeService.getAllGrade());
        return modelAndView;
    }
     /**
     * 添加学生页面获取班级信息
     */
    @RequestMapping("/getAddGradeList")
    public ModelAndView getAddGradeList(ModelAndView modelAndView) {
        modelAndView.setViewName("/addStudent");
        modelAndView.addObject("searchGradeVoList",gradeService.getAllGrade());
        return modelAndView;
    }
}
