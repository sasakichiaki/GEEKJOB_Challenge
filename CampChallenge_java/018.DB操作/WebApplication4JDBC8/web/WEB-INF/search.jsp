<%-- 
    Document   : search
    Created on : 2017/08/17, 17:49:28
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
        <form action="./RSerch" method="post">
            <p>
                検索キーワード：<input type="text" name="search" size="40">
            </p>
            <p>
                <input type="submit" value="送信"><input type="reset" value="リセット">
            </p>
        </form>
    </body>
</html>
