<%-- 
    Document   : newjsp
    Created on : 2017/06/29, 16:14:41
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
        <% 
        char text = 'あ';
        switch(text) {
            case 'a':
            out.print("英語");
            break;
            case 'あ':
            out.print("日本語");
            break;
            default:
            out.print("それ以外の場合は表示");
            break;
        }
            %>
    </body>
</html>
