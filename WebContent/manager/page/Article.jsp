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
							<a rel="nofollow" href="Controlor?flag=1">首页</a>
						</li>
						<li>
							<a rel="nofollow" href="Controlor?flag=2">用户信息</a>
						</li>
						<li>
							<a rel="nofollow" href="Controlor?flag=3">用户管理</a>
						</li>
						<li class="nav-header">
							功能列表
						</li>
						<li>
							<a rel="nofollow" href="Controlor?flag=4">文章管理</a>
						</li>
						<li>
							<a rel="nofollow" href="Controlor?flag=5">留言管理</a>
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
							
								
								<li class="active">
									<a href="#">List</a>
								</li>
								<li>
									<a href="<%=path %>/manager/page/Write.jsp">Write</a>
								</li>
							
							</ul>
						</div>
						
					</div>
				</div>
				
			</div>
				 	<!-- 文章导航 -->
				 	
				 	<!-- 文章列表 -->
				<!-- 	<%=path %>   /项目名  -->
				 <!-- 	<%=basePath %> 绝对路径  -->
				 
				 	<c:forEach var="x" items="${artlist }">
				 	<div class="decrition" >
					<a href="Detail_servlet?artuid=${x.getU_id() }&artaid=${x.getA_id()}" class="title"  >${x.getTitle() }</a>
					<p class="describe">&nbsp&nbsp&nbsp&nbsp&nbsp${x.getDescribe() }</p>
						<p class="date">${x.getDate() }</p>
					</div>
					 </c:forEach>
					
					 
					 <c:choose>
					 
					 <c:when test="${page2.getCurrentpage()==1 }">
					 			   <tr>
                        <td colspan="6" align="center">
                            <div class="pagination">
                               <ul>
                                   
                                 <c:forEach var="y" begin="1" end="${ page2.getTotalpage()}">
   
				                   	<li>
					                	<a rel="nofollow" href="Article_servlet?currentpage2=${y }">${y }</a>
					             </li>
				
                           </c:forEach>
      
				      	<li>
						<a rel="nofollow" href="Article_servlet?currentpage2=${page.getCurrentpage()+1 }">下一页</a>
					</li>
				</ul>
			</div>
			
      </td>
      </tr>
					 
					 
					 
					 
					 </c:when>
					 
					 <c:when test="${page2.getCurrentpage()>1 && page2.getCurrentpage()<page2.getTotalpage() }">
					 
					   <tr>
                        <td colspan="6" align="center">
                            <div class="pagination">
                               <ul>
                                    <li>
					                 	<a rel="nofollow" href="Article_servlet?currentpage2=${page2.getCurrentpage()-1 }">上一页</a>
				                	</li>
                                 <c:forEach var="y" begin="1" end="${ page2.getTotalpage()}">
   
				                   	<li>
					           	<a rel="nofollow" href="Article_servlet?currentpage2=${y }">${y }</a>
					             </li>
				
                           </c:forEach>
      
				      	<li>
						<a rel="nofollow" href="Article_servlet?currentpage2=${page.getCurrentpage()+1 }">下一页</a>
					</li>
				</ul>
			</div>
			
      </td>
      </tr>
					 
					 </c:when>
					 
					 <c:otherwise>
					 
					 			   <tr>
                        <td colspan="6" align="center">
                            <div class="pagination">
                               <ul>
                                    <li>
					                 	<a rel="nofollow" href="Article_servlet?currentpage2=${page2.getCurrentpage()-1 }">上一页</a>
				                	</li>
                                 <c:forEach var="y" begin="1" end="${ page2.getTotalpage()}">
   
				                   	<li>
					           	<a rel="nofollow" href="Article_servlet?currentpage2=${y }">${y }</a>
					             </li>
				
                           </c:forEach>
      
				</ul>
			</div>
			
      </td>
      </tr>
					 
					 
					 
					 </c:otherwise>
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 </c:choose>
				
				 	<!--  -->
				</div>
				
			</div>
			
		</div>
	</div>
</div>
</body>
</html>