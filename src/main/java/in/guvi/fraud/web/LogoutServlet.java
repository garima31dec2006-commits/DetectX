package in.guvi.fraud.web;
import jakarta.servlet.annotation.WebServlet;import jakarta.servlet.http.*;import java.io.*;
@WebServlet("/logout") public class LogoutServlet extends HttpServlet{protected void doGet(HttpServletRequest q,HttpServletResponse p)throws IOException{if(q.getSession(false)!=null)q.getSession(false).invalidate();p.sendRedirect(q.getContextPath()+"/login");}}
