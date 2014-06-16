package skornyakov.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.XmlWebApplicationContext;

import skornyakov.beans.spring.PrototypeBean;

/**
 * Servlet implementation class Scopes
 */
@WebServlet("/Scopes")
public class Scopes extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Scopes() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	PrintWriter pw = response.getWriter();
	XmlWebApplicationContext context = new XmlWebApplicationContext();
	context.setConfigLocation("WEB-INF/Beans.xml");
	context.setServletContext(getServletContext());
	context.refresh();
	
	PrototypeBean pb = (PrototypeBean) context.getBean("prototypeBean");
	response.setContentType("text/plain");
	pw.println(pb.getValue());
	pw.close();
	
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
    }

}
