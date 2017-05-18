package com.biz.std.controller;


import antlr.StringUtils;
import com.biz.std.service.GradeService;
import com.biz.std.service.StudentService;
import com.biz.std.service.SubjectService;
import com.biz.std.utils.ManagePage;
import com.biz.std.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xjk70 on 2017/5/9.
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private GradeService gradeService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping("/addStudent")
    public ModelAndView addStudent(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "studentId") String studentId,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "sex") String sex,
            @RequestParam(value = "birthday") String birthday,
            @RequestParam(value = "gradeName") String gradeName,
            HttpServletRequest request
    ) throws Exception {
        //操作文件
        String path = request.getServletContext().getRealPath("Images");
        String fileName = file.getOriginalFilename();
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //保存文件
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //封装StudentVo
        StudentVo studentVo = new StudentVo();
        studentVo.setStudentId(studentId);
        studentVo.setName(name);
        studentVo.setSex(sex);
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-dd-MM");
        String dateStringToParse = birthday;
        Date date = new Date();
        try {
            date = bartDateFormat.parse(dateStringToParse);
        } catch (Exception ex) {
        }
        studentVo.setBirthday(date);
        GradeVo gradeVo = gradeService.searchGrade(gradeName);
        studentVo.setGradeVo(gradeVo);
        studentVo.setHeaderIm(fileName);
        studentService.addStudent(studentVo);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/getAllStudent.action?currentPage=0");
        return modelAndView;
    }

    @RequestMapping("/searchStudent")
    public ModelAndView searchStudent(HttpServletRequest request, ModelAndView modelAndView, SearchStudentVo searchStudentVo) {
        String id = request.getParameter("id");
        StudentVo studentVo = studentService.searchStudent(Integer.parseInt(id));
        List<GradeVo> gradeVoList = gradeService.getAllGrade();
        modelAndView.setViewName("modifyStudent");
        modelAndView.addObject("student", studentVo);
        modelAndView.addObject("grades", gradeVoList);
        return modelAndView;
    }

    @RequestMapping("/descStudent")
    public ModelAndView descStudent(HttpServletRequest request, ModelAndView modelAndView, SearchStudentVo searchStudentVo) {
        String id = request.getParameter("id");
        DescVo descVo = studentService.descStudent(Integer.parseInt(id));
        modelAndView.setViewName("desc");
        modelAndView.addObject("desc", descVo);
        return modelAndView;
    }

    @RequestMapping("/modifyStudent")
    public ModelAndView modifyStudent(StudentVo studentVo, ModelAndView modelAndView) {
        GradeVo gradeVo = gradeService.searchGrade(studentVo.getGradeName());
        gradeVo.setGradeName(studentVo.getGradeName());
        studentVo.setGradeVo(gradeVo);
        studentService.modifyStudent(studentVo);
        modelAndView.setViewName("redirect:/getAllStudent.action?currentPage=0");
        return modelAndView;
    }

    @RequestMapping("/deleteStudent")
    public ModelAndView deleteStudent(HttpServletRequest request, ModelAndView modelAndView) {
        String stringId = request.getParameter("id");
        studentService.deleteStudent(Integer.parseInt(stringId));
        // gradeService.DelModifyGradeNum(Integer.parseInt(stringId));
        modelAndView.setViewName("redirect:/getAllStudent.action?currentPage=0");
        return modelAndView;
    }

    @RequestMapping("/getAllStudent")
    public ModelAndView getAllStudent(ManagePage managePage, HttpServletRequest request, ModelAndView modelAndView) {
        String stringPage = request.getParameter("currentPage");
        ManagePage managePage1 = new ManagePage();
        managePage.setPageSize(3);
        managePage.setAllPageCounts(managePage.getPageSize() * 5);
        if (org.apache.commons.lang3.StringUtils.isNotBlank(stringPage)) {
            managePage.setCurrentPage(Integer.parseInt(stringPage));
            if (managePage.getCurrentPage() <= 0)
                managePage.setCurrentPage(0);
        } else {
            managePage.setCurrentPage(0);
        }
        modelAndView.setViewName("tables");
        modelAndView.addObject("students", studentService.getAllStudent(managePage));
        modelAndView.addObject("page", managePage);
        return modelAndView;
    }

}
