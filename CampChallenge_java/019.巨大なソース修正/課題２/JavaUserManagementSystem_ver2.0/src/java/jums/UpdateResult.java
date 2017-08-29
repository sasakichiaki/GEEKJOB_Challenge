package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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

        //セッションスタート
        HttpSession session = request.getSession();
        ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>) session.getAttribute("resultData");
        Integer id = (Integer) session.getAttribute("id");
        
        try {
            request.setCharacterEncoding("UTF-8");//文字化け防止
            /* TODO output your page here. You may use following sample code. */
            
            //アクセスルートチェック
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                try {
                    throw new Exception("不正なアクセスです");
                } catch (Exception ex) {
                    Logger.getLogger(UpdateResult.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            //更新内容をリスパッチャー＆ネットビーンズへ
            //あとでユーザーIDでセット！
            UserDataBeans udb = new UserDataBeans();
            udb.setName(request.getParameter("name"));
            udb.setYear(request.getParameter("year"));
            udb.setMonth(request.getParameter("month"));
            udb.setDay(request.getParameter("day"));
            udb.setType(request.getParameter("type"));
            udb.setTell(request.getParameter("tell"));
            udb.setComment(request.getParameter("comment"));
            
            
            //searchを参考に内容を確認。内容をセッションに追加
            ArrayList<String> upList = udb.chkproperties();
            session.setAttribute("Update",upList);
            
            //更新時間の日付の確保
            UserDataDTO upData = new UserDataDTO();
            udb.UD2DTOMapping(upData);
                

            try {
                
            //更新対象のID情報を取得する
            int userID = Integer.parseInt(request.getParameter("userID"));
            //更新はそのではダメのでユーザーIDでセット
            upData.setUserID(userID);
                //DBのデータの更新
                UserDataDAO.getInstance().update(upData);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateResult.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
            
        } finally {
            out.close();
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
