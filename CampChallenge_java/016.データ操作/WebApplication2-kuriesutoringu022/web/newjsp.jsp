<%-- 
    Document   : newjsp
    Created on : 2017/08/04, 21:55:25
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
        <form action="newjsp.jsp" method="get">

            <p>自然数を入力してください</p>
            <p><input type="number" name="shizen"></p>
            <input type="submit" value="送信">
            <input type="reset" value="リセット">

        </form>

        <%

            if (request.getParameter("shizen") == null) {
                out.print("自然数を入力してください");
            } else {
                //ここから処理
                int n = Integer.parseInt(request.getParameter("shizen"));
                int a = 2;
                int aa = 0;
                
                out.println("  素の値=" + n);

                while (n != 1) {
                    if (n % a == 0) {
                        out.println("  素因数=" + a);
                        n /= a;
                    } else {
                        if (a == 7){
                           out.println( "  余った値=" + n);
break; 
                        }
                         a++;
                        
                    }
                }

            }

        %>


    </body>
</html>
