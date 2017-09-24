/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nozaw
 */
@WebServlet(urlPatterns = {"/database2"})
public class database2 extends HttpServlet {

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
        PreparedStatement db_st2=null;
        //ResultSet db_data=null;
        try {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //out.println("ここまではうまく作動1");
            db_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","nozaw","kmwv8710");
            //out.println("ここまではうまく作動2");
            String meirei1="INSERT INTO profiles(profilesID,name,tel,age,birthday) VALUES(5,'鈴木 実 ','080-5566-7788',24,'2000-12-24')";
            String meirei2="INSERT INTO profiles(profilesID,name,tel,age,birthday) VALUES(6,'高橋 ','090-9900-1234',24,'2000-12-24')";
            
            db_st1=db_con.prepareStatement(meirei1);
            db_st2=db_con.prepareStatement(meirei2);
            
            //out.println("ここまではうまく作動3");
            int number1=db_st1.executeUpdate();
            int number2=db_st2.executeUpdate();
            //out.println("ここまではうまく作動4");
            out.print("確認１:"+number1);
            out.print("確認２:"+number2);
            //out.println("ここまではうまく作動6");
            //db_data.close();
            db_st1.close();
            db_st2.close();
            db_con.close();
            //out.println("ここまではうまく作動7");
            
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
