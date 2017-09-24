<%-- 
    Document   : database12
    Created on : 2017/09/05, 9:13:10
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
        <h1>データ検索画面</h1>
        <form action="database12" method="post">
            
            名前:<input type="text" name="name"><br>
            年齢:<input type="text" name="age"><br>
            誕生日:<input type="text" name="birthday"><br>
           
            <input type="submit" value="検索！">
        </form>
    </body>
</html>
