
<%--
  Created by IntelliJ IDEA.
  User: xjk70
  Date: 2017/5/12
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>添加学科</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- basic styles -->

    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="assets/css/font-awesome.min.css" />

    <!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
    <![endif]-->

    <!-- page specific plugin styles -->

    <!-- fonts -->

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

    <!-- ace styles -->

    <link rel="stylesheet" href="assets/css/ace.min.css" />
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="assets/css/ace-skins.min.css" />

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->

    <script src="assets/js/ace-extra.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="${pageContext.request.contextPath}/getAllStudent.action" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    学生管理系统
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <div class="sidebar" id="sidebar">
            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
            </script>
            <ul class="nav nav-list">
                <li class="active">
                    <a href="${pageContext.request.contextPath}/getAllStudent.action">
                        <i class="icon-dashboard"></i>
                        <span class="menu-text"> 学生管理 </span>
                    </a>
                </li>

            </ul><!-- /.nav-list -->
            <ul class="nav nav-list">
                <li class="active">
                    <a href="${pageContext.request.contextPath}/getAllGrade.action">
                        <i class="icon-dashboard"></i>
                        <span class="menu-text"> 班级管理 </span>
                    </a>
                </li>

            </ul><!-- /.nav-list -->
            <ul class="nav nav-list">
                <li class="active">
                    <a href="${pageContext.request.contextPath}/getAllSubject.action">
                        <i class="icon-dashboard"></i>
                        <span class="menu-text"> 学科管理 </span>
                    </a>
                </li>

            </ul><!-- /.nav-list -->

            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
            </div>

            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
            </script>
        </div>

        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="${pageContext.request.contextPath}/getAllSubject.action">Home</a>
                    </li>

                    <li>
                        <a href="addSubject.jsp">AddSubject</a>
                    </li>

                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        SubjectTables
                        <small>
                            <i class="icon-double-angle-right"></i>
                            AddSubject
                        </small>
                    </h1>
                </div><!-- /.page-header -->
                <form class="form-horizontal" action="${pageContext.request.contextPath}/addSubject.action" method="post">

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"> SubjectId </label>

                        <div class="col-sm-9">
                            <input type="text" id="2" name = "SubjectId" placeholder="SubjectId.." class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"> SubjectName </label>

                        <div class="col-sm-9">
                            <input type="text" id="3" name = "SubjectName" placeholder="SubjectName.." class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"> SubjectNum </label>

                        <div class="col-sm-9">
                            <input type="text" id="form-field-2" name = "SubjectNum" placeholder="SubjectNum.." class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"> SubjectAvgScore</label>

                        <div class="col-sm-9">
                            <input type="text" id="1" name = "SubjectAvgScore" placeholder="SubjectAvgScore.." class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="clearfix form-actions">
                        <div class="col-md-offset-4 col-md-9">
                            <input class="btn btn-info" type="submit">
                            </input>


                            &nbsp; &nbsp; &nbsp;&nbsp;
                            <input class="btn" type="reset">
                            </input>
                        </div>
                    </div>

                </form>
            </div>
        </div><!-- /.row -->
    </div><!-- /.page-content -->
</div><!-- /.main-content -->






<!-- basic scripts -->

<!--[if !IE]> -->

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

<!--[if !IE]> -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<script src="assets/js/jquery.dataTables.min.js"></script>
<script src="assets/js/jquery.dataTables.bootstrap.js"></script>

<!-- ace scripts -->

<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace.min.js"></script>
</body>
</html>
