/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2015-11-26 11:54:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.ServletException;

public final class log_005fclean_jsp extends org.apache.jasper.runtime.HttpJspBase
        implements org.apache.jasper.runtime.JspSourceDependent {

    private static final javax.servlet.jsp.JspFactory _jspxFactory =
            javax.servlet.jsp.JspFactory.getDefaultFactory();

    private static java.util.Map<java.lang.String, java.lang.Long> _jspx_dependants;

    static {
        _jspx_dependants = new java.util.HashMap<java.lang.String, java.lang.Long>(2);
        _jspx_dependants.put("/footer.jsp", Long.valueOf(1448530261162L));
        _jspx_dependants.put("/footer_menu.jsp", Long.valueOf(1448530091318L));
    }

    private javax.el.ExpressionFactory _el_expressionfactory;
    private org.apache.tomcat.InstanceManager _jsp_instancemanager;

    public java.util.Map<java.lang.String, java.lang.Long> getDependants() {
        return _jspx_dependants;
    }

    public void _jspInit() {
        _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
    }

    public void _jspDestroy() {
    }

    public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
            throws java.io.IOException, javax.servlet.ServletException {

        final javax.servlet.jsp.PageContext pageContext;
        javax.servlet.http.HttpSession session = null;
        final javax.servlet.ServletContext application;
        final javax.servlet.ServletConfig config;
        javax.servlet.jsp.JspWriter out = null;
        final java.lang.Object page = this;
        javax.servlet.jsp.JspWriter _jspx_out = null;
        javax.servlet.jsp.PageContext _jspx_page_context = null;


        try {
            response.setContentType("text/html; charset=UTF-8");
            pageContext = _jspxFactory.getPageContext(this, request, response,
                    null, true, 8192, true);
            _jspx_page_context = pageContext;
            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();
            _jspx_out = out;

            out.write("log\r\n");
            out.write("<html>\r\n");
            out.write("    <head>\r\n");
            out.write("        <title>SQLCmd</title>\r\n");
            out.write("    </head>\r\n");
            out.write("    <body>\r\n");
            out.write("    <form action=\"logs\" method=\"post\">\r\n");
            out.write("            <caption>For clean logs click button</caption>\r\n");
            out.write("            <tr>\r\n");
            out.write("                <td></td>\r\n");
            out.write("                <td><input type=\"submit\" name=\"logs\" value=\"Clean\"></td>\r\n");
            out.write("            </tr>\r\n");
            out.write("    </table>\r\n");
            out.write("    </form>\r\n");
            out.write("    ");
            out.write("\r\n");
            out.write("\r\n");
            out.write("<table>\r\n");
            out.write("    <tr>\r\n");
            out.write("        <td>\r\n");
            out.write("            <p>You can go to  <a href=\"help\">help</a> or <a href=\"menu\">Menu</a>\r\n");
            out.write("        </td>\r\n");
            out.write("    </tr>\r\n");
            out.write("\r\n");
            out.write("</table>");
            out.write("\r\n");
            out.write("    ");
            out.write("\r\n");
            out.write("\r\n");
            out.write("<table>\r\n");
            out.write("    <tr>\r\n");
            out.write("        <td style=\"color: darkblue; font-size: small\" ><br><br>Copytihgt 2015 JuJa.com.ua tervola (all rights reserved)</td>\r\n");
            out.write("    </tr>\r\n");
            out.write("</table>");
            out.write("\r\n");
            out.write("</body>\r\n");
            out.write("</html>");
        } catch (java.lang.Throwable t) {
            if (!(t instanceof javax.servlet.jsp.SkipPageException)) {
                out = _jspx_out;
                if (out != null && out.getBufferSize() != 0)
                    try {
                        out.clearBuffer();
                    } catch (java.io.IOException e) {
                    }
                if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
                else throw new ServletException(t);
            }
        } finally {
            _jspxFactory.releasePageContext(_jspx_page_context);
        }
    }
}
