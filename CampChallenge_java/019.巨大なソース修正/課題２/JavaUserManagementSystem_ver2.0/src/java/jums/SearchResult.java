package jums;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class SearchResult extends HttpServlet {

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
        try{
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
        
            //JavaBeansに検索フォームからの入力を取得
            //今後はデータベースからではなく、このudbから取得
            UserDataBeans udb = new UserDataBeans();
            
            //アクセスルートチェック
            String accesschk = request.getParameter("ac");
            
            //セッションスタート
            HttpSession session = request.getSession();
            
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            if(accesschk !=null){
                
                udb.setName(request.getParameter("name"));//検索フォームの名前
                udb.setYear(request.getParameter("year"));//検索フォームの生年月日
                udb.setType(request.getParameter("type"));//タイプ
                //一度検索条件の内容をsearchconditionという名前で保持。次の検索で使用
                session.setAttribute("searchcondition", udb);
                
            }
            
            //ここから検索：検索はUserDataDAOのUserDataDAO .getInstance().search(searchData)を利用
            
            //先ほどのsessionに入れた情報を使い、検索開始・ただしnullの場合は不可
            if(session.getAttribute("searchcondition")!=null){
                //検索一覧用のNBにsessionの内容をget
                    udb = (UserDataBeans)session.getAttribute("searchcondition");
            
                    //UserDataBeansをDTOオブジェクトにマッピング。DB専用のパラメータに変換
                    //ここは検索時間を確保？当初からあり
                    UserDataDTO searchData = new UserDataDTO();
                    udb.UD2DTOMapping(searchData);

                    //UserDataDAOを利用。データをarrayListに変更したので変更
                    //UserDataDAO .getInstance().searchを使って一覧のarraylistを確保
                    ArrayList<UserDataDTO> resultData = UserDataDAO .getInstance().search(searchData);
                    
                    //確保したarraylistowoをsessionにセットしてjsphe
                    request.setAttribute("resultData", resultData);
                    request.getRequestDispatcher("/searchresult.jsp").forward(request, response);

                }
            
            request.getRequestDispatcher("/searchresult.jsp").forward(request, response);  
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
