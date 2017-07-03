<%-- 
    Document   : newjsp
    Created on : 2017/07/03, 18:49:56
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

// for文を利用して、0から100を全部足す処理を実現してください。
int total = 0;
for (int i = 1; i <= 100; i++) {
    total = total + i;
}

out.print(total);

// 回数を把握するための変数：i=1（初期値は1）
// 繰り返す条件：i<=100（iが100以下の場合繰り返す）
// １回毎の増減：i++（１回毎にiに+1する）
%>
    </body>
</html>
