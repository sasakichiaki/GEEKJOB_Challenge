<%-- 
    Document   : newjsp
    Created on : 2017/07/02, 18:13:18
    Author     : sasakichiaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import="java.util.HashMap" %>
<%
// 連想配列の作成"1"に"AAA", "hello"に"world", "soeda"に"33", "20"に"20"
HashMap<String, String> prof =
            new HashMap<String, String>();
// 要素の追加
prof.put("1", "AAA");
prof.put("hello", "world");
prof.put("soeda", "33");
prof.put("20", "20");
%>
    </body>
</html>
