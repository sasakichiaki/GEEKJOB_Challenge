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
import model.Login;

/**
 *
 * @author sasakichiaki
 */
@WebServlet(name = "LogIn", urlPatterns = {"/LogIn"})
public class LogIn extends HttpServlet {

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
        
        
        // HttpSessionインスタンスの取得
        HttpSession session = request.getSession();
        Login sessiondata = (Login)session.getAttribute("loginSession");
        
        String logout = request.getParameter("action");
        
        if(logout != null){
            // セッションスコープからインスタンスを削除
            session.removeAttribute("loginSession");
            RequestDispatcher logIn = request.getRequestDispatcher("/WEB-INF/login.jsp");
            logIn.forward(request, response); 
        } else if (sessiondata != null){
            String kakunin = sessiondata.getStatus();
            if (kakunin.equals("admin")) {
                RequestDispatcher logInAdmin = request.getRequestDispatcher("/WEB-INF/admin.jsp");
                logInAdmin.forward(request, response);
            } else if (kakunin.equals("vender")){
                RequestDispatcher logInAdmin = request.getRequestDispatcher("/WEB-INF/vender.jsp");
                logInAdmin.forward(request, response);
            }
        } else {
                RequestDispatcher logIn = request.getRequestDispatcher("/WEB-INF/login.jsp");
                logIn.forward(request, response); 
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
        String resultloginid = request.getParameter("loginid");
        String resultpassword = request.getParameter("password");

        //もしloginidがnullなら入力フォームを表示
        
        if (resultloginid.equals("")) {
            RequestDispatcher logIn = request.getRequestDispatcher("/WEB-INF/login.jsp");
            logIn.forward(request, response);
        } else {
            //ここからデータベースに一致するか確認作業
            
            //セッションにセットする
            Login loginSession = new Login();
            loginSession.setLoginId(resultloginid);
            loginSession.setLoginPassword(resultpassword);
            
            //// HttpSessionインスタンスの取得
            HttpSession session = request.getSession();
            
            //データベース接続
            Connection db_con = null;//①DBの接続を管理するConnectionクラスの変数を用意
            PreparedStatement db_pr = null;//②SQL文を実行するためにPreparedStatementを取得
            ResultSet db_data = null;//③QL文の実行（executeQueryメソッド）
            
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory_control", "root", "root");

                //まずは、取得したログイン情報がデーターベースと一致するかを確認して一致したデータをとる
                db_pr = db_con.prepareStatement("SELECT * FROM user_list WHERE loginID ='" + resultloginid + "'AND passWord='" + resultpassword + "'");
                db_data = db_pr.executeQuery();

                String check1 = "";
                
                while (db_data.next()) {
                    check1 = db_data.getString("status");
                    loginSession.setStatus(check1);
                }

                switch (check1) {
                    case "admin":
                        // セッションスコープにインスタンスを保存
                        session.setAttribute("loginSession", loginSession);
                        RequestDispatcher logInAdmin = request.getRequestDispatcher("/WEB-INF/admin.jsp");
                        logInAdmin.forward(request, response);
                        break;

                    case "vender":
                        // セッションスコープにインスタンスを保存
                        session.setAttribute("loginSession", loginSession);
                        RequestDispatcher logInVender = request.getRequestDispatcher("/WEB-INF/vender.jsp");
                        logInVender.forward(request, response);
                        break;

                    default:
                        RequestDispatcher logInError = request.getRequestDispatcher("/WEB-INF/login_error.jsp");
                        logInError.forward(request, response);

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
