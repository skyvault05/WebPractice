package ex0410.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {

	/**
	 * ServletContext(application)이 start될떄 호출
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitailized()...");
		//각 나라별 국가 코드를 설정해서 모든 영역에서 사용할 수 있도록 한다.
		
		ServletContext application = sce.getServletContext();
		Map<String, String> map = new HashMap<>();
		map.put("kr", "대한민국");
		map.put("us", "미국");
		map.put("jp", "일본");
		map.put("cn", "중국");
		map.put("fr", "프랑스");
		
		application.setAttribute("nation", map);
	}
	
	/**
	 * ServletContext(application)이 stop될떄 호출
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed()...");
	}

	

}
