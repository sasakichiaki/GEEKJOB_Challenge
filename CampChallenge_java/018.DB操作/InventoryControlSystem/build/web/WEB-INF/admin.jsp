<%-- 
    Document   : admin
    Created on : 2017/08/22, 17:50:45
    Author     : sasakichiaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>佐々木千明 | 在庫管理</title>
        <!-- Material Design Lite -->
        <script src="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.min.js"></script>
        <link rel="stylesheet" href="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.yellow-deep_purple.min.css" />
        <!-- Material Design icon font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <style type="text/css">
            <!--

            h1
            {
                font-size: 30px;
            }

            h2{
                font-size: 25px;
                text-decoration: underline;
            }
            h3{
                font-size: 20px;
            }

            table, td, th {
                border: 2px #808080 solid;
            }

            /*headerのCSSデザイン（上書き）*/
            .mdl-layout__header {
                background-color: rgb(255,235,59);
            }
            /*メニューのCSS*/
            .mdl-layout__drawer>.mdl-layout-title {
                line-height: 56px;
                padding-left: 40px;
            }
            /*カードのCSS*/
            .card {
                margin: 30px auto;
                width: 350px;
                background: #fff;
                border-radius: 5px;
                box-shadow: 0 2px 5px #ccc;
            }
            .card-img {
                border-radius: 5px 5px 0 0;
                max-width: 100%;
                height: auto;
            }
            .card-content {
                padding: 20px;
            }
            .card-title {
                font-size: 20px;
                margin-bottom: 20px;
                text-align: center;
                color: #333;
            }
            .card-text {
                color: #777;
                font-size: 14px;
                line-height: 1.5;
            }
            .card-link {
                text-align: center;
                border-top: 1px solid #eee;
                padding: 20px;
            }
            .card-link a {
                text-decoration: none;
                color: #0bd;
                margin: 0 10px;
            }
            .card-link a:hover {
                color: #0090aa;
            }

            /*ここからテンプレート*/
            html, body {
                font-family: 'Roboto', 'Helvetica', sans-serif;
            }
            .demo-avatar {
                width: 48px;
                height: 48px;
                border-radius: 24px;
            }
            .demo-layout .mdl-layout__header .mdl-layout__drawer-button {
                color: rgba(0, 0, 0, 0.54);
            }
            .mdl-layout__drawer .avatar {
                margin-bottom: 16px;
            }
            .demo-drawer {
                border: none;
            }
            /* iOS Safari specific workaround */
            .demo-drawer .mdl-menu__container {
                z-index: -1;
            }
            .demo-drawer .demo-navigation {
                z-index: -2;
            }
            /* END iOS Safari specific workaround */
            .demo-drawer .mdl-menu .mdl-menu__item {
                display: -webkit-flex;
                display: -ms-flexbox;
                display: flex;
                -webkit-align-items: center;
                -ms-flex-align: center;
                align-items: center;
            }
            .demo-drawer-header {
                box-sizing: border-box;
                display: -webkit-flex;
                display: -ms-flexbox;
                display: flex;
                -webkit-flex-direction: column;
                -ms-flex-direction: column;
                flex-direction: column;
                -webkit-justify-content: flex-end;
                -ms-flex-pack: end;
                justify-content: flex-end;
                padding: 16px;
                height: 151px;
            }
            .demo-avatar-dropdown {
                display: -webkit-flex;
                display: -ms-flexbox;
                display: flex;
                position: relative;
                -webkit-flex-direction: row;
                -ms-flex-direction: row;
                flex-direction: row;
                -webkit-align-items: center;
                -ms-flex-align: center;
                align-items: center;
                width: 100%;
            }

            .demo-navigation {
                -webkit-flex-grow: 1;
                -ms-flex-positive: 1;
                flex-grow: 1;
            }
            .demo-layout .demo-navigation .mdl-navigation__link {
                display: -webkit-flex !important;
                display: -ms-flexbox !important;
                display: flex !important;
                -webkit-flex-direction: row;
                -ms-flex-direction: row;
                flex-direction: row;
                -webkit-align-items: center;
                -ms-flex-align: center;
                align-items: center;
                color: rgba(255, 255, 255, 0.56);
                font-weight: 500;
            }
            .demo-layout .demo-navigation .mdl-navigation__link:hover {
                background-color: #00BCD4;
                color: #37474F;
            }
            .demo-navigation .mdl-navigation__link .material-icons {
                font-size: 24px;
                color: rgba(255, 255, 255, 0.56);
                margin-right: 32px;
            }

            .demo-content {
                max-width: 1080px;
            }

            .demo-charts {
                -webkit-align-items: center;
                -ms-flex-align: center;
                align-items: center;
            }
            .demo-chart:nth-child(1) {
                color: #ACEC00;
            }
            .demo-chart:nth-child(2) {
                color: #00BBD6;
            }
            .demo-chart:nth-child(3) {
                color: #BA65C9;
            }
            .demo-chart:nth-child(4) {
                color: #EF3C79;
            }
            .demo-graphs {
                padding: 16px 32px;
                display: -webkit-flex;
                display: -ms-flexbox;
                display: flex;
                -webkit-flex-direction: column;
                -ms-flex-direction: column;
                flex-direction: column;
                -webkit-align-items: stretch;
                -ms-flex-align: stretch;
                align-items: stretch;
            }
            /* TODO: Find a proper solution to have the graphs
             * not float around outside their container in IE10/11.
             * Using a browserhacks.com solution for now.
             */
            _:-ms-input-placeholder, :root .demo-graphs {
                min-height: 664px;
            }
            _:-ms-input-placeholder, :root .demo-graph {
                max-height: 300px;
            }
            /* TODO end */
            .demo-graph:nth-child(1) {
                color: #00b9d8;
            }
            .demo-graph:nth-child(2) {
                color: #d9006e;
            }

            .demo-cards {
                -webkit-align-items: flex-start;
                -ms-flex-align: start;
                align-items: flex-start;
                -webkit-align-content: flex-start;
                -ms-flex-line-pack: start;
                align-content: flex-start;
            }
            .demo-cards .demo-separator {
                height: 32px;
            }
            .demo-cards .mdl-card__title.mdl-card__title {
                color: white;
                font-size: 24px;
                font-weight: 400;
            }
            .demo-cards ul {
                padding: 0;
            }
            .demo-cards h3 {
                font-size: 1em;
            }
            .demo-updates .mdl-card__title {
                min-height: 200px;
                background-image: url('images/dog.png');
                background-position: 90% 100%;
                background-repeat: no-repeat;
            }
            .demo-cards .mdl-card__actions a {
                color: #00BCD4;
                text-decoration: none;
            }

            .demo-options h3 {
                margin: 0;
            }
            .demo-options .mdl-checkbox__box-outline {
                border-color: rgba(255, 255, 255, 0.89);
            }
            .demo-options ul {
                margin: 0;
                list-style-type: none;
            }
            .demo-options li {
                margin: 4px 0;
            }
            .demo-options .material-icons {
                color: rgba(255, 255, 255, 0.89);
            }
            .demo-options .mdl-card__actions {
                height: 64px;
                display: -webkit-flex;
                display: -ms-flexbox;
                display: flex;
                box-sizing: border-box;
                -webkit-align-items: center;
                -ms-flex-align: center;
                align-items: center;
            }
            /*ここまでテンプレート*/
            /*PCサイトのスタイルシート*/
            body {
                background-color: #CCC;
            }

            .page-content {
                font-family: 'Montserrat',sans-serif;
                color: #58666e;
                font-size: 13px;
                font-weight: bold;
                text-transform: uppercase;
                padding: 16px 20px;
                margin: 5%;
                background: #fff;
                margin-bottom: 5px;
                border-bottom: none;
                border-radius: 3px;
            }

            .page-content-body {
                padding: 0;
                color: inherit;
                background-color: transparent;
            }

            -->
        </style>
    </head>

    <body>
        <div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
            <!-- ヘッダー要素ー-->
            <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
                <div class="mdl-layout__header-row">
                    <!-- ページタイトルー-->
                    <div class="mdl-layout-spacer"></div>
                    <!-- 検索メニューー-->
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                        <label class="mdl-button mdl-js-button mdl-button--icon" for="search"><i class="material-icons">search</i></label>
                        <div class="mdl-textfield__expandable-holder">
                            <input class="mdl-textfield__input" type="text" id="search">
                            <label class="mdl-textfield__label" for="search">Enter your query...</label>
                        </div>
                    </div>
                    <!-- 右側メニュー-->
                    <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn"><i class="fa fa-sign-out" aria-hidden="true"></i></button>
                    <ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
                        <a href="LogIn?action=logout"><li class="mdl-menu__item">ログアウト</li><a>

                    </ul>
                </div>
            </header>
            <!-- ユーザーメニュー-->
            <div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
                <header class="demo-drawer-header">
                    <div class="demo-avatar-dropdown">
                        <span>ログインユーザー名</span>
                        <div class="mdl-layout-spacer"></div>
                        <button id="accbtn" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon"><i class="material-icons" role="presentation">arrow_drop_down</i><span class="visuallyhidden">Accounts</span></button>
                        <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect" for="accbtn">
                            <li class="mdl-menu__item">プロフィール</li>
                            <li class="mdl-menu__item">お問い合わせ</li>
                        </ul>
                    </div>
                </header>
                <!-- サイドメニュー-->
                <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
                    <a class="mdl-navigation__link" href="UserAdd?action=click"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation"><i class="fa fa-home" aria-hidden="true"></i></i>Home</a>
                    <a class="mdl-navigation__link" href="UserAdd?action=click"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation"><i class="fa fa-id-card-o" aria-hidden="true"></i></i>ユーザー登録</a>
                    <a class="mdl-navigation__link" href="Goodsup?action=click"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation"><i class="fa fa-th-list" aria-hidden="true"></i></i>商品一覧</a>
                    <a class="mdl-navigation__link" href="Goods?action=click"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation"><i class="fa fa-plus-square-o" aria-hidden="true"></i></i>商品登録登録</a>

                    <!-- アイコンつきメニューのテンプレート
            このサイトからグーグル公式のアイコンが検索できる：https://material.io/icons/
            <a class="mdl-navigation__link" href=""><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">アイコン名</i>てきすと</a>
            <div class="mdl-layout-spacer"></div>
            <a class="mdl-navigation__link" href=""><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">help_outline</i><span class="visuallyhidden">Help</span></a>
                    -->
                </nav>
            </div>
            <main class="mdl-layout__content">
                <div class="page-content">
                    <div class="page-content-title">
                        <h3>登録ユーザー一覧</h3>
                    </div>
                    <!-- .page-content-title -->
                    <div class="page-content-body">
            <form action="UserAdd" method="post">
            <p class=userForm>status:<select name="status">
                    <option value="admin">admin</option>
                    <option value="vender">vender</option>
                </select>
            <p class=userForm>name:<input type="text" name="name" size="20" maxlength="20"></p>
            <p class=userForm>loginID:<input type="text" name="loginID" size="20" maxlength="20"></p>
            <p class=userForm>passWord:<input type="text" name="passWord" size="20" maxlength="20"></p>
            <p class=userForm>メールアドレス：<input type="email" name="email" size="30" maxlength="40"></p>
            <input type="submit" value="　登録　"><input type="reset" value="リセット">
            </p>
          </form>
                        
                    </div>
                    <!-- .page-content-body -->
                </div>
            </main>
        </div>
    </body>

</html>
