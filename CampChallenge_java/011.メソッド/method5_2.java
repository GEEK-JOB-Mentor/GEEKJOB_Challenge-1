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
@WebServlet(urlPatterns = {"/method5_2"})
public class method5_2 extends HttpServlet {

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
        
        
        String[] numberarray={"1","2","3"};
        
        
            for(int i=0;i<3;i++){
                String[] info=new String[4];
                info=infomation(numberarray[i]);
                if(info[0].equals("false")){
                    break;
                }
                for(int j=1;j<4;j++){
                    if(info[j]==null){
                        continue;
                    }
                    out.print(info[j]);
                }
                out.print("<br>");    
            }
             
        
        
    }
     String[] infomation(String number){
        String[] info1={"1","野澤","1996年6月3日",""};
        String[] info2={"2","佐藤","1990年5月2日","神奈川"};
        String[] info3={"3","高橋","1980年10月23日","千葉"};
        String[] noinfo={"false"};
        if(info1[0].equals(number)){
             return info1;
        }
        if(info2[0].equals(number)){
            return info2;
        }
        if(info3[0].equals(number)){
            return info3;
        }
        else{
            return noinfo;
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
