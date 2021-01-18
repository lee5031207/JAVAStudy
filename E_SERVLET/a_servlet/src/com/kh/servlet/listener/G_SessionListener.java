package com.kh.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class G_SessionListener
 *
 */
@WebListener
public class G_SessionListener implements ServletContextListener, HttpSessionAttributeListener {
	
	
    //ServletContext 
	//servlet과 servletContainer가 상호작용하기 위해 필요한 메서드를 제공해주는 객체
	//하나의 웹 어플리케이션당 하나의 ServletContext만 존재
	// 즉, 웹 어플리케이션의 모든 쓰레드와 서블릿이 공유하는 객체, application scope
	// application scope : 서버가 실행될 때 메모리에 올라가서, 서버가 종료될 대 파괴
	//따라서 ServletContext에 저장한 정보는 서버가 종료될 때 까지 삭제되지 않는다.
	
	//Servlet Scope 
	//1. page Scope : 해당 페이지에서만 유효한 scope
	//2. request Scope : 요청에 의해 생성되고 응답이 완료되면 종료되는 scope
	//3. session Scope : 요청에 의해 생성되고, 클라이언트의 브라우저가 종료되면 파괴
	//4. application Scope : 서버가 실행될 때 생성되고, 서버가 종료될 때 파괴
	
	private ServletContext context;
	
    public G_SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	if(arg0.getName().equals("nick")) {
    		int count = (int)context.getAttribute("userCount");
            context.setAttribute("userCount", ++count);
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
    	if(arg0.getName().equals("nick")) {
	         int count = (int) context.getAttribute("userCount");
	         context.setAttribute("userCount", --count);
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	context = arg0.getServletContext();
    	//사용자 수를 카운팅하기 위한 속성을 추가
    	context.setAttribute("userCount", 0);
    }
	
}
