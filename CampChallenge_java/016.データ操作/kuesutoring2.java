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

import java.util.*;



/**
 *
 * @author nozaw
 */
@WebServlet(urlPatterns = {"/kuesutoring2"})
public class kuesutoring2 extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           response.setContentType("text/html;charset=UTF-8");
        
            request.setCharacterEncoding("UTF-8");
            String value=request.getParameter("number");
            int number = Integer.parseInt(value);
            int i=2;
            int numbercopy=number;
            int sum=1;
            ArrayList<Integer> soinnsuu1=new ArrayList<Integer>();
            
            


            while(number!=1){
                if(number%i==0||number%i==1){
                    
                    soinnsuu1.add(i);
                    number/=i;
                    
                 
                }
                
                
                else{

                    i++;
                }
            }
            
            for(int j=0;j<soinnsuu1.size();j++){
                sum=sum*soinnsuu1.get(j);
                out.print("途中の合計"+sum+"&nbsp");
            }
            out.print("最終的な合計の値"+sum+"&nbsp");
            if(sum==numbercopy){
                out.print("元の値は"+numbercopy+"であり、素因数分解をした結果は");
                for(int k=0;k<soinnsuu1.size();k++){
                    out.print(soinnsuu1.get(k)+"&nbsp");
                }
                out.print("です。");
            }
            else{
                out.print("元の値は"+numbercopy+"であり、素因数分解をした結果は");
                for(int k=0;k<soinnsuu1.size();k++){
                    out.print(soinnsuu1.get(k)+"&nbsp");
                }
                out.print("です。余った値は"+(numbercopy-sum)+"です。");
                
            }
            
            
            
           
        
        
            
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
