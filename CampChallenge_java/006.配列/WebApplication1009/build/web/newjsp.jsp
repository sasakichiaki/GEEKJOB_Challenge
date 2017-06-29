<%-- 
    Document   : newjsp
    Created on : 2017/06/29, 17:40:43
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

String[] data = {"10", "100", "soeda", "hayashi", "-20", "118", "END"};

// 配列の"soeda"を"33"に変更
data[2] = "33";

// 3番目「soeda」を表示
out.print(data[2]);

%>

    </body>
</html>
