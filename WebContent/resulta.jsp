<%@ page contentType="text/html; charset=UTF-8" import="java.util.LinkedList,java.util.List"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body bgcolor="#d0d0d0">

    <h2>
        <s:property value="username" />的作品如下：
    </h2>
<table border="1" align="">
    <%List<String> list = (List<String>)session.getAttribute("list");
    String username = (String)session.getAttribute("username");
    for (int i = 0; i < list.size(); i++) {
    	out.print("<tr>"+"<td>" + (i+1) +"</td>" + "<td><a href=Detail?title="+list.get(i)+"&username="+username+">"+list.get(i) + "</td>" +"</tr>");
} %>
</tr>
</table>
<a href=Login><button type="button">返回</button></a>
</body>
</html>