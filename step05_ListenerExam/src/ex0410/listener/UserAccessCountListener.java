package ex0410.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserAccessCountListener implements ServletContextListener, HttpSessionListener {
	/**
	 * 1.서버가 시작될 떄 접속자 수를 count해줄 변수의 초기화 작업
	 */
	@Override
	public void contextInitialized(ServletContextEvent e) {
		ServletContext application = e.getServletContext();
		application.setAttribute("count", new AtomicInteger());
	}
	
	/**
	 * 2. session이 시작되면 접속자 수를 증가시킨다.
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext application = se.getSession().getServletContext();
		Object obj = application.getAttribute("count");
		AtomicInteger ai = (AtomicInteger) obj;
		System.out.println(ai.incrementAndGet());
		
		application.setAttribute("count", ai);
	}
	
	/** 
	 * 3. session이 종료되면 접속자 수 감소
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext application = se.getSession().getServletContext();
		Object obj = application.getAttribute("count");
		AtomicInteger ai = (AtomicInteger) obj;
		
		System.out.println(ai.decrementAndGet());
		application.setAttribute("count", ai);

	}
}
