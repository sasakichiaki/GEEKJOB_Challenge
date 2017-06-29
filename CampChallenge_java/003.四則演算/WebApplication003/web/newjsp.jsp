<%-- 
    Document   : newjsp
    Created on : 2017/06/29, 14:29:07
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
final int NUMBER = 4;
out.print(NUMBER);
out.print("<br>");
// num1～4は、いずれも1
int num1 = 1;
int num2 = 1;
int num3 = 1;
int num4 = 1;

out.print(++num1+NUMBER); // +1されてから、print
out.print("<br>");
out.print(--num3+NUMBER);
out.print("<br>");
// 定数にはプラスすることもマイナスもできない
// out.print(NUMBER+++num1); // +1されてから、print
out.print("<br>");
%>
    </body>
</html>
