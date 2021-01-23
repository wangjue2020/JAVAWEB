<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>尚硅谷会员注册页面</title>
	<%--静态包含base标签、css样式、jQuery 文件--%>
	<%@ include file="/pages/common/header.jsp"%>
	<script type="text/javascript">
		$(function(){
		    $("#sub_btn").click(function(){
		        var error = "!";
		        //验证用户名：必须由字母，数字下划线组成，5-12位
				var $username = $("#username").val();
				var username_pattern = /^\w{5,12}$/;
				if(! username_pattern.test($username)){
				   $("span.errorMsg").text("! invalid username");
				   return false;
				}
				//验证密码：必须由字符，数字下划线组成，5-12位
				var $password = $("#password").val();
				if(! username_pattern.test($password)){
                    $("span.errorMsg").text("! invalid password");
                    return false;
				}
				//验证确认密码：和密码相同
				var $repass = $("#repwd").val();
				if($password != $repass){
                    $("span.errorMsg").text("! invalid confirm password");
                    return false;
				}
				//邮箱验证 xxxxx@xxx.com
                var $email = $("#email").val();
				// var email_pattern = /^\w+@\w+.com$/;
				//以字母数字开头
				var email_pattern = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				if(!email_pattern.test($email)){
                    $("span.errorMsg").text("! invalid email");
                    return false;
				}
				//验证码：现在只需要验证用户输入，目前没有讲到服务器，验证码生成
				var $code = $("#code").val();
				//去掉验证码前后空格
                $code = $.trim($code);
				if($code == null || $code == ""){
                    $("span.errorMsg").text("! invalid verification code");
                    return false;
				}
                $("span.errorMsg").text("");


			});
		});
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}

	
</style>
</head>
<body>
	<form action="userServiceServ" method="post">
		<input type="hidden" name="action" value="register"/>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									${requestScope.errorMsg}
								</span>
							</div>
							<div class="form">
								<form action="regist_success.jsp">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
											value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password"
											value="${requestScope.password}"/>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd"
											value="${requestScope.password}"/>
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email"
											value="${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" id="code" name="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
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