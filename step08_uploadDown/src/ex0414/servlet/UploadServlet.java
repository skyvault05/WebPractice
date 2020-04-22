package ex0414.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UpLoad")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송되는 데이터 받기
//		String name = request.getParameter("name");
//		String subject = request.getParameter("subject");
//		String file = request.getParameter("file");
		
		String saveDir = request.getServletContext().getRealPath("/save");
		int maxSize = 1024*1024*100; //100M
		String encoding = "utf-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String name = m.getParameter("name");
		String subject = m.getParameter("subject");
		String originalFile = m.getOriginalFileName("file");
		String file = m.getFilesystemName("file");
		
		System.out.println("name : "+name);
		System.out.println("subject : "+subject);
		System.out.println("file : "+file);
		System.out.println("OriginalFile : "+originalFile);
		//업로드 완료 후 결과 페이지로 이동
		//view쪽으로 전달될 정보를 저장해서 이동
		request.setAttribute("name", name); //jsp에서 ${requestScope.name}
		request.setAttribute("subject", subject);
		request.setAttribute("originalName", originalFile);
		request.setAttribute("systemName", file);
		request.setAttribute("fileLength", m.getFile("file").length());
		request.setAttribute("saveDir", saveDir);
		
		//이동방식은 requset들고가는 foward로
		request.getRequestDispatcher("uploadResult.jsp").forward(request, response);
	}

}
