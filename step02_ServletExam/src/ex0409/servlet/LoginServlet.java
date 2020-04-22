package ex0409.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private String userId = "jang";
	private String userPwd = "1234";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()");
		
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//post방식일 경우 한글 인코딩 설정 필요
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("doPost()");
		
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("userName");
		String pwd = req.getParameter("userPwd");
		String id = req.getParameter("userId");
		
//		out.println(id+":"+pwd+":"+name);
		
		if(id.equals(userId) && pwd.equals(userPwd)) {
			List<String> list = new ArrayList<>();
			list.add("등산"); list.add("수영");
			list.add("낚시"); list.add("골프");
			
			req.setAttribute("list", list);
			//이동
			//forward
			req.getRequestDispatcher("LoginOk.jsp").forward(req, resp);
			
			//redirect
//			resp.sendRedirect("LoginOk.jsp?userName="+URLEncoder.encode(name, "utf-8"));
		}else {//메세지 출력 및 뒤로가기 
			out.println("<script>");
			out.println("alert('"+name+"님 정보를 확인해주세요..'");
			out.println("history.back()");
			out.println("</script>");
		}
	}
}
