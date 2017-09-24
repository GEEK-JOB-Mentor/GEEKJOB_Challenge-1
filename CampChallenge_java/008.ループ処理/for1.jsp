<%-- 
    Document   : for1
    Created on : 2017/08/18, 0:55:20
    Author     : nozaw
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
        long eightsum=1;
        for(int i=0;i < 20;i++){
            eightsum*=8;
            out.print("今の数値は"+eightsum+"であり"+i+"番目の処理です。"+"<br>");
        }
        out.print("8の20乗は"+eightsum);
        
        
        
        %>
    </body>
</html>
