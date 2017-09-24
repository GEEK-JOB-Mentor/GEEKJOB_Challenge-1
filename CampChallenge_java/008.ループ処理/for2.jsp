<%-- 
    Document   : for2.jsp
    Created on : 2017/08/18, 1:28:39
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
            String astock="";
            for(int i=1;i<=30;i++){
                astock+="A";
                
            }
            out.print("Aが30個ある文字列<br>"+astock);





        %>
    </body>
</html>
