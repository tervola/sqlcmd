/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2015-11-26 15:04:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jspproject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class help_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/jspproject/footer.jsp", Long.valueOf(1448530261162L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
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

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <title>SQLCmd</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("Help list:<br>\r\n");
      out.write("<ul>\r\n");
      out.write("    <li>help:<br> Show this help\r\n");
      out.write("        <p><li>exit:<br> Output from the program</li>\r\n");
      out.write("        <p><li>list:<br> List of tables into the database</li>\r\n");
      out.write("        <p><li>Select from table:<br>Select records from table, examples:</li>\r\n");
      out.write("    <br>SELECT * FROM name\r\n");
      out.write("    <br>SELECT * FROM name WHERE id > 1\r\n");
      out.write("    <br>SELECT id FROM name WHERE id < 1\r\n");
      out.write("    <p><li>Insert into table, examples:\r\n");
      out.write("        <br>INSERT INTO id (id_name,id_temp,country_name) VALUES (3, 'tree', 'UA')\r\n");
      out.write("        <br>INSERT INTO employee (id,name,alias) VALUES (1, 'Stas', 'tervola')\r\n");
      out.write("    <p><li>Updating records:<br>Updating records into table, example:\r\n");
      out.write("        <br>UPDATE id set country_name = 'Unknown' WHERE country_name ='null'\r\n");
      out.write("    <p><li>Deleting records, example::\r\n");
      out.write("        <br>DELETE FROM id WHERE id_name = 4\r\n");
      out.write("    <p><li>drop, example:\r\n");
      out.write("        <br>DROP TABLE films, distributors\r\n");
      out.write("    <p><li>Create table, example:\r\n");
      out.write("        <br>CREATE TABLE COMPANY (ID INT, NAME TEXT NOT NULL, AGE INT NOT NULL)\r\n");
      out.write("</ul>\r\n");
      out.write("You can go to <a href=\"menu\">Menu</a>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td style=\"color: darkblue; font-size: small\" ><br><br>Copytihgt 2015 JuJa.com.ua tervola (all rights reserved)</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("</table>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}