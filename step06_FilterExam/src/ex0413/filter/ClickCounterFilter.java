package ex0413.filter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class ClickCounterFilter
 */
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "fileName", value = "clickCount.properties")
		})
public class ClickCounterFilter implements Filter {
	Properties pro = new Properties();
	String filePath;
	File file;
	
	public void init(FilterConfig fConfig) throws ServletException {
		String fileName = fConfig.getInitParameter("fileName");
		ServletContext application = fConfig.getServletContext();
		filePath = application.getRealPath("/");
		file = new File(filePath+"/"+fileName);
		
		try {
			if(!file.exists())file.createNewFile();
			//이미 파일은 생성된 상태
			//~.properties 파일을 로딩해서 자료구조 properties 객체에 담아야함
			pro.load(new BufferedInputStream(new FileInputStream(file)));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}//init 끝
	
	/**
	 * - 병렬처리 프로세스를 분산시켜 좀더 빠르게 작업을 수행 할 수 있도록 
	 * 	Executor를 사용
	 * - jdk 1.5에 추가됨
	 * - 기본 스레드에 대한 부분만 제공한다.
	 * - Executor의 구현체 ExecutorService를 이용해 스레드의 생성과 소멸까지 관련된 메소드들 제공
	 */
	
	ExecutorService service = Executors.newSingleThreadExecutor();
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURL().toString();
		
		service.execute(new Runnable() {

			@Override
			public void run() {
				//사전처리
				//요청된 url주소를 얻어온다
				
				
				//properties객체안에 url에 해당하는 key가 있는지 확인.
				String value = pro.getProperty(url);
				
				//있으면 밸류+1 없으면 1로 셋업
				if(value==null) {
					pro.setProperty(url, "1");
				}else {
					int count = Integer.parseInt(pro.getProperty(url));
					count++;
					pro.setProperty(url, count+"");
				}
				
				//파일에 저장.
				try {
					pro.store(new FileOutputStream(file), "");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		
		
		
		chain.doFilter(request, response);
		//사후처리
	}
	
	
	public void destroy() {
		service.shutdown(); //모든 스레드풀에 있던 스레드를 실행하고 하던 작업을 모두 완료하고 종료
	}

	
	

	

}
