<%-- 
    Document   : newjsp
    Created on : 2017/08/04, 18:39:38
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
        <form action="./newjsp.jsp" method="post">
            <p>名前</p>
            <p><input type="text" name="txtName"></p>
            <p>性別</p>
            <p><input type="radio" name="sex" value="women">女性</p>
            <p><input type="radio" name="sex" value="men">男性</p>
            <p>趣味</p>
            <textarea name="shumi" rows="10" cols="80">ここに趣味を記載してください。</textarea>
            <input type="submit" value="送信">
            <input type="reset" value="リセット">
        </form>
        
        <%
            // 受け取るパラメータの文字コード
            request.setCharacterEncoding("UTF-8");
//            request.getParameter("txtName");
//            request.getParameter("sex");
//            request.getParameter("shumi");
            

            out.print(request.getParameter("txtName"));
            out.print(request.getParameter("sex"));
            out.print(request.getParameter("shumi"));

            %>
        
    </body>
</html>
