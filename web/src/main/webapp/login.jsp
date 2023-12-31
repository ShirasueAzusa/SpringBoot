<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>登录</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/statics/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/statics/css/nprogress.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/statics/css/custom.min.css" rel="stylesheet">
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form action="${pageContext.request.contextPath }/login" method="post">
                    <h1>KT CRM</h1>
                    <div>
                        <input type="text" class="form-control" name="usrName" placeholder="请输入用户名" required=""/>
                    </div>
                    <div>
                        <input type="password" class="form-control" name="usrPassword" placeholder="请输入密码" required=""/>
                    </div>
                    <span>${msg }</span>
                    <div>
                        <button type="submit" class="btn btn-success">登 录</button>
                        <button type="reset" class="btn btn-default">重 填</button>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <div>
                            <p>©2019 All Rights Reserved 科泰教育</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
</body>
</html>