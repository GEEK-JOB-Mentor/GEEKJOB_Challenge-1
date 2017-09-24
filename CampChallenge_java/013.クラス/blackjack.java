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
@WebServlet(urlPatterns = {"/blackjack"})
public class blackjack extends HttpServlet {

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
        Dealer dealer=new Dealer();
        User user=new User();
        System.out.print("山札がうまく配置できているか確認。<br>");
        for(int k=0;k<dealer.cards.size();k++){
            out.print("配列["+k+"]"+dealer.cards.get(k)+"<br>");
        }
        //ここで二枚のトランプをmycardsにいれる。
        dealer.setCard(dealer.deal());
        user.setCard(dealer.deal());
       
        out.print("dealerの最初の手持ちのカードは"+dealer.myCards.get(0)+"、"+dealer.myCards.get(1)+"です。<br>");
        out.print("userの最初の手持ちのカードは"+user.myCards.get(0)+"、"+user.myCards.get(1)+"です。<br>");
        out.print("<br><br><br>");
        
        out.print(dealer.cards);
        out.print("<br><br><br>");
        
        out.print("二枚ずつ配り終えた後の山札は<br>");
        for(int z=0;z<dealer.cards.size();z++){
            out.print("配列["+z+"]"+dealer.cards.get(z)+"<br>");
        }
       //ここからはdealer、userを分けて処理をしていく
       //hitについての処理。checksumによってhitができなくなったらhitをやめる。
        while(dealer.checkSum()){
            
            dealer.setCard(dealer.hit(true));
           
        }
        out.print("dealerのhit後の手持ちのカードは");
        for(int i=0;i<dealer.myCards.size();i++){
            out.print(dealer.myCards.get(i)+",");
            
        }
        out.print("です。<br>");
        
        
        while(user.checkSum()){
            user.setCard(dealer.hit(true));
        }
        out.print("userのhit後の手持ちのカードは");
        for(int j=0;j<user.myCards.size();j++){
            out.print(user.myCards.get(j)+"、");
        }
        out.print("です。<br>");
        
        int usersa=21-user.open();
        int dealersa=21-dealer.open();
        if((user.open()>21&&dealer.open()>21)||(user.open()==21&&dealer.open()==21)||(usersa==dealersa&&!(user.open()<21||dealer.open()<21))){
            out.print("引き分けです。<br>");
        }
        else if(user.open()<=21&&dealer.open()>21){
            out.print("手札の合計が"+user.open()+"でuserの勝ちです。<br>");
            out.print("手札の合計が"+dealer.open()+"でdealerの負けです。<br>");
        }
        else if(dealer.open()<=21&&user.open()>21){
        
            out.print("手札の合計が"+dealer.open()+"でdealerの勝ちです。<br>");
            out.print("手札の合計が"+user.open()+"でuserの負けです。<br>");
        }
        //else if(  21 - user.open() < 21 - dealer.open())でエラー なんで
        
        else if(usersa<dealersa){
            out.print("手札の合計が"+user.open()+"でuserの勝ちです。<br>");
            out.print("手札の合計が"+dealer.open()+"でdealerの負けです。<br>");
        }
        else if(dealersa<usersa){
            out.print("手札の合計が"+dealer.open()+"でdealerの勝ちです。<br>");
            out.print("手札の合計が"+user.open()+"でuserの負けです。<br>");
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
