/*

メソッドの中の処理は、３人分のプロフィール（項目は戻り値2と同様）を作成し、
人物のID、名前、生年月日、住所
引数として渡された値と同じIDを持つ人物のプロフィールを返却する様にしてください。
ループ処理で全員分のプロフィールをid以外表示する処理を作成してください。
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author sasakichiaki
 */
public class NewServlet extends HttpServlet {

    public String profile(int id) {

        String[] data = new String[3];
        data[0] ="佐々木";
        data[1] ="１９９０年";
        data[2] ="佐々木の住所";
        
        String no1 =data[0]+data[1]+data[2];

        String[] data2 = new String[3];
        data2[0] ="鈴木";
        data2[1] ="１９９１年";
        data2[2] ="鈴木の住所";
        
        String no2 =data2[0]+data2[1]+data2[2];
        
        String[] data3 = new String[3];
        data3[0] ="佐藤";
        data3[1] ="１９９1年";
        data3[2] ="佐藤の住所";
        
        String no3 =data3[0]+data3[1]+data3[2];
        
        
        HashMap<Integer, String> idNo = new HashMap<Integer, String>();
        idNo.put(1, no1);
        idNo.put(2, no2);
        idNo.put(3, no3);

        return idNo.get(id);
    }

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
            out.println(profile(1));
            out.println(profile(2));
            out.println(profile(3));
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
