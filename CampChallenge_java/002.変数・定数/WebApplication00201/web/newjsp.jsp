<%-- 
    Document   : newjsp
    Created on : 2017/06/29, 12:47:58
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
       <%
        int num1 = 1990;
        String year = "年";
        int num2 = 5;
        String month = "月";
        int num3 = 12;
        String day = "日";
            out.print(num1+year+num2+month+num3+day);
        String name = "佐々木千明";
            out.print("<br>氏名"+"　"+name);
%>
    </body>
</html>
