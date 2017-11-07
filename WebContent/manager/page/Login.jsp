<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
          String path = request.getContextPath();
          String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
    <script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
    <link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
    <script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
     <link rel="stylesheet"  href="/BlogofMy/css/login.css">
</head>
<body background="../../images/11.jpg">
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="row-fluid">
                <div class="span4">
                </div>
                <div class="span4">
                    <form class="form-horizontal Form" action="/BlogofMy/Login_servlet" method="post">
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">UserName</label>
                            <div class="controls">
                                <input id="inputEmail" type="text" name="username"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputPassword">Password</label>
                            <div class="controls">
                                <input id="inputPassword" type="password" name="password"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <label class="checkbox"><input type="checkbox" /> 记住我</label> <button type="submit" class="btn">登陆</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="span4">
                </div>
            </div>
            <div class="row-fluid">
                <div class="span2">
                </div>
                <div class="span6">
                </div>
                <div class="span4">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>