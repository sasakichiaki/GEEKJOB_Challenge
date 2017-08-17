<%-- 
    Document   : search
    Created on : 2017/08/13, 18:41:48
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
        <p>複合検索できます</p>
        <form action="./NewServlet" method="post">
            <p>
                名前：<input type="text" name="naem" size="40">
            </p>
            <p>
                年齢：:<input type="number" name="age">
            </p>
            <p>
                誕生日：<input type="date" name="date">
            </p>
            <p>
                <input type="submit" value="送信"><input type="reset" value="リセット">
            </p>
        </form>
    </body>
</html>
