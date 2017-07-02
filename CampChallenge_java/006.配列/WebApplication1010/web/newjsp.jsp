<%-- 
    Document   : newjsp
    Created on : 2017/06/30, 11:36:14
    Author     : sasakichiaki
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%@ page import="java.util.ArrayList" %>
<%
// ArrayListの操作
ArrayList<String> data = new ArrayList<String>();
// 要素の追加"10", "100", "soeda", "hayashi", "-20", "118", "END"
data.add("<br>10");//0
data.add("100");//1
data.add("soeda");//2
data.add("hayashi");//3
data.add("-20");//4
data.add("118");//5
data.add("END");//6
data.add("あっd");//7

for(int i=0; i<data.size();i++){
  out.print(data.get(i));  
}

// 作成した配列の"soeda"を"33"に変更してください。
data.set(3, "33");
for(int i=0; i<data.size();i++){
  out.print(data.get(i));  
}
%>

    </body>
</html>
