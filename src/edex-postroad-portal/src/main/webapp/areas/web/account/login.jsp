<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>易德矩阵 | 登录</title>
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
<body class="hold-transition login-page">
    <div class="login-box">
        <div class="login-logo">
            <a href="#">
                <b>易德</b>矩阵
            </a>
        </div>
        <!-- /.login-logo -->
        <div class="login-box-body">
            <p class="login-box-msg">登录</p>
            
			<c:if test="${param.error != null}">
	            <p>Invalid username and password.</p>
	        </c:if>
	        <c:if test="${param.logout != null}">
	            <p>You have been logged out.</p>
	        </c:if>

            <form action="/account/login2?r=x" method="post">
                <div class="form-group has-feedback">
                    <input type="text" name="account" class="form-control" placeholder="手机号"> 
                    <span class="glyphicon glyphicon-phone form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input type="password" name="password" class="form-control" placeholder="密码"> 
                    <!--  
                    http://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    -->
                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                        <div class="checkbox icheck">
                            <label> 
                                <input type="checkbox" name="rememberMe"> 记住我
                            </label>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-xs-4">
                        <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

            <div class="social-auth-links text-center">
                <p>- 或者 -</p>
                <a href="#" class="btn btn-block btn-social btn-facebook btn-flat">
                    <i class="fa fa-facebook"></i> 微信登录
                </a>
                <a href="#" class="btn btn-block btn-social btn-google btn-flat">
                    <i class="fa fa-google-plus"></i> 谷歌登录
                </a>
            </div>
            <!-- /.social-auth-links -->
            <a href="/account/forgotpassword">忘记密码</a>
            <br>
            <a href="/account/register" class="text-center">注册</a>
        </div>
        <!-- /.login-box-body -->
    </div>
    <!-- /.login-box -->

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
