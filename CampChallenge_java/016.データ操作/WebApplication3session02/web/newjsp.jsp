<%-- 
    Document   : newjsp
    Created on : 2017/08/07, 19:32:31
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
            

            HttpSession hs = request.getSession();

            // セッションへ登録
            hs.setAttribute("Data1",request.getParameter("txtName"));
            hs.setAttribute("Data2",request.getParameter("sex"));
            hs.setAttribute("Data3",request.getParameter("shumi"));

            // セッションから情報を取得 
            String lunch1 = (String) hs.getAttribute("Data1");
            String lunch2 = (String) hs.getAttribute("Data2");
            String lunch3 = (String) hs.getAttribute("Data3");
            
            if(lunch1 != null){
                out.print(lunch1);
                out.print(lunch2);
                out.print(lunch3);
            }
            

            %>
    </body>
</html>
