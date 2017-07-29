/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofr.mesodo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


/**
 *
 * @author sasakichiaki
 */
public class NewServlet extends HttpServlet {

        public ArrayList profile() {

        ArrayList<ArrayList> data = new ArrayList<ArrayList>();

        ArrayList<String> data1 = new ArrayList<String>();
        data1.add("1");
        data1.add("名前1");
        data1.add("生年月日1");
        data1.add(null);

        ArrayList<String> data2 = new ArrayList<String>();
        data2.add("2");
        data2.add("名前2");
        data2.add("生年月日2");
        data2.add("住所2");

        ArrayList<String> data3 = new ArrayList<String>();
        data3.add("3");
        data3.add("名前3");
        data3.add("生年月日3");
        data3.add("住所3");

        data.add(data1);
        data.add(data2);
        data.add(data3);

        return data;
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
            ArrayList<ArrayList> data = profile();

            ArrayList<String> data1 = data.get(0);

            Integer limit=2;
            
            for (int a = 0; a < limit; a++) {
                for (int i = 1; i < data.get(a).size(); i++) {
                    if (data.get(a).get(i) == null) {
                        continue;
                    } else {
                        out.print(data.get(a).get(i));
                    }
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
