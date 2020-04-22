package homework0410;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
private String dbId="jang", dbPwd="1234";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");		
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		String name = "이남진";
		ServletContext application = req.getServletContext();
		
		if(req.getParameter("id").equals(dbId) && req.getParameter("pwd").equals(dbPwd)){
			//인증된 사용자의 정보를 세션에 저장
			session.setAttribute("name",name);
			session.setAttribute("creationTime", new Date(System.currentTimeMillis()));
			
			if(application.getAttribute("userCounter")==null) {
				application.setAttribute("userCounter", new AtomicInteger(1));
			}else {
				Object obj = application.getAttribute("userCounter");
				AtomicInteger counter = (AtomicInteger) obj;
				counter.incrementAndGet();
				application.setAttribute("userCounter", counter);
			}
			
			out.println("<script>");
			out.println("top.location.href='index.jsp'");
			out.println("</script>");            
		} else{//메세지 출력
			//톰캣에선 동적 코드부터 실행시켜 반환하기 때문에 response.sendRedirect("LoginForm.html");이 먼저 실행됨
			//그래서 스크립트가 윗줄에서 있어도 실행은 동적코드가 먼저 돼서 alert이 뜨기 전에 리다이렉트됨 그래서 history나 location을 마지막에 실행되는 스크립트 쪽에 넣어서 처리함.
			out.println("<script>");
			out.println("alert('"+name+"님 정보를 확인해 주세요..')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}

}
