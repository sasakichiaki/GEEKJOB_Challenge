<%-- 
    Document   : FortuneTellingResult
    Created on : 2017/07/12, 20:32:46
    Author     : sasakichiaki
--%>
<%@page import="org.mypackage.sample.ResultData" %>
<%--  パッケージ名が違った。--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
  <%
    ResultData data = (ResultData)request.getAttribute("DATA");
  %>
  <meta http-equiv="contentType" content="text/html: charset=UTF-8">
  <title>JSP Page</title>
  </head>
  <body>
  <%
    if(data != null){
      out.print("<h1>あなたの" + data.getD() + "の運勢は、" + data.getLuck() + "です</h1>");
    }
  %>
  </body>
</html>
