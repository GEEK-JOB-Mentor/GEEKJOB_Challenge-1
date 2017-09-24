<%-- 
    Document   : database11
    Created on : 2017/09/04, 0:37:56
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
        <form action="database11" method="post">
            更新したい人のprofilesID<input type="text" name="changeid"><br>
            name:<input type="text" name="name"><br>
            tel:<input type="text" name="tel"><br>
            age:<input type="text" name="age"><br>
            birthday:<input type="text" name="birthday"><br>
           
            <input type="submit" value="更新！">
        </form>
    </body>
</html>
