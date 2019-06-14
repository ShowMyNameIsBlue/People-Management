<%--
  Created by IntelliJ IDEA.
  User: Q_X_Gang
  Date: 2019/4/9
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>头部</title>
    <link rel="stylesheet" type="text/css" href="../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
</head>

<body>
<div class="head clearfix">
    <div class="logo"><a href="#"><img src="../images/logo.png" alt="慕课商城"/></a></div>
    <div class="curr"><span>欢迎您，${STA.account}[ <a href="loginOut.do" target="_top">退出</a> ]</span></div>
</div>
</body>
</html>
