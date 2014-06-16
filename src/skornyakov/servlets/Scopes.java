package skornyakov.servlets;

import org.springframework.web.context.support.XmlWebApplicationContext;
import skornyakov.beans.spring.PrototypeBean;
import skornyakov.beans.spring.SingletonBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
     * response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        XmlWebApplicationContext context = (XmlWebApplicationContext) getServletContext()
                .getAttribute("springXmlWebApplicationContext");

        PrototypeBean pb = (PrototypeBean) context.getBean("prototypeBean");
        SingletonBean sb = (SingletonBean) context.getBean("singletonBean");

        response.setContentType("text/plain");
        pw.println("Prototype scoped bean value: " + pb.getValue());
        pw.println("Singleton scoped bean value: " + sb.getValue());
        pw.close();

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
