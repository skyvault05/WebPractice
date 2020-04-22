package kosta.mvc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kosta.mvc.controller.Controller;

/**
 * Application Lifecycle Listener implementation class ActionMappingListener
 *
 */
@WebListener
public class ActionMappingListener implements ServletContextListener {
	
    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext application = sce.getServletContext();
         Map<String, Controller> map = new HashMap<>();
         String fileName = application.getInitParameter("fileName");
         
         ResourceBundle rb = ResourceBundle.getBundle(fileName);
         Set<String> keys = rb.keySet();
         try {
	         for(String key : keys) {
	        	 String c = rb.getString(key);
	        	 Controller con = (Controller) Class.forName(c).newInstance();
	        	 map.put(key, con);
	         }
	         application.setAttribute("map", map);
         }catch (Exception e) {
        	 e.printStackTrace();
         }
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }


	
}
