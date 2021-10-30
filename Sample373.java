import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample373 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        res.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>サーブレットコンテキスト情報を取得</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>サーブレットコンテキスト情報</h2>");

        // バージョン情報
        ServletContext context = getServletContext();
        String ServerInfo = context.getServerInfo();
        int MajorVersion = context.getMajorVersion();
        int MinorVersion = context.getMinorVersion();
        String RealPath = context.getRealPath("/");
        out.println("<b>ServerInfo:</b>" + ServerInfo + "<br>");
        out.println("<b>MajorVersion:</b>" + MajorVersion + "<br>");
        out.println("<b>MinorVersion:</b>" + MinorVersion + "<br>");
        out.println("<b>RealPath:</b>" + RealPath + "<br>");

        // コンテキストの全属性名を取得
        Enumeration enum = context.getAttributeNames();

        // Enumerationオブジェクトから属性名を取り出す
        String attrName;
        String wfNames[];
        while (enum.hasMoreElements()) {
            attrName = (String)enum.nextElement();
            out.println("<br><b>" + attrName + ":</b>");
            if (("org.apache.catalina.WELCOME_FILES").equals(attrName)) {
                wfNames = (String[])context.getAttribute(attrName));
                for (int i = 0; i < wfNames.length; i++) {
                    out.println(wfNames[i] + ",");
                }
            } else {
                out.println(context.getAttribute(attrName));
            }
        }
        out.println("</body></html>");
        out.close();
    }
}
