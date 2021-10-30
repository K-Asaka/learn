import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample397 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        // HTMLで入力した値を取得
        String param = req.getParameter("htmlparam");

        // HTMLで入力した値を加工
        param += " from servlet";

        // 加工した値をJSPに渡す
        req.setAttribute("servletparam", param);

        // 呼び出すJSPをドキュメントルートからの絶対パスで指定
        String str = "/397/Sample397.jsp";

        // JSPを呼び出す
        getServletContext().getRequestDispatcher(str).forward(req, res);
    }
}
