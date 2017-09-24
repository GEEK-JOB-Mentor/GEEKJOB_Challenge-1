<%-- 
    Document   : database13roginsaki
    Created on : 2017/09/12, 23:14:48
    Author     : nozaw
--%>
<%@ page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    String name= request.getParameter("name");
    String pass=request.getParameter("pass");
    int passnum=Integer.parseInt(pass);
    Connection db_con=null;
    PreparedStatement db_st=null;
    ResultSet db_data=null;
    String loginhantei=null;
     try{
         
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         db_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zaikokanri_db" ,"nozaw","kmwv8710");
         db_st=db_con.prepareStatement("select * from usertable where name = ? && password = ? ");
         db_st.setString(1,name);
         db_st.setInt(2,passnum);
         db_data=db_st.executeQuery();        
         if(db_data.next()){
             loginhantei="ok";
         }
         else {
             loginhantei="dame";
         }
         db_data.close();
         db_st.close();
         db_con.close();
     }
     catch(SQLException e_sql){
                out.println("接続時にエラーが発生しました。:"+e_sql.toString());
     }
     catch(Exception e){
                out.println("エラーが発生しました。"+e.toString());
     }
%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
       
       <%if(loginhantei.equals("ok")){%>
            <p>ログイン成功</p>
            <h1>在庫管理システム</h1>
            <h2>商品登録</h2>
            <form action="database13hyouzi.jsp?form=touroku" method="post">
                商品ナンバー<input type="text" name="number"><br>
                商品名<input type="text" name="shouhinname"><br>
                価格<input type="text" name="value"><br>
                メモ<input type="text" name="memo"><br>
                <input type="hidden" name="pass" value=<%=pass%> >
                <input type="hidden" name="name" value=<%=name%> >
                <input type="submit" value="追加">
            </form><br>
            
            <h2><a href="database13hyouzi.jsp?form=itiran">商品一覧を表示する。</a></h2>
            <a href="database13.jsp">ログアウト</a>
            
        
        
        <%} if(loginhantei.equals("dame")){%>       
            <p>ログインに失敗</p>
            <a href="database13.jsp">戻る</a>
        <%}%>
    

