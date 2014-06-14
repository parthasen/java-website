package skornyakov.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import skornyakov.beans.spring.HelloMessage;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by A on 07.06.2014.
 */
public class TestServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        String beanName = "helloMessage";
	HelloMessage hm = (HelloMessage)context.getBean(beanName);
	String message = hm.getMessage();
        pw.println("<html><head><title>Test</title></head><body><h1>Test Servlet</h1><h2>"
        	+ message +
        	"</h2></body></html>");
        pw.close();
    }
}
