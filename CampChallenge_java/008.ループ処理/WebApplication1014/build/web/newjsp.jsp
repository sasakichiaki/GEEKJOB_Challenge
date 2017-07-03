<%-- 
    Document   : newjsp
    Created on : 2017/07/03, 18:57:07
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

// while文を利用して、以下の処理を実現してください。
//1. 1000を2で割り続け、100より小さくなったらループを抜ける処理
int i = 1000; 
int count =0;
while(i < 100 == false) {
    i = i/2;
    count = count + 1;
}
out.print(count+"回でループを抜けました。");

%>

    </body>
</html>
