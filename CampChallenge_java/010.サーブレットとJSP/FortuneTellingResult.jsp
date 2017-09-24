<%-- 
    Document   : FortuneTellingResult
    Created on : 2017/08/05, 15:29:00
    Author     : nozaw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            org.camp.servlet.ResultData data = (org.camp.servlet.ResultData)request.getAttribute("DATA");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(data != null){
                out.print("<h1>あなたの"+"今日の"+"運勢は,"+data.getLuck()+"です！</h1>");
                
            }
        %>
    </body>
</html>
