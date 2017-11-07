<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="web2.css">
	<meta charset="UTF-8">
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
				 					<form action="Update_servlet?blogerId=${bloger.getId() }" method="post">
						<fieldset>
							<legend>用户信息</legend>
							 <label>Name:</label><input type="text" name="Name"  value="${bloger.getName() }" /> <span class="help-block">New Name of You</span> 
							 <label>Email:</label><input type="text" name="Email" value="${bloger.getEmail() }" /> <span class="help-block">New Email of You.</span> 
							 <label>Tel:</label><input type="text" name="Tel" value="${bloger.getTel() }"/> <span class="help-block">New Tel of You</span>
							 <button class="btn" type="submit">提交</button>
						</fieldset>
					</form>
				 
				</div>
				
			</div>
			<div class="row-fluid">
				<div class="span12">
					<blockquote>
						<p>
							github是一个全球化的开源社区.
						</p> <small>关键词 <cite>开源</cite></small>
					</blockquote>
				</div>

			</div>
		</div>
	</div>
</div>
</body>
</html>