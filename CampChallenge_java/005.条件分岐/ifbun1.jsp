<%-- 
    Document   : ifbun1
    Created on : 2017/08/17, 22:53:17
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
            int number=1;
            if(number==1){
                out.print("1です！");
            }
            else if(number==2){
                out.print("プログラミングキャンプ!");
            }
            else{
                out.print("その他です！");
            }




        %>
    </body>
</html>
