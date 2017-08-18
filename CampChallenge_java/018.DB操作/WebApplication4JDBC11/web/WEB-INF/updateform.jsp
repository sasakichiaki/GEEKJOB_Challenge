<%-- 
    Document   : updateform
    Created on : 2017/08/17, 22:34:18
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
        <form action="./NewServlet" method="post">
            <p>情報を変更する対象のIDを選択してください。<br>
                profileID:<input type="number" name="id">
            </p>
            <p>
                変更する名前:<input type="text" name="name" size="40" maxlength="20">
            </p>
            <p>
                変更する電話番号:<input type="text" name="tel01" size="7" maxlength="20">-<input type="text" name="tel02" size="7" maxlength="20">-<input type="text" name="tel03" size="7" maxlength="20">
            </p>
                        <p>
                変更する年齢:<input type="number" name="age">
            </p>
                                    <p>
                変更する誕生日:<input type="date" name="date">
            </p>
            <p>
                <input type="submit" value="送信"><input type="reset" value="リセット">
            </p>
        </form>
    </body>
</html>