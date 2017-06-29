<%-- 
    Document   : newjsp
    Created on : 2017/06/29, 15:52:25
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
// switch文を利用して、以下の処理を実現してください。
// 1. 値が1なら「one」
// 値が2なら「two」
// それ以外は「想定外」と表示する処理

int type = 2;
switch(type) {
case 1:
out.print("one");
break;
case 2:out.print("two");
break;
default:
out.print("想定外");
break;
}
%>
    </body>
</html>
