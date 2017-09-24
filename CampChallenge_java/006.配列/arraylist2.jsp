<%-- 
    Document   : arraylist2
    Created on : 2017/08/18, 0:33:18
    Author     : nozaw
--%>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<String> list= new ArrayList<String>();
            list.add("10");
            list.add("100");
            list.add("soeda");
            list.add("hayashi");
            list.add("-20");
            list.add("118");
            list.add("END");
            list.set(2,"33");
            for(int i=0;i<list.size();i++){
                out.print(list.get(i)+"&nbsp");
            }
        %>
    </body>
</html>
