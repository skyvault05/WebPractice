package ex0410.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamTestServlet extends HttpServlet {
	String id, addr, msg, age;
	@Override
	public void init() throws ServletException {
		System.out.println("init()...");
		id = super.getInitParameter("id");
		addr = super.getInitParameter("addr");
		
		ServletContext application = super.getServletContext();
		msg = application.getInitParameter("message");
		age = application.getInitParameter("age");
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<h2>");
		out.println("아이디 : "+id+"<br>");
		out.println("주소 : "+addr+"<br>");
		out.println("메세지 : "+msg+"<br>");
		out.println("나이 : "+age+"<br>");
		out.println("</h2>");
	}
}
