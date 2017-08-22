<%-- 
    Document   : login_error
    Created on : 2017/08/22, 17:52:53
    Author     : sasakichiaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>
        <style type="text/css">
            <!--
            /* Fonts */
            @import url(https://fonts.googleapis.com/css?family=Open+Sans:400);

            /* fontawesome */
            @import url(http://weloveiconfonts.com/api/?family=fontawesome);
            [class*="fontawesome-"]:before {
                font-family: 'FontAwesome', sans-serif;
            }

            /* Simple Reset */
            * { margin: 0; padding: 0; box-sizing: border-box; }

            /* body */
            body {
                background: #e9e9e9;
                color: #5e5e5e;
                font: 400 87.5%/1.5em 'Open Sans', sans-serif;
            }

            /* Form Layout */
            .form-wrapper {
                background: #fafafa;
                margin: 3em auto;
                padding: 0 1em;
                max-width: 370px;
            }

            h1 {
                text-align: center;
                padding: 1em 0;
            }

            form {
                padding: 0 1.5em;
            }

            .form-item {
                margin-bottom: 0.75em;
                width: 100%;
            }

            .form-item input {
                background: #fafafa;
                border: none;
                border-bottom: 2px solid #e9e9e9;
                color: #666;
                font-family: 'Open Sans', sans-serif;
                font-size: 1em;
                height: 50px;
                transition: border-color 0.3s;
                width: 100%;
            }

            .form-item input:focus {
                border-bottom: 2px solid #c0c0c0;
                outline: none;
            }

            .button-panel {
                margin: 2em 0 0;
                width: 100%;
            }

            .button-panel .button {
                background: #f16272;
                border: none;
                color: #fff;
                cursor: pointer;
                height: 50px;
                font-family: 'Open Sans', sans-serif;
                font-size: 1.2em;
                letter-spacing: 0.05em;
                text-align: center;
                text-transform: uppercase;
                transition: background 0.3s ease-in-out;
                width: 100%;
            }

            .button:hover {
                background: #ee3e52;
            }

            .form-footer {
                font-size: 1em;
                padding: 2em 0;
                text-align: center;
            }

            .form-footer a {
                color: #8c8c8c;
                text-decoration: none;
                transition: border-color 0.3s;
            }

            .form-footer a:hover {
                border-bottom: 1px dotted #8c8c8c;
            }

            -->
        </style>
    </head>
    <body>
        <div class="form-wrapper">
            <h1>ログイン失敗</h1>
            <div class="form-footer">
                <p>ログインができませんでした</p>
                <p>もう一度ログインをし直してください</p>
                <br>
                <p><a href="#">新規会員登録はこちら</a></p>
                <p><a href="#">IDパスワードがわからない場合はこちら</a></p>
            </div>
        </div>
    </body>
</html>