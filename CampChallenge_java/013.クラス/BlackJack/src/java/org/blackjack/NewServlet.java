/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blackjack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.blackjack.NewServlet;
import org.blackjack.Dealer;
import org.blackjack.Human;
import org.blackjack.User;
import java.util.ArrayList;

/**
 *
 * @author sasakichiaki
 */
public class NewServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            Dealer dealer = new Dealer();

            ArrayList<Integer> ikkaimeDealer = dealer.deal();

            out.println("<p>現在のディーラの手札</p>");
            dealer.setCard(ikkaimeDealer);
            out.println(ikkaimeDealer.get(0));
            out.println(ikkaimeDealer.get(1));

            out.println("<p>現在の合計</p>");
            int goukeiDealer = dealer.open();
            out.println(goukeiDealer);

            out.println("<p>施工中ー引きますか？</p>");
            boolean ikkaimeDealerCheck = dealer.checkSum();
//            out.println(dealer.checkSum());

            if (ikkaimeDealerCheck == true) {
                ArrayList<Integer> nikaimeDealer = dealer.hit();
                out.println("<p>もう一枚引きます</p>");
                dealer.setCard(nikaimeDealer);
                out.println(nikaimeDealer.get(0));
                out.println("<p>終了します。</p>");
                out.println("<p>今回の結果</p>");
                goukeiDealer = goukeiDealer + nikaimeDealer.get(0);
                out.println(goukeiDealer);
            } else {
                out.println("<p>終了します。</p>");
                out.println("<p>今回の結果</p>");
                out.println(goukeiDealer);
            }

            out.println("<p>現在のユーザーの手札</p>");
            User user = new User();

            ArrayList<Integer> ikkaimeUser = dealer.deal();
            user.setCard(ikkaimeUser);
            out.println(ikkaimeUser.get(0));
            out.println(ikkaimeUser.get(1));

            out.println("<p>現在の合計</p>");
            int goukeiUser = user.open();
            out.println(goukeiUser);

            out.println("<p>施工中ー引きますか？</p>");
            boolean ikkaimeUserCheck = user.checkSum();
            out.println(user.checkSum());

            if (ikkaimeUserCheck == true) {
                ArrayList<Integer> nikaimeUser = dealer.hit();
                out.println("<p>もう一枚引きます</p>");
                user.setCard(nikaimeUser);
                out.println(nikaimeUser.get(0));
                out.println("<p>終了します。</p>");
                out.println("<p>今回の結果</p>");
                goukeiUser = goukeiUser + nikaimeUser.get(0);
                out.println(goukeiUser);
            } else {
                out.println("<p>終了します。</p>");
                out.println("<p>今回の結果</p>");
                out.println(goukeiUser);
            }
            
            out.println("<p>今回の勝負の結果は</p>");
            
            if(goukeiUser>goukeiDealer){
                out.println("<p>ユーザーの勝ちです。</p>");
            }else{
                out.println("<p>ディーラーの勝ちです。</p>");
            }

            out.println("</body>");
            out.println("</html>");
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
