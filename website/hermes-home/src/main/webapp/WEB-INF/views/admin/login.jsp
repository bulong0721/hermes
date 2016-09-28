<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>云帆物流管理系统 | 管理员登录</title>
    <link href="assets/plugins/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="assets/plugins/animate.css" rel="stylesheet">
    <link href="assets/plugins/style.css" rel="stylesheet">
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen animated fadeInDown">
    <div class="loginMain">
        <h3>云帆物流管理系统</h3>
        <p class="client-status info"><i class="fa fa-coffee bigger-110"></i>&nbsp;请输入您的登录信息.</p>
        <div class="text-danger"> ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</div>
        <form class="m-t" role="form" method="post" action="j_spring_security_check">
            <div class="form-group">
                <input type="text" name="username" class="form-control" placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="密码" required="">
            </div>
            <div class="form-group">
                <input type="text" name="securityCode" class="form-control" placeholder="验证码">
            </div>
            <div class="form-group"><button type="submit" class="btn btn-primary btn-block">登录</button></div>
        </form>
        <p class="m-t">
            <small>上海云帆物流有限公司 &copy; 2016</small>
        </p>
    </div>
</div>
<!-- Mainly scripts -->
<script src="assets/plugins/jquery/jquery-2.1.1.min.js"></script>
<script src="assets/plugins/bootstrap/bootstrap.min.js"></script>

</body>

</html>