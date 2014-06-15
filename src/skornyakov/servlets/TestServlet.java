package skornyakov.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.XmlWebApplicationContext;

import skornyakov.beans.spring.BeanWithDestrMethod;
import skornyakov.beans.spring.BeanWithInitMethod;
import skornyakov.beans.spring.HelloMessage;
import skornyakov.beans.spring.LazyBean;

/**
 * Created by A on 07.06.2014.
 */
public class TestServlet extends HttpServlet {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	PrintWriter pw = response.getWriter();

	XmlWebApplicationContext context = new XmlWebApplicationContext();
	context.setConfigLocation("/WEB-INF/Beans.xml");
	context.setServletContext(this.getServletContext());
	context.refresh();

	ArrayList<String> messages = new ArrayList<String>();

	String beanName = "helloMessage";
	HelloMessage hm = (HelloMessage) context.getBean(beanName);
	messages.add(hm.getMessage());

	beanName = "lazyBeanExample";
	LazyBean lb = (LazyBean) context.getBean(beanName);
	messages.add(lb.getMessage());

	beanName = "beanWithInitMethod";
	BeanWithInitMethod bwim = (BeanWithInitMethod) context
		.getBean(beanName);
	messages.add(bwim.getMessage());
	
	beanName = "beanWithDestrMethod";
	BeanWithDestrMethod bwdm = (BeanWithDestrMethod)context.getBean(beanName);
	bwdm

	pw.println("<html><head><title>Test</title></head><body><h1>Test Servlet</h1>");
	for (String message : messages) {
	    pw.println("<h2>" + message + "</h2>");
	}
	pw.println("</body></html>");
	pw.close();
    }
}
