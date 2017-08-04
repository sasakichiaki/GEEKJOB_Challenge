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
      out.write("        <form action=\"./newjsp.jsp\" method=\"post\">\n");
      out.write("            <p>名前</p>\n");
      out.write("            <p><input type=\"text\" name=\"txtName\"></p>\n");
      out.write("            <p>性別</p>\n");
      out.write("            <p><input type=\"radio\" name=\"sex\" value=\"women\">女性</p>\n");
      out.write("            <p><input type=\"radio\" name=\"sex\" value=\"men\">男性</p>\n");
      out.write("            <p>趣味</p>\n");
      out.write("            <textarea name=\"shumi\" rows=\"10\" cols=\"80\">ここに趣味を記載してください。</textarea>\n");
      out.write("            <input type=\"submit\" value=\"送信\">\n");
      out.write("            <input type=\"reset\" value=\"リセット\">\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        ");

            // 受け取るパラメータの文字コード
            request.setCharacterEncoding("UTF-8");
//            request.getParameter("txtName");
//            request.getParameter("women");
//            request.getParameter("men");
//            request.getParameter("shumi");
            
            out.print(request.getParameter("txtName"));
            out.print(request.getParameter("txtName"));
            out.print(request.getParameter("women"));
            out.print(request.getParameter("men"));
            out.print(request.getParameter("shumi"));

            
      out.write("\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
