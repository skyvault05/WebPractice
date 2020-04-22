package kosta.mvc.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/elec")
public class DispatcherServlet extends HttpServlet {
	private Map<String, Controller> map;
	private ServletContext application;
	
	@Override
	public void init() throws ServletException {
		application = super.getServletContext();
		map = (Map<String, Controller>) application.getAttribute("map");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command == null || command.equals("")) command = "list";
		Controller controller = map.get(command);
		
		try {
			ModelAndView mv = controller.handleRequest(request, response);
			
			if(mv.isRedirect()) {
				response.sendRedirect(mv.getViewName());
			}else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
		} catch (Exception e) {			
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("errorView/error.jsp").forward(request, response);
		}
		
		
		
	}
}
