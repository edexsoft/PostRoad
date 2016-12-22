<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>易德矩阵 | 注册</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

<link href="/cdn/framework/style/bootstrap/3.3.7/bootstrap.css" rel="stylesheet" />
<link href="/cdn/fonts/FontAwesome/4.6.3/font-awesome.css" rel="stylesheet" />
<link href="/cdn/thirdparty/ionicons/2.0.1/ionicons.css" rel="stylesheet" />

<link href="/cdn/thirdparty/AdminLTE/2.3.6/AdminLTE.css" rel="stylesheet" />
<link href="/cdn/thirdparty/AdminLTE/2.3.6/skins/_all-skins.css" rel="stylesheet" />

<link href="/cdn/thirdparty/icheck/1.0.2/skins/square/blue.css" rel="stylesheet" />
<!--[if lt IE 9]>
    <script src="/cdn/thirdparty/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="/cdn/thirdparty/Respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body class="hold-transition register-page">
	<div class="register-box">
		<div class="register-logo">
			<a href="#"><b>易德</b>矩阵</a>
		</div>

		<div class="register-box-body">
			<p class="login-box-msg">注册账户</p>

			<form action="/root/account/register" method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" placeholder="昵称"> <span class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="text" class="form-control" placeholder="手机"> <span class="glyphicon glyphicon-phone form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" placeholder="密码"> <span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" placeholder="重复密码"> <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label> <input type="checkbox"> 同意 <a href="#">服务条款</a>
							</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<div class="social-auth-links text-center">
				<p>- OR -</p>
				<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> 微信登录 </a> <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> 谷歌登录 </a>
			</div>

			<a href="/root/account/login" class="text-center">已经注册？</a>
		</div>
		<!-- /.form-box -->
	</div>
	<!-- /.register-box -->

	<script src="/cdn/framework/javascript/jquery/3.1.0/jquery.js"></script>
	<script src="/cdn/framework/style/bootstrap/3.3.7/bootstrap.js"></script>
	<script src="/cdn/thirdparty/icheck/1.0.2/icheck.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
</body>
</html>
