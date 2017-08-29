<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>) session.getAttribute("resultData");
   
    Integer id = (Integer) session.getAttribute("id");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>変更結果</h1><br>
        名前:<%= udd.get(id).getName()%><br>
        生年月日:<%= udd.get(id).getBirthday()%><br>
        種別:<%= jh.exTypenum(udd.get(id).getType())%><br>
        電話番号:<%= udd.get(id).getTell()%><br>
        自己紹介:<%= udd.get(id).getComment()%><br>
        以上の内容で登録しました。<br>
    </body>
    <%=jh.home()%>
    </body>
</html>
