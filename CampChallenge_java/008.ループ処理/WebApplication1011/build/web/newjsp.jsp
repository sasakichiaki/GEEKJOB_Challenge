<%-- 
    Document   : newjsp
    Created on : 2017/07/03, 17:58:20
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

// 1から10の合計を表示する処理
long total = 1;

for (int i = 1; i <= 20; i++) {
    total = total * 8;
}

out.print(total);
//今回は２０回８をかけるため値が大きくなるためlongで対応
// 回数を把握するための変数：i=1（初期値は1）
// 繰り返す条件：i<=20（iが10以下の場合繰り返す）
// １回毎の増減：i++（１回毎にiに+1する）
%>
    </body>
</html>
