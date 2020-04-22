package ex0410.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("sesisionCreated()...");
	}
	
	/**
	 * session.invalidate()...
	 * session timeout...
	 * 브라우저 종료시에는 이벤트x 호출x
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionDestroyed()...");
	}
	
}
