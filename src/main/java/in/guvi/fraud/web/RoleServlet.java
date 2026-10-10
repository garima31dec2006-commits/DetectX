package in.guvi.fraud.web;
import jakarta.servlet.http.*;import java.io.IOException;
public abstract class RoleServlet extends HttpServlet{protected boolean require(HttpServletRequest q,HttpServletResponse p,String role)throws IOException{Object r=q.getSession(false)==null?null:q.getSession(false).getAttribute("role");if(!role.equals(r)){p.sendRedirect(q.getContextPath()+"/login");return false;}return true;}}
