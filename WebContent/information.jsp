<%@ page contentType="text/html; charset=UTF-8" import="java.util.LinkedList,java.util.List"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body bgcolor="#d0d0d0">

<h1>书籍信息及该作者信息</h1>
<table border="1" align="">
<tr>
    <td>ISBN</td>
    <td>bookname</td>
    <td>authorid</td>
    <td>publisher</td>
    <td>publishdate</td>
    <td>price</td>
    <td>delete</td>
<tr>
    <%List<String> list = (List<String>)session.getAttribute("list");
    for (int i = 0; i < list.size(); i+=6) {
  out.print("<td align=\"center\">"+list.get(i)+"</td>");
  out.print("<td align=\"center\">"+list.get(i+1)+"</td>");
  out.print("<td align=\"center\">"+list.get(i+2)+"</td>");
  out.print("<td align=\"center\">"+list.get(i+3)+"</td>");
  out.print("<td align=\"center\">"+list.get(i+4)+"</td>");
  out.print("<td align=\"center\">"+list.get(i+5)+"</td>"); 
  out.print("<td align=\"center\"><a href=Delete?isbn="+list.get(i)+"><button type=\"button\">删除</button></a></td>");
} %>
</tr>
</table>

<table border="1" align="">
<tr>
    <td>authorid</td>
    <td>name</td>
    <td>age</td>
    <td>country</td>
<tr>
    <%List<String> list0 = (List<String>)session.getAttribute("list0");
    for (int i = 0; i < list0.size(); i++) {
  out.print("<td align=\"center\">"+list0.get(i)+"</td>");
} %>
</tr>
</table>
<a href=Search?username=<%out.print(list0.get(1)); %>><button type="button">返回</button></a>
</body>
</html>