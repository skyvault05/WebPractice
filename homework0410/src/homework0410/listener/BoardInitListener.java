package homework0410.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import homework0410.dto.BoardDTO;

public class BoardInitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		String[] article1 = application.getInitParameter("article1").split("//");
		String[] article2 = application.getInitParameter("article2").split("//");
		String[] article3 = application.getInitParameter("article3").split("//");
		
		BoardDTO b1 = new BoardDTO(article1[0], article1[1] , article1[2]);
		BoardDTO b2 = new BoardDTO(article2[0], article2[1] , article2[2]);
		BoardDTO b3 = new BoardDTO(article3[0], article3[1] , article3[2]);
		List<BoardDTO> list = new ArrayList<>();
		
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		application.setAttribute("boardList", list);
		
	}
	
}
