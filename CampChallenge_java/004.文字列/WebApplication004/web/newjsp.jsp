<%-- 
    Document   : newjsp
    Created on : 2017/06/29, 15:03:17
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
            // 「groove」「-」「gear」の３つの文字列を連結して表示してください
String a01 = "groove";
String a02 = "-";
String a03 = "gear";
out.print(a01+a02+a03);

%>
    </body>
</html>
