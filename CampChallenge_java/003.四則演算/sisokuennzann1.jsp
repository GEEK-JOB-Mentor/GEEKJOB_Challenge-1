<%-- 
    Document   : sisokuennzann1
    Created on : 2017/08/17, 22:34:46
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
     <%!                   
     final int number =10;
     int number1=2;
     %>
     加算の結果:<%= number+number1 %>
     減算の結果:<%= number-number1 %>
     乗算の結果:<%= number*number1 %>
     除算の結果:<%= number/number1 %>
    </body>
</html>
