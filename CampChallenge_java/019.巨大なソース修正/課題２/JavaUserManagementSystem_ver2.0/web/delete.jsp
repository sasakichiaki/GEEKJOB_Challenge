<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="java.util.ArrayList"%>
<%
    //内容は検索結果と同じ方法で取得
    HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>) session.getAttribute("resultData");
    Integer id = (Integer) session.getAttribute("id");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>削除確認</h1>
    以下の内容を削除します。よろしいですか？
    名前:<%= udd.get(id).getName()%><br>
    生年月日:<%= udd.get(id).getBirthday()%><br>
    種別:<%= jh.exTypenum(udd.get(id).getType())%><br>
    電話番号:<%= udd.get(id).getTell()%><br>
    自己紹介:<%= udd.get(id).getComment()%><br>
    登録日時:<%= udd.get(id).getNewDate()%><br>
    
    <form action="DeleteResult" method="POST">
                    <input type="hidden" name="userID"  value="<%= udd.get(id).getUserID()%>">
                    <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
      <input type="submit" name="YES" value="はい"style="width:100px">
    </form><br>
    <form action="ResultDetail" method="POST">
      <input type="submit" name="NO" value="詳細画面に戻る"style="width:100px">
    </form>
    </body>
</html>
