<%@ page contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>lab2MVC编程与云平台部署</title>
</head>
<body bgcolor="#d0d0d0">
    <center>
<p><font color="red">欢迎来到图书管理系统</font></p>
        <h2>作品查询</h2>
        <h3>可供作者：cs，hpl，王晶雁，王晓鸥<h3>
    <s:form action="Search"  theme="simple">
    <div class="form_field" style="text-align:center;">
        <s:textfield name="username" label="作家名" /><s:submit value="查询" />
        </div>
    </s:form>
    </center>
</body>
</html>
