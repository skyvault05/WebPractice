package homework0410.listener;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import homework0410.dto.BoardDTO;

public class boardListener extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		ServletContext application = req.getServletContext();		
		PrintWriter out = resp.getWriter();
		
		
		
		Object listObj = application.getAttribute("boardList");
		List<BoardDTO> list = (List) listObj;
		Object nameObj = session.getAttribute("name");
		String name = (String) nameObj;
		String content = req.getParameter("content");
		list.add(new BoardDTO(name, content, new Date(System.currentTimeMillis())));
		
		out.println("<script>");
		out.println("top.location.href='index.jsp'");
		out.println("</script>"); 
	}
	
}
