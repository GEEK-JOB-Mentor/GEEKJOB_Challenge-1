<%-- 
    Document   : nyuuryokunaiyou1
    Created on : 2017/08/19, 14:22:47
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
        <form action="nyuuryokunaiyou1.jsp" method="GET">
            名前<input type="text" name="name"><br>
            性別　男<input type="radio" name="seibetu" value="男" > 　女<input type="radio" name="seibetu" value="女" ><br>
            趣味<textarea name="syumi"></textarea>
            <input type="submit"><br>
        </form>
        <%
            
            request.setCharacterEncoding("UTF-8");
            String name=request.getParameter("name");
            String sei=request.getParameter("seibetu");
            String syumi=request.getParameter("syumi");
            if(name!=null)
            out.print("名前は"+name+"です<br>"+"性別は"+sei+"です<br>"+"趣味は"+syumi+"です<br>");
            
            
        %>
        
            
    </body>
</html>
