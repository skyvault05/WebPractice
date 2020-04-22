package homework0410;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		ServletContext application = arg0.getServletContext();
		HttpSession session = arg0.getSession();
		PrintWriter out = arg1.getWriter();
		
		Object obj = application.getAttribute("userCounter");
		AtomicInteger counter = (AtomicInteger) obj;
		counter.decrementAndGet();
		application.setAttribute("userCounter", counter);
		
		session.invalidate();
		out.println("<script>");
		out.println("top.location.href='index.jsp'");
		out.println("</script>");  
	}

}
