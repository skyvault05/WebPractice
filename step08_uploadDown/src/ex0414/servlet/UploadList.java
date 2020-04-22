package ex0414.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadList
 */
@WebServlet("/UploadList")
public class UploadList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		String saveDir = req.getServletContext().getRealPath("/save/");
    		File file = new File(saveDir);
    		File[] files = file.listFiles();
    		
    		req.setAttribute("files", files);
    		req.getRequestDispatcher("uploadList.jsp").forward(req, resp);
    	}

}
