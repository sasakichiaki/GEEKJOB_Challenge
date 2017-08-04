package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"newjsp.jsp\" method=\"get\">\n");
      out.write("            <p>総額</p>\n");
      out.write("            <p><input type=\"number\" name=\"total\">円</p>\n");
      out.write("            <p>個数</p>\n");
      out.write("            <p><input type=\"number\" name=\"count\">個</p>\n");
      out.write("\n");
      out.write("            <p><input type=\"radio\" name=\"type\" value=\"1\">雑貨</p>\n");
      out.write("\n");
      out.write("            <p><input type=\"radio\" name=\"type\" value=\"2\">生鮮食品</p>\n");
      out.write("\n");
      out.write("            <p><input type=\"radio\" name=\"type\" value=\"3\">その他</p>\n");
      out.write("            <input type=\"submit\" value=\"送信\">\n");
      out.write("            <input type=\"reset\" value=\"リセット\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");


                if (request.getParameter("total") == null) {

                } else {

                    int a = Integer.parseInt(request.getParameter("total"));
                    int b = Integer.parseInt(request.getParameter("count"));

                    out.print("<br>１個当たりの値段:"+ a / b+ "円<br>");

                    if (a >= 5000) {
                        out.print("5%");
                    } else if (a >= 3000) {
                        out.print("4%");
                    }

                }

                request.setCharacterEncoding("UTF-8");
                request.getParameter("total");
                request.getParameter("count");
                request.getParameter("type");

            
      out.write("\n");
      out.write("            </body>\n");
      out.write("            </html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
