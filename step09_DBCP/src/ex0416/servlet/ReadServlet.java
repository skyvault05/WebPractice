package ex0416.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex0416.dao.MemberDAO;
import ex0416.dao.MemberDAOImpl;
import ex0416.domain.Member;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/read")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String url = "error.jsp";
		if(id==null || id.equals("")) {
			request.setAttribute("errMsg", "id정보가 없으므로 조회 할 수 없습니다.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		
		MemberDAO dao = new MemberDAOImpl();
		try {
			Member member = dao.selectById(id);
			request.setAttribute("member", member);
			url = "read.jsp";
		} catch (SQLException e) {
			request.setAttribute("errMsg", "조회 할 수 없습니다.");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
