package ex0416.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex0416.dao.MemberDAO;
import ex0416.dao.MemberDAOImpl;
import ex0416.domain.Member;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String keyField = req.getParameter("keyField");
			String keyWord = req.getParameter("keyWord");
			String url = "error.jsp";
			try {
				if(keyField == null || keyField.equals("") || keyWord == null || keyWord.equals("")) {
					req.setAttribute("errMsg", "검색필드와 검색단어 값이 충분하지 않습니다.");
				}else {
					MemberDAO dao = new MemberDAOImpl();
					List<Member> list = dao.searchByKeyword(keyField, keyWord);
					req.setAttribute("list", list);
					url = "memberSelect.jsp";
				}
			}catch(SQLException e) {
				req.setAttribute("errMsg", e.getMessage());
			}
			
			req.getRequestDispatcher(url).forward(req, resp);
		}

}
