/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sasakichiaki
 */
@WebServlet(name = "Goodsup", urlPatterns = {"/Goodsup"})
public class Goodsup extends HttpServlet {

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
        
                RequestDispatcher logInAdmin = request.getRequestDispatcher("/WEB-INF/goods_1.jsp");
                logInAdmin.forward(request, response);
                
                String addGoodsName = "";
            
            if (addGoodsName != null) {
                Connection db_con = null;//①DBの接続を管理するConnectionクラスの変数を用意
                PreparedStatement db_pr = null;//②SQL文を実行するためにPreparedStatementを取得
                ResultSet db_data = null;//③QL文の実行（executeQueryメソッド）
                
                try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory_control", "root", "root");

                db_pr = db_con.prepareStatement("SELECT * FROM goods_list");
                db_data = db_pr.executeQuery();
                
                HttpSession goodsList = request.getSession();
                
                int i =0;
                
                while (db_data.next()) {
                    goodsList.setAttribute("DataId"+i,db_data.getString("goodsID"));
                    goodsList.setAttribute("DataName"+i,db_data.getString("goodsName"));
                    goodsList.setAttribute("DataPrice"+i,db_data.getString("price"));
                    goodsList.setAttribute("DataStock"+i,db_data.getString("stock"));
                    goodsList.setAttribute("DataDesription"+i,db_data.getString("description"));
                    goodsList.setAttribute("DataJanCode"+i,db_data.getString("janCode"));
                    i++;
                }
                
                goodsList.setAttribute("id",i);
                
            db_data.close();
            db_pr.close();
            db_con.close();

            } catch (SQLException e_sql) {
                System.out.println("接続時にエラーが発生しました：" + e_sql.toString());
            } catch (Exception e) {
                System.out.println("接続時にエラーが発生しました：" + e.toString());
            } finally {
                if (db_con != null) {
                    try {
                        db_con.close();
                    } catch (Exception e_con) {
                        System.out.println(e_con.getMessage());
                    }
                }
            }
            }
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
