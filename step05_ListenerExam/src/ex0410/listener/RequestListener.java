package ex0410.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener {
	long timer;
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("requestInitialized()...");
		
		
		timer = System.currentTimeMillis();
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed()...");
		
		ServletRequest sr = sre.getServletRequest();
		HttpServletRequest req = (HttpServletRequest) sr;
		String url = req.getRequestURL().toString();
		
		timer = System.currentTimeMillis() - timer;
		
		System.out.println(url);
		System.out.println(timer+"ms");
	}
}
