<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%
          String path = request.getContextPath();
          String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
                     <!--  <%=path %> /项目名  -->
				 	 <!-- <%=basePath %>绝对路径  协议 + 主机名 + 端口号 + 当前项目名/  完整路径 -->
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 插入ckeditor 插件 -->
<script type="text/javascript" src="<%=path %>/ckeditor/ckeditor.js"></script>
<script type="text/javascript" >CKEDITOR.replace("TextArea1");</script>
<!-- 加载.js  替换文本域 -->
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
	
<link rel="stylesheet" href="<%=path %>/css/article.css">

</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 top">
			<div class="row-fluid">
				<div class="span12">
					<div class="hero-unit">
						<h1>
							Blog后台管理
						</h1>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span3">
					<ul class="nav nav-list">
					<li class="active">
							<a rel="nofollow" href="<%=path %>/Controlor?flag=1">首页</a>
						</li>
						<li>
							<a rel="nofollow" href="<%=path %>/Controlor?flag=2">用户信息</a>
						</li>
						<li>
							<a rel="nofollow" href="<%=path %>/Controlor?flag=3">用户管理</a>
						</li>
						<li class="nav-header">
							功能列表
						</li>
						<li>
							<a rel="nofollow" href="<%=path %>/Controlor?flag=4">文章管理</a>
						</li>
						<li>
							<a rel="nofollow" href="<%=path %>/Controlor?flag=5">留言管理</a>
						</li>
						<li class="divider">
						</li>
						<li>
							<a rel="nofollow" href="#">帮助</a>
						</li>
					</ul>

				</div>
				
				<div class="span9">
				 	<!-- 文章管理 -->
				 	
				 	<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<div class="nav-collapse collapse navbar-responsive-collapse">
							<ul class="nav">
								
								<li>
									<a href="<%=path %>/Article_servlet">List</a>
								</li>
								<li class="active">
									<a href="#">Write</a>
								</li>
							
							</ul>
						</div>
						
					</div>
				</div>
				
			</div>
				 	<!-- 文章导航 -->
				 
				 	<!-- 文章Write -->
				
				 	 <form action="<%=path %>/Submit_servlet" method="post" >
			         标题：<textarea rows="1" name="title"></textarea>
			        <p>Content:</p>
					<textarea id="TextArea1" rows="2" cols="20" class="ckeditor" name="content"></textarea>
					
					<input type="submit" name="提交">
					 </form>
	
				
				 	<!--  -->
				</div>
				
			</div>
			
		</div>
	</div>
</div>
</body>
</html>