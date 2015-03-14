package weixin.adam.testadam.servlet;

import weixin.adam.testadam.utils.SignUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lab on 2015/3/8.
 */
public class PortalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");


        PrintWriter out = resp.getWriter();
        if (signature!=null || !signature.trim().equals("")){

          if (SignUtil.checkSignature(signature,timestamp,nonce)){
              out.print(echostr);
          }
      }

        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
