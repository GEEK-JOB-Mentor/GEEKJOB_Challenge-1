<%-- 
    Document   : for3
    Created on : 2017/08/18, 1:36:19
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
            int sum=0;
            for(int i=1;i<=100;i++){
                sum+=i;
            }
            out.print("1から100までの合計は"+sum);
        %>
    </body>
</html>
