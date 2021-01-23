<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员登录页面</title>
	<%--静态包含base标签、css样式、jQuery 文件--%>
	<%@ include file="/pages/common/header.jsp"%>
</head>
<body>
	<form action="userServiceServ" method="post">
		<input type="hidden" name="action" value="login"/>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">
									${requestScope.errorMsg}</span>
							</div>
							<div class="form">


									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username"
										   value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password"
											value="${requestScope.password}"/>
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />

							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%--静态包含footer内容--%>
		<%@ include file="/pages/common/footer.jsp"%>
	</form>
</body>
</html>