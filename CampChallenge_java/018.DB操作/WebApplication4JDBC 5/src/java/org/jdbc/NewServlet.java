/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

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

        Connection db_con = null;//①DBの接続を管理するConnectionクラスの変数を用意
        PreparedStatement db_pr = null;//②SQL文を実行するためにPreparedStatementを取得
        ResultSet db_data = null;//③QL文の実行（executeQueryメソッド）

        try (PrintWriter out = response.getWriter()) {

            //DriverManagerにセット
            Class.forName("com.mysql.jdbc.Driver").newInstance();//JDBCドライバを新しく制作
            //データベース[con]を制作「localhostの3306ポートで動いているMySQLのtestというDB」
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "root");

            //stというデータベースにstationというデータベースを取得する
//            db_st = db_con.prepareStatement("select * from station");
////            db_st.setInt(1, 33);
            //Challenge_dbに作ったprofilesのテーブルを取得
//           db_pr = db_con.prepareStatement("SELECT * FROM profiles");
//           db_pr = db_con.prepareStatement("INSERT INTO profiles (profilesID, name, tel, age, birthday) VALUES (19, 'テスト 太郎', '012-45-6789' ,3,'1994-12-01')");
////           db_data = db_pr.executeQuery();
//           db_pr.executeUpdate();
            db_pr = db_con.prepareStatement("SELECT * FROM profiles");
            db_data = db_pr.executeQuery();

            while (db_data.next()) {

                String s1 = db_data.getString("name");
                String s2 = "茂";

                if (s1.indexOf(s2) != -1) {
                    out.print(db_data.getString("name"));
                }
            }

//            db_data = db_st.executeQuery();
//            while (db_data.next()) {
//                out.print("駅名：" + db_data.getString("stationName") + "<br>");
//            }
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
