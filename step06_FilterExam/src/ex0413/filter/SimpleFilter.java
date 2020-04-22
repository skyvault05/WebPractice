package ex0413.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimpleFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init() from SimpleFilter...");
		
		String addr = filterConfig.getInitParameter("addr");
		String message = filterConfig.getInitParameter("message");
		
		System.out.println("addr : "+addr);
		System.out.println("message : "+message);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("SimpleFilter의 사전처리 중입니다...");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		chain.doFilter(req, resp);
		System.out.println("SimpleFilter의 사후처리 중입니다...");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() from SimpleFilter...");
	}

	

}
