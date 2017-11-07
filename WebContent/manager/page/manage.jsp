<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="web2.css">

</head>
<body>
	<script>
	function isclick(){
		if (window.confirm("你确定要删除这条记录吗？")){
			return true;
		}
		return false;
	}
	</script>
	
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
				
				<!--首页为tag = 1 
				        用户信息为tag = 2
				         用户管理为tag = 3
				       文章管理为tag = 4
				      留言管理为tag = 5 
				     五种情况的不同显示-->
				      
				<c:choose>
				
				<c:when test="${tag  == 1}">
						<div class="span9">
					   <c:if test="${mes != NULL}">
					    <p>${mes }</p>
					   </c:if>
					
				</div>
				</c:when>
				
				
				<c:when test="${tag == 2}">
	        			<div class="span9">
			<h3>
				当前用户信息
			</h3>
			<table class="table">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							用户名
						</th>
						<th>
							Email
						</th>
						<th>
							Tel
						</th>
						<th>
							注册日期
						</th>
					</tr>
				</thead>
				
				<tbody>
			<!-- 当前用户信息currentuser，应该是在登陆之后就保存在服务器的Session上  sessionScope.获取-->
	     		<tr class="info">
						<td>
							${sessionScope.currentuser.getId() }
						</td>
						<td>
							${sessionScope.currentuser.getName() }
						</td>
						<td>
							${sessionScope.currentuser.getEmail() }
						</td>
						<td>
							${sessionScope.currentuser.getTel() }
						</td>
						<td>
							${sessionScope.currentuser.getDate() }
						</td>
					</tr>
				</tbody>
				
			</table>
		</div>
         </c:when>
				  
					<c:when test="${tag == 3}">
				       			<div class="span9">
			<h3>
				所有用户信息
			</h3>
			<table class="table">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							用户名
						</th>
						<th>
							Email
						</th>
						<th>
							Tel
						</th>
						<th>
							注册日期
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				<!-- 获得列表 ，然后列表遍历对背景色控制，%4 （0-3 四种背景色交替） -->
				    		 	 <!-- 分页显示，每页五条数据 -->
					 
					<c:forEach var="x" items="${Userlist}">
					
				   <!-- <c:if test="${x.getId() % 4 == 1 }">
				     <c:set var="Class" value="success"></c:set>
				     </c:if>
				     
				     <c:if test="${x.getId() % 4 == 2 }">
				     <c:set var="Class" value="error"></c:set>
				     </c:if>
				     
				     <c:if test="${x.getId() % 4 == 3 }">
				     <c:set var="Class" value="warning"></c:set>
				     </c:if>
				     
				     <c:if test="${x.getId() % 4 == 0 }">
				     <c:set var="Class" value="info"></c:set>
				     </c:if>
				      -->  
				      
				<c:choose>
					
					 <c:when test=" ${x.getId() % 4 == 1 }"> 
					
					<tr class="success">
						<td>
							${x.getId() }
						</td>
						<td>
							${x.getName() }
						</td>
						<td>
							${x.getEmail() }
						</td>
						<td>
						    ${x.getTel() }
						</td>
						<td>
							${x.getDate() }
						</td>
							<td>
							<a href="updateControlor?blogerId=${x.getId() }">修改</a>&nbsp&nbsp&nbsp&nbsp<a href="Delete_servlet?blogerId=${x.getId() }" onclick="return isclick()">删除</a>
						</td>
					</tr>
					
				-  </c:when>
					
					<c:when test="${x.getId() % 4 == 2 }">
					<tr class="error">
				<td>
							${x.getId() }
						</td>
						<td>
							${x.getName() }
						</td>
						<td>
							${x.getEmail() }
						</td>
						<td>
						    ${x.getTel() }
						</td>
						<td>
							${x.getDate() }
						</td>
						<td>
						<a href="updateControlor?blogerId=${x.getId() }">修改</a>&nbsp&nbsp&nbsp&nbsp<a href="Delete_servlet?blogerId=${x.getId() }" onclick="return isclick()">删除</a>
						</td>
					</tr>
					
					</c:when>
					
					<c:when test="${x.getId() % 4 == 3 }">
					<tr class="warning">
							<td>
							${x.getId() }
						</td>
						<td>
							${x.getName() }
						</td>
						<td>
							${x.getEmail() }
						</td>
						<td>
						    ${x.getTel() }
						</td>
						<td>
							${x.getDate() }
						</td>
						<td>
						<a href="updateControlor?blogerId=${x.getId() }">修改</a>&nbsp&nbsp&nbsp&nbsp<a href="Delete_servlet?blogerId=${x.getId() }" onclick="return isclick()">删除</a>
						</td>
					</tr>
					</c:when>
					
					<c:otherwise>
					<tr class="info">
					<td>
							${x.getId() }
						</td>
						<td>
							${x.getName() }
						</td>
						<td>
							${x.getEmail() }
						</td>
						<td>
						    ${x.getTel() }
						</td>
						<td>
							${x.getDate() }
						</td>
						<td>
							<a href="updateControlor?blogerId=${x.getId() }">修改</a>&nbsp&nbsp&nbsp&nbsp<a href="Delete_servlet?blogerId=${x.getId() }" onclick="return isclick()">删除</a>
						</td>
					</tr>
					</c:otherwise>
					
					</c:choose>
						
					
					</c:forEach>
					
					<!-- 分页 -->
                        <c:choose>
       <c:when test="${page.getCurrentpage() >1 && page.getCurrentpage() < page.getTotalpage()}">
      <tr>
      <td colspan="6" align="center">
        <div class="pagination">
        <ul>
        <li>
						<a rel="nofollow" href="Allbloguser?currentpage=${page.getCurrentpage()-1 }">上一页</a>
					</li>
      <c:forEach var="y" begin="1" end="${ page.getTotalpage()}">
   
					<li>
						<a rel="nofollow" href="Allbloguser?currentpage=${y }">${y }</a>
					</li>
				
      </c:forEach>
      
					<li>
						<a rel="nofollow" href="Allbloguser?currentpage=${page.getCurrentpage()+1 }">下一页</a>
					</li>
				</ul>
			</div>
			
      </td>
      </tr>
      </c:when>
      
      <c:when test="${page.getCurrentpage() == 1}">
           <tr>
      <td colspan="6" align="center">
        <div class="pagination">
        <ul>
      <c:forEach var="y" begin="1" end="${page.getTotalpage()}">
   
					<li>
						<a rel="nofollow" href="Allbloguser?currentpage=${y }">${y }</a>
					</li>
				
      </c:forEach>
                   <c:if test="${page.getTotalpage() > 1}">
					<li>
						<a rel="nofollow" href="Allbloguser?currentpage=${page.getCurrentpage()+1 }">下一页</a>
					</li>
					</c:if>
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
						<a rel="nofollow" href="Allbloguser?currentpage=${page.getCurrentpage()-1 }">上一页</a>
					</li>
      <c:forEach var="y" begin="1" end="${page.getTotalpage()}">
   
					<li>
						<a rel="nofollow" href="Allbloguser?currentpage=${y }">${y }</a>
					</li>
				
      </c:forEach>
				</ul>
			</div>
			
      </td>
      </tr>
      </c:otherwise>
      
       </c:choose>
				</tbody>
			</table>
		</div>
		
				</c:when>
				
					<c:when test="${tag  == 4 }">
				   
				</c:when>
				
				<c:otherwise>
				
				</c:otherwise>
				
				</c:choose>
				
		
			</div>
			<!--  <div class="row-fluid"> row-fluid 是流动式布局的后缀 要固定  只要去掉fluid即可 解决表格数据少时候的移动--> 
			
			
		</div>
	</div>
</div>
</body>
</html>