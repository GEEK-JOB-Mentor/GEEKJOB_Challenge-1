/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nozaw
 */
@WebServlet(urlPatterns = {"/database8"})
public class database8 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection db_con=null;
        PreparedStatement db_st1=null;
        ResultSet db_data=null;
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");
        try{
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            db_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","nozaw","kmwv8710");
            
            String meirei1="select * from profiles where name like '%"+name+"%';" ;
            
            db_st1=db_con.prepareStatement(meirei1);
            
            db_data=db_st1.executeQuery();
            
            out.print("検索結果<br>");
            int count=0;
            while(db_data.next()){
                out.print("profilesID:"+db_data.getString("profilesID")+"&nbsp"+"name:"+db_data.getString("name")+"&nbsp"+"tel:"+db_data.getString("tel")+"&nbsp"+"age"+db_data.getString("age")+"&nbsp"+"birthday:"+db_data.getString("birthday")+"&nbsp"+"<br>");
                count++;
            }
            if(count==0){
                out.print("でーたがありません");
            }
            
            db_st1.close();
            db_data.close();
            db_con.close();
            
        }
        catch(SQLException e_sql){
                out.println("接続時にエラーが発生しました。:"+e_sql.toString());
                }
        catch(Exception e){
                out.println("エラーが発生しました。"+e.toString());
                }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    

}
