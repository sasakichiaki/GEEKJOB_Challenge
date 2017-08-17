/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;//インポート

import javax.servlet.RequestDispatcher;

/**
 *
 * @author sasakichiaki
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
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

        //初期設定
        Connection db_con = null;//①DBの接続を管理するConnectionクラスの変数を用意
        PreparedStatement db_pr = null;//②SQL文を実行するためにPreparedStatementを取得
        ResultSet db_data = null;//③QL文の実行（executeQueryメソッド）

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            //ここから処理開始
            //ここからDATAベースの処理とDATA
            Class.forName("com.mysql.jdbc.Driver").newInstance();//JDBCドライバを新しく制作
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "root");

            db_pr = db_con.prepareStatement("SELECT * FROM profiles");
            db_data = db_pr.executeQuery();

            //フォームから情報を受け取る
            request.setCharacterEncoding("UTF-8");
//            String result = request.getParameter("search");
            String resultnaem = request.getParameter("naem");
            String resultage = request.getParameter("age");
            String resultdate = request.getParameter("date");

            try {

//ここから検索の処理
                if (resultnaem != null || resultage != null || resultdate != null) {

                    while (db_data.next()) {
                        String s1 = db_data.getString("name");

                        if (!resultnaem.equals("")) {
                            if (s1.indexOf(resultnaem) != -1) {
                                out.println("名前" + db_data.getString("name"));
                                out.println(db_data.getString("age"));
                                out.println(db_data.getString("birthday"));
                            } 
                        }

                        String s2 = db_data.getString("age");

                        if (!resultage.equals("")) {
                            if (s2.indexOf(resultage) != -1) {
                                out.println("名前" + db_data.getString("name"));
                                out.println(db_data.getString("age"));
                                out.println(db_data.getString("birthday"));
                            } 
                        }

                        String s3 = db_data.getString("birthday");

                        if (!resultdate.equals("")) {
                            if (s3.indexOf(resultdate) != -1) {
                                out.println("名前" + db_data.getString("name"));
                                out.println(db_data.getString("age"));
                                out.println(db_data.getString("birthday"));
                            } 
                        }

                    }

                } else {
                    RequestDispatcher kensaku = request.getRequestDispatcher("/WEB-INF/search.jsp");
                    kensaku.forward(request, response);
                }

            } catch (Exception e) {
                System.out.print("エラー" + e.getMessage());
            }

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

            //ここまでDATAベースの処理
            //ここまでが処理
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
