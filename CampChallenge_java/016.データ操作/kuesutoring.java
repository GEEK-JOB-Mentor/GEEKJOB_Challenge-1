/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author nozaw
 */
@WebServlet(urlPatterns = {"/kuesutoring"})
public class kuesutoring extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
           request.setCharacterEncoding("UTF-8");
           String value1=request.getParameter("total");
           String value2=request.getParameter("count");
           String value3=request.getParameter("type");
           int value11 = Integer.parseInt(value1);//総額を数値化
           int value22 = Integer.parseInt(value2);//個数を数値化
           int value33 = Integer.parseInt(value3);//種類を数値化
           if(value33==1){
               out.print("この商品は雑貨です。<br>");
           }
           else if(value33==2){
               out.print("この商品は生鮮食品です。<br>");
           }
           else if(value33==3){
               out.print("その他です。<br>");
           }
           out.print("1個当たりの値段は"+(value11/value22)+"です。<br>");
           
           if(value11>=3000&&value11<=4999){
               out.print((value11*0.04)+"ポイントつきます。<br>");
           }
           else if (value11>=5000){
               out.print((value11*0.05)+"ポイントつきます。<br>");
           }
           else{
              out.print("ポイントは付きません<br>");
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
