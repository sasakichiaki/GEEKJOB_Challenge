<%-- 
    Document   : newjsp
    Created on : 2017/07/03, 18:39:34
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

// for文を利用して、適当な変数へ文字連結を行い、中に"A"が30個入った状態にしてください。
String text = "A";
for (int i = 1; i <= 9; i++) {
    text = text + "A";
}

out.print(text);

// 繰り返す条件：i<=9（iが9以下の場合繰り返す）はじめにAがすでに設定しています。
// １回毎の増減：i++（１回毎にiに+1する）
%>
    </body>
</html>
