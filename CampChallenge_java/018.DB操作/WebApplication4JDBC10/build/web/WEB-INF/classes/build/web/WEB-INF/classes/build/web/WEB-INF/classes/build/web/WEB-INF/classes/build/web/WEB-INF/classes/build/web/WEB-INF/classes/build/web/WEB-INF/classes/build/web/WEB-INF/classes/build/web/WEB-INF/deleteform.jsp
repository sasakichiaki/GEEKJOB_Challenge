<%-- 
    Document   : deleteform
    Created on : 2017/08/17, 21:35:22
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
        <p>削除するprofileIDを教えてください。</p>
        <form action="./Delete" method="post">
            <p>
                profileID:<input type="number" name="id">
            </p>
            <p>
                <input type="submit" value="送信"><input type="reset" value="リセット">
            </p>
        </form>
    </body>
</html>
