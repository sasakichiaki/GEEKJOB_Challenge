<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>) session.getAttribute("resultData");
    Integer i = (Integer) request.getAttribute("id");
    session.setAttribute("id", i);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <h1>詳細情報</h1>
        名前:<%= udd.get(i).getName()%><br>
        生年月日:<%= udd.get(i).getBirthday()%><br>
        種別:<%= udd.get(i).getType()%><br>
        電話番号:<%= udd.get(i).getTell()%><br>
        自己紹介:<%= udd.get(i).getComment()%><br>
        登録日時:<%= udd.get(i).getNewDate()%><br>
        <form action="Update" method="POST">
        <input type="submit" name="update" value="変更"style="width:100px">
        </form>
        <form action="Delete" method="POST">
        <input type="submit" name="delete" value="削除"style="width:100px">
        </form>
    </body>
</html>
