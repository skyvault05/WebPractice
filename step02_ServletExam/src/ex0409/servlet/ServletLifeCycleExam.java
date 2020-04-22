package ex0409.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 브라우저에서 실행되는 servlet문서 작성
 * 1)Must Be public class
 * 2)Must Be HttpServlet
 * 3)override methods what we need
 * 
 * 4)servlet 등록 필수
 * 			(생성 + url에서 어떻게 요청했때 서블릿이 실행될지 설정)
 * 			- web.xml 등록
 * 			- annotation 등록
 * @author hyo-jinkim
 *
 */
public class ServletLifeCycleExam extends HttpServlet {
	
	public ServletLifeCycleExam() {
		System.out.println("ServletLifeCycleExam호출됨...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출됨...");
		super.init();
	}
	
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		System.out.println("service() 호췰됨...");
//		super.service(arg0, arg1);
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//encoding 방식 지정
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("doGet() 호출됨...");

		//브라우저에 응답(화면구성)
		//출력스트림 필요함
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello ~~ 안녕</h1>");
		
		//내장객체
		HttpSession session = req.getSession();
		ServletContext application = req.getServletContext();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost호출됨() ");
		super.doPost(req, resp);
	}

	

	@Override
	public void destroy() {
		System.out.println("destroy() 호출됨");
		super.destroy();
	}

	

}
