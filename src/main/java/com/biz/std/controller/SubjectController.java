package com.biz.std.controller;


import com.biz.std.service.ScoreService;
import com.biz.std.service.StudentService;
import com.biz.std.service.SubjectService;
import com.biz.std.vo.ChooseSubjectsVo;
import com.biz.std.vo.StudentVo;
import com.biz.std.vo.SubjectStudentVo;
import com.biz.std.vo.SubjectVo;
import com.mchange.v2.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by xjk70 on 2017/5/14.
 */
@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    StudentService studentService;
    @Autowired
    private  ScoreService scoreService;
//    @Autowired
//    private StudentService studentService;
    @RequestMapping("/addSubject")
    public ModelAndView addSubject(ModelAndView modelAndView,SubjectVo subjectVo){

        subjectService.addSubject(subjectVo);
        modelAndView.setViewName("redirect:/getAllSubject.action");
        return  modelAndView;
    }
    @RequestMapping("/searchSubject")
    public ModelAndView modifySubject(HttpServletRequest request,ModelAndView modelAndView){
        modelAndView.setViewName("modifySubject");
        modelAndView.addObject("subject",subjectService.searchSubject(Integer.parseInt(request.getParameter("id"))));
        return modelAndView;
    }
    @RequestMapping("/modifySubject")
    public ModelAndView modifySubject(ModelAndView modelAndView,SubjectVo subjectVo){
        subjectService.modifySubject(subjectVo);
        modelAndView.setViewName("redirect:/getAllSubject.action");
        return  modelAndView;
    }
    @RequestMapping("/deleteSubject")
    public ModelAndView deleteSubject(HttpServletRequest request,ModelAndView modelAndView){
        String stringId = request.getParameter("id");
        int id = Integer.parseInt(stringId);
        subjectService.deleteSubject(id);
        modelAndView.setViewName("redirect:/getAllSubject.action");
        return  modelAndView;
    }
    @RequestMapping("/getAllSubject")
    public ModelAndView getAllSubject(ModelAndView modelAndView){
        modelAndView.setViewName("tables3");
        modelAndView.addObject("subjects",subjectService.getAllSubject());
        return  modelAndView;
    }
  /*
   * 获取课程到chooseSubjects页面
   * */
    @RequestMapping("/getChooseSubjects")
    public ModelAndView getChooseSubjects(ModelAndView modelAndView,HttpServletRequest request){

        List<ChooseSubjectsVo> chooseSubjectsVos =  new ArrayList<ChooseSubjectsVo>();
        List<SubjectVo> subjectVoList = new ArrayList<SubjectVo>();
        SubjectVo subjectVo = new SubjectVo();
        subjectVoList = subjectService.getAllSubject();
       // String subjectId = request.getParameter("subjectId");
        Iterator it = subjectVoList.iterator();
        while(it.hasNext()){
            subjectVo = (SubjectVo) it.next();
//            if(StringUtils.nonEmptyString(subjectId)){
//                if(subjectVo.getSubjectId() == (Integer.parseInt(subjectId)))
//                    continue;
//            }
            ChooseSubjectsVo chooseSubjectsVo = new ChooseSubjectsVo();
            chooseSubjectsVo.setChooseStudentId(Integer.parseInt(request.getParameter("id")));
            chooseSubjectsVo.setChooseSubjectId(subjectVo.getSubjectId());
            chooseSubjectsVo.setChooseSubjectName(subjectVo.getSubjectName());
            chooseSubjectsVo.setChooseSubjectNum(subjectVo.getSubjectNum());
            chooseSubjectsVos.add(chooseSubjectsVo);

        }
        modelAndView.addObject("subjects",chooseSubjectsVos);
        modelAndView.setViewName("/chooseSubjects");
        return  modelAndView;
    }

    /*
    * 将所选的课程存入数据库中
   * */
    @RequestMapping("/saveChooseSubjects")
    public  ModelAndView saveChooseSubjects(HttpServletRequest request){
       StudentVo studentVo =  studentService.searchStudent(Integer.parseInt(request.getParameter("id")));
       int subjectId = Integer.parseInt(request.getParameter("subjectId"));
       scoreService.saveSubject(studentVo,subjectId);
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.addObject("id",studentVo.getId());
       modelAndView.addObject("subjectId",subjectId);
       modelAndView.setViewName("redirect:/getChooseSubjects.action");
       return  modelAndView;
    }
}
