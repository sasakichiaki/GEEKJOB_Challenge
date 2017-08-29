<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%  
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>) request.getAttribute("resultData");
    session.setAttribute("resultData",udd);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <!-- 繰り返し処理返し　-->
            <%
                //検索ヒットしたarrayの数繰り返す
            for(int i =0; i < udd.size(); i++) {
            %>   
            <tr>
                <!-- 取得方法をarrayから取得に変更-->
                <!-- リンク先ほは、idを飛ばして、idの情報を引き出す -->
                <td><a href="ResultDetail?id=<%= i%>&ac=<%= session.getAttribute("ac")%>"><%= udd.get(i).getName()%></a></td>
                <td><%= udd.get(i).getBirthday()%></td>
                <td><%= udd.get(i).getType()%></td>
                <td><%= udd.get(i).getNewDate()%></td>
            </tr>
            <%}%>
        </table>
    </body>
    <%=jh.home()%>
</html>
