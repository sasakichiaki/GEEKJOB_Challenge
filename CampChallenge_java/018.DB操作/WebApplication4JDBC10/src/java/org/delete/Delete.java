/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.delete;

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
@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {

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

        Connection db_con = null;//①DBの接続を管理するConnectionクラスの変数を用意
        PreparedStatement db_pr = null;//②SQL文を実行するためにPreparedStatementを取得
        ResultSet db_data = null;//③QL文の実行（executeQueryメソッド）

        try (PrintWriter out = response.getWriter()) {

            //フォームから情報を受け取る
            request.setCharacterEncoding("UTF-8");
            String profilesID = request.getParameter("id");

            if (profilesID == null) {
                RequestDispatcher kensaku = request.getRequestDispatcher("/WEB-INF/deleteform.jsp");
                kensaku.forward(request, response);
            } else {

                //DriverManagerにセット
                Class.forName("com.mysql.jdbc.Driver").newInstance();//JDBCドライバを新しく制作
                //データベース[con]を制作「localhostの3306ポートで動いているMySQLのtestというDB」
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "root");

                //stというデータベースにstationというデータベースを取得する
//            db_st = db_con.prepareStatement("select * from station");
////            db_st.setInt(1, 33);
                //Challenge_dbに作ったprofilesのテーブルを取得
//           db_pr = db_con.prepareStatement("SELECT * FROM profiles");
                db_pr = db_con.prepareStatement("SELECT * FROM profiles");
                db_data = db_pr.executeQuery();

//            削除前のデータの表示処理
                out.print("削除前の情報<br>");
                while (db_data.next()) {
                    out.print(db_data.getString("profilesID"));
                    out.print(db_data.getString("name"));
                    out.print(db_data.getString("tel"));
                    out.print(db_data.getString("age"));
                    out.print(db_data.getString("birthday") + "<br>");
                }

//            削除対応
                String deletetext = ("DELETE FROM profiles WHERE profilesID =" + profilesID);
                db_pr = db_con.prepareStatement(deletetext);
                db_pr.executeUpdate();

                db_pr = db_con.prepareStatement("SELECT * FROM profiles");
                db_data = db_pr.executeQuery();

//            削除したのちの結果
                out.print("削除後の情報<br>");
                while (db_data.next()) {
                    out.print(db_data.getString("profilesID"));
                    out.print(db_data.getString("name"));
                    out.print(db_data.getString("tel"));
                    out.print(db_data.getString("age"));
                    out.print(db_data.getString("birthday") + "<br>");
                }
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
