<%-- 
    Document   : login
    Created on : 2017/08/21, 22:06:53
    Author     : sasakichiaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>ログイン画面</title>
        <link rel="stylesheet" type="text/css"href="css/login.css"/>
    </head>
    <body>
        <div class="form-wrapper">
            <h1>ログイン</h1>
            <form action="LogIn" method="post">
                <div class="form-item">
                    <label for="text"></label>
                    <input type="text" name="loginid" required="required" placeholder="IDを入力してください"></input>
                </div>
                <div class="form-item">
                    <label for="password"></label>
                    <input type="password" name="password" required="required" placeholder="パスワードを入力してください"></input>
                </div>
                <div class="button-panel">
                    <input type="submit" class="button" value="ログイン"></input>
                </div>
            </form>
            <div class="form-footer">
                <p><a href="#">新規会員登録はこちら</a></p>
                <p><a href="#">IDパスワードがわからない場合はこちら</a></p>
            </div>
        </div>
    </body>
</html>
