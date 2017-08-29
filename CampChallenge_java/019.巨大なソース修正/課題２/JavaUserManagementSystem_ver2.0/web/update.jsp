<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="java.util.ArrayList"%>
<%
    //内容は検索結果と同じ方法で取得
    HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>) session.getAttribute("resultData");
    Integer id = (Integer) session.getAttribute("id");
    //入力フォーム用のデータを受け取る
    Integer year = Integer.valueOf(String.format("%tY", udd.get(id).getBirthday()));
    Integer month = Integer.valueOf(String.format("%tm", udd.get(id).getBirthday()));
    Integer day = Integer.valueOf(String.format("%td", udd.get(id).getBirthday()));

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
    <form action="UpdateResult" method="POST">
        名前:
        <input type="text" name="name" value="<%= udd.get(id).getName()%>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value="<%= year %>">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" ><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="<%= month %>">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" ></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="<%= day %>">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>"><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=udd.get(id).getTell()%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=udd.get(id).getComment()%></textarea><br><br>
        <input type="hidden" name="userID"  value="<%= udd.get(id).getUserID()%>">
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
