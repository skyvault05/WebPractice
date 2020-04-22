package ex0410.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(
		urlPatterns = { "/test" }, 
		initParams = { 
				@WebInitParam(name = "hobby", value = "놀기")
		},
		loadOnStartup = 1
		)
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("TestServlet의 init()...");
		
		String hobby = config.getInitParameter("hobby");
		String id = config.getInitParameter("id");
		
		ServletContext application = config.getServletContext();
		String msg = application.getInitParameter("message");
		String age = application.getInitParameter("age");
		
		System.out.println("hobby : "+hobby);
		System.out.println("id : "+id);
		System.out.println("message : "+msg);
		System.out.println("age : "+age);


		}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service()...");	
		}

}
