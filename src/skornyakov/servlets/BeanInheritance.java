package skornyakov.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.XmlWebApplicationContext;

import skornyakov.beans.spring.CitizenBean;
import skornyakov.beans.spring.PersonBean;

/**
 * Servlet implementation class BeanInheritance
 */
@WebServlet("/BeanInheritance")
public class BeanInheritance extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeanInheritance() {
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
	XmlWebApplicationContext context = (XmlWebApplicationContext) getServletContext()
		.getAttribute("springXmlWebApplicationContext");
	PersonBean pb =(PersonBean) context.getBean("person");
	CitizenBean cb = (CitizenBean) context.getBean("citizen");
	response.setContentType("text/plain");
	pw.println(pb.getName());
	pw.println(pb.getMiddleName());
	pw.println(pb.getLastname());
	pw.println(pb.getBirthDate());
	pw.println(cb.getName());
	pw.println(cb.getMiddleName());
	pw.println(cb.getLastname());
	pw.println(cb.getBirthDate());
	pw.println(cb.getCitizenship());
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
