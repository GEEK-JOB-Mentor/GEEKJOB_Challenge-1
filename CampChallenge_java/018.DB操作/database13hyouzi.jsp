<%-- 
    Document   : database13hyouzi
    Created on : 2017/09/13, 0:00:59
    Author     : nozaw
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    String form=request.getParameter("form");
    
    Connection db_con=null;
    PreparedStatement db_st=null;
    ResultSet db_data=null;
    String str=null;
    
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--登録したらすぐに登録に成功しました。を表示。そのあと戻るボタンを作る。
        ログイン先ファイルで商品一覧をクリックされたらここで表示して、戻るボタンを作る。--%>
        <% if(form.equals("touroku")) {  %>
            
            <%
                try{
                /* TODO output your page here. You may use following sample code. */
//                request.setCharacterEncoding("UTF-8");
                
                String number=request.getParameter("number");
                int number1=Integer.parseInt(number);
                String name=request.getParameter("shouhinname");
                String value=request.getParameter("value");
                int value1=Integer.parseInt(value);
                String memo=request.getParameter("memo");
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zaikokanri_db","nozaw","kmwv8710");
                db_st=db_con.prepareStatement("insert into shouhintable (shohinnumber,shohinname,shohinvalue,memo) values(?,?,?,?)");
                db_st.setInt(1,number1);
                db_st.setString(2,name);
                db_st.setInt(3,value1);
                db_st.setString(4,memo);

                int datanumber=db_st.executeUpdate();
                if(datanumber!=-1){
                    str="追加に成功しました。";
                }
                else{
                    str="追加に失敗しました。";
                }
                db_st.close();
                db_con.close();
                
                
                //いろいろとテーブルをいじったからprofilesIDが順番どおりではない。
    //            out.print("追加後のテーブル<br>");
    //            while(db_data.next()){
    //                out.print("profilesID:"+db_data.getString("profilesID")+"&nbsp"+"name:"+db_data.getString("name")+"&nbsp"+"tel:"+db_data.getString("tel")+"&nbsp"+"age"+db_data.getString("age")+"&nbsp"+"birthday:"+db_data.getString("birthday")+"&nbsp"+"<br>");
    //            }

            }
            catch(SQLException e_sql){
                  str="接続時にエラーが発生しました。:"+e_sql.toString();
                    }
            catch(Exception e){
                  str="エラーが発生しました。"+e.toString();
                    }
            %>
            <h3><%= str %></h3>         
            <a href="./database13roginsaki.jsp?pass=<%=request.getParameter("pass")%>&name=<%=request.getParameter("name")%>">戻る</a>
        <% } %>
         
        
        
            
        
        
        
        
        <%if(form.equals("itiran")) { %>
            <%
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zaikokanri_db","nozaw","kmwv8710");
                db_st=db_con.prepareStatement("select * from shouhintable");

                db_data=db_st.executeQuery();
                 while(db_data.next()){ %>
                    <p>番号:<%= db_data.getInt("shohinnumber") %>&nbsp 商品名:<%= db_data.getString("shohinname") %>&nbsp 価格:<%= db_data.getString("shohinvalue") %>&nbsp メモ:<%= db_data.getString("memo") %></p><br>
            <% } %>
           
    
            <a href="database13roginsaki.jsp?pass=<%=request.getParameter("pass")%>&name=<%=request.getParameter("name")%>">戻る</a>
        <% } %>
    </body>
</html>
