/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//インポート
import javax.servlet.RequestDispatcher;
import java.sql.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author sasakichiaki
 */
@WebServlet(name = "UserAdd", urlPatterns = {"/UserAdd"})
public class UserAdd extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            String addStatus = request.getParameter("status");
            
                if(addStatus == null){
                RequestDispatcher logInAdmin = request.getRequestDispatcher("/WEB-INF/admin.jsp");
                logInAdmin.forward(request, response);
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
        
            //フォームから情報を受け取る
            request.setCharacterEncoding("UTF-8");
            String addStatus = request.getParameter("status");
            String addName = request.getParameter("name");
            String addLoginID = request.getParameter("loginID");
            String addPassWord = request.getParameter("passWord");
            String addEmail = request.getParameter("email");
            
            if (addStatus != null) {
                Connection db_con = null;//①DBの接続を管理するConnectionクラスの変数を用意
                PreparedStatement db_pr = null;//②SQL文を実行するためにPreparedStatementを取得
                ResultSet db_data = null;//③QL文の実行（executeQueryメソッド）
                
                try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory_control", "root", "root");

                db_pr = db_con.prepareStatement("SELECT * FROM user_list WHERE loginID ='" + addLoginID + "'");
                db_data = db_pr.executeQuery();
                
                String check1 = "";
                
                while (db_data.next()) {
                    check1 = db_data.getString("loginID");
                }
                
                if (check1.equals("")){
                    
                
                //まずは、取得したログイン情報がデーターベースと一致するかを確認して一致したデータをとる
                db_pr = db_con.prepareStatement("SELECT * FROM user_list");
                db_data = db_pr.executeQuery();

                int userID = 1;
                int chake = 0; //０は問題なし　１はダブり
                
                while (db_data.next()) {
                    userID = userID+1;
                }
                
                String addtext = ("INSERT INTO user_list (userID, status, name, loginID, passWord, mail) VALUES (" + userID + ", '" + addStatus + "', '" + addName + "', '" + addLoginID + "','" + addPassWord + "','" + addEmail + "');");
                
                db_pr = db_con.prepareStatement(addtext);
                db_pr.executeUpdate();
                db_pr = db_con.prepareStatement("SELECT * FROM user_list");
                db_data = db_pr.executeQuery();
                
                RequestDispatcher logInAdmin = request.getRequestDispatcher("/WEB-INF/admin.jsp");
                logInAdmin.forward(request, response);
                
                } else {
                RequestDispatcher logInAdmin = request.getRequestDispatcher("/WEB-INF/user_error.jsp");
                logInAdmin.forward(request, response);
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
