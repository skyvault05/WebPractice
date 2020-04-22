package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * view의 모든 요청을 중앙집중적으로 관리하기 위한 frontController
 * 요청-> model(service) -> result View
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(urlPatterns = "/front", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		System.out.println("key:"+key);
		Controller controller=null;
		
		if(key.equals("insert")) {
			controller = new InsertController();
		}else if(key.equals("select")) {
			controller = new SelectController();
		}else if(key.equals("update")) {
			controller = new UpdateController();
		}else if(key.equals("delete")) {
			controller = new DeleteContorller();
		}
		
		ModelAndView mv = controller.handleRequest(request, response);
		if(mv.isRedirect()) {
			response.sendRedirect(mv.getViewName());
		}else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
	
	}

}
