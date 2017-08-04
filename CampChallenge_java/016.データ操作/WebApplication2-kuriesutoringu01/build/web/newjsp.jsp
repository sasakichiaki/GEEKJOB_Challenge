<%-- 

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="newjsp.jsp" method="get">
            <p>総額</p>
            <p><input type="number" name="total">円</p>
            <p>個数</p>
            <p><input type="number" name="count">個</p>

            <p><input type="radio" name="type" value="1">雑貨</p>

            <p><input type="radio" name="type" value="2">生鮮食品</p>

            <p><input type="radio" name="type" value="3">その他</p>
            <input type="submit" value="送信">
            <input type="reset" value="リセット">


            <%

                if (request.getParameter("total") == null) {

                } else {

                    int a = Integer.parseInt(request.getParameter("total"));
                    int b = Integer.parseInt(request.getParameter("count"));

                    out.print("<br>１個当たりの値段:"+ a / b+ "円<br>");

                    if (a >= 5000) {
                        out.print("5%");
                    } else if (a >= 3000) {
                        out.print("4%");
                    }

                }

                request.setCharacterEncoding("UTF-8");
                request.getParameter("total");
                request.getParameter("count");
                request.getParameter("type");

            %>
            </body>
            </html>
