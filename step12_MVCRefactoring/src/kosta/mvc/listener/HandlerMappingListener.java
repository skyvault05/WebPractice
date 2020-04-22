package kosta.mvc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kosta.mvc.controller.Controller;

/**
 * 사용자 요청에 해당하는 key에 따른 객체를 미리 생성, Map에 저장해 Application Scope에 attribute로 넣음
 *
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {
    
	
	public void contextInitialized(ServletContextEvent sce)  { 
		ServletContext application = sce.getServletContext();
        Map<String, Controller> map = new HashMap<>();        
        Properties prop = null;
        
        //key에 해당하는 classname을 관리하는 properties 문서로딩
        ResourceBundle rb = ResourceBundle.getBundle(application.getInitParameter("fileName"));
        Set<String> keys = rb.keySet();
        
        try {
	        for(String key : keys) {
	        	String value = rb.getString(key);
	        	Controller controller = (Controller) Class.forName(value).newInstance();
	        	map.put(key, controller);
	        	System.out.println(key);
	        }
	        application.setAttribute("map", map);
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        
   }

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }



	
}
