/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2015-11-26 09:42:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.ServletException;

public final class select_005fresult_jsp extends org.apache.jasper.runtime.HttpJspBase
        implements org.apache.jasper.runtime.JspSourceDependent {

    private static final javax.servlet.jsp.JspFactory _jspxFactory =
            javax.servlet.jsp.JspFactory.getDefaultFactory();

    private static java.util.Map<java.lang.String, java.lang.Long> _jspx_dependants;

    static {
        _jspx_dependants = new java.util.HashMap<java.lang.String, java.lang.Long>(2);
        _jspx_dependants.put("/footer.jsp", Long.valueOf(1448530261162L));
        _jspx_dependants.put("/footer_menu.jsp", Long.valueOf(1448530091318L));
    }

    private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;

    private javax.el.ExpressionFactory _el_expressionfactory;
    private org.apache.tomcat.InstanceManager _jsp_instancemanager;

    public java.util.Map<java.lang.String, java.lang.Long> getDependants() {
        return _jspx_dependants;
    }

    public void _jspInit() {
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
        _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
    }

    public void _jspDestroy() {
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
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
            out.write("\r\n");
            out.write("<html>\r\n");
            out.write("    <head>\r\n");
            out.write("        <title>SQLCmd</title>\r\n");
            out.write("    </head>\r\n");
            out.write("    <body>\r\n");
            out.write("    SELECT RESULT:\r\n");
            out.write("    <table border=\"1\" width=\"300\">\r\n");
            out.write("        <caption align=\"left\">Result select command from table:</caption>\r\n");
            out.write("        ");
            if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
                return;
            out.write("\r\n");
            out.write("    </table>\r\n");
            out.write("\r\n");
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
            out.write("    </p>\r\n");
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

    private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
            throws java.lang.Throwable {
        javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
        javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
        //  c:forEach
        org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
        _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fforEach_005f0.setParent(null);
        // /select_result.jsp(11,8) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/select_result.jsp(11,8) '${select}'", _el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(), "${select}", java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
        // /select_result.jsp(11,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f0.setVar("row");
        // /select_result.jsp(11,8) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f0.setVarStatus("loop");
        int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[]{0};
        try {
            int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
            if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                    out.write("\r\n");
                    out.write("        <tr>\r\n");
                    out.write("            <td> ");
                    out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loop.index}", java.lang.String.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null, false));
                    out.write(" </td>\r\n");
                    out.write("            ");
                    if (_jspx_meth_c_005fforEach_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
                        return true;
                    out.write("\r\n");
                    out.write("        </tr>\r\n");
                    out.write("        ");
                    int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
                    if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                } while (true);
            }
            if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return true;
            }
        } catch (java.lang.Throwable _jspx_exception) {
            while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
                out = _jspx_page_context.popBody();
            _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
        } finally {
            _jspx_th_c_005fforEach_005f0.doFinally();
            _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
        }
        return false;
    }

    private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
            throws java.lang.Throwable {
        javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
        javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
        //  c:forEach
        org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
        _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
        _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
        // /select_result.jsp(14,12) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/select_result.jsp(14,12) '${row}'", _el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(), "${row}", java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
        // /select_result.jsp(14,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f1.setVar("colums");
        // /select_result.jsp(14,12) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f1.setVarStatus("loop");
        int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[]{0};
        try {
            int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
            if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                    out.write("\r\n");
                    out.write("            <td>\r\n");
                    out.write("               ");
                    out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${colums}", java.lang.String.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null, false));
                    out.write("\r\n");
                    out.write("            </td>\r\n");
                    out.write("            ");
                    int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
                    if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                } while (true);
            }
            if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return true;
            }
        } catch (java.lang.Throwable _jspx_exception) {
            while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
                out = _jspx_page_context.popBody();
            _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
        } finally {
            _jspx_th_c_005fforEach_005f1.doFinally();
            _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
        }
        return false;
    }
}
