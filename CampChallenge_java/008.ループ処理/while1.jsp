<%-- 
    Document   : while1
    Created on : 2017/08/18, 1:45:34
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
            int number=1000;
            while(number>=100){
                number/=2;
            }
            out.print("今のnumberの値は"+number);
        %>
    </body>
</html>
