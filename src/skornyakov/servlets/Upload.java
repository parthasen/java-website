package skornyakov.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Created by A on 07.06.2014.
 */
@MultipartConfig
public class Upload extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	String destination = System.getProperty("user.home");
	Part filePart = request.getPart("file");
	String fileName = getFileName(filePart);
	InputStream fileInputStream = null;
	try {
	    fileInputStream = filePart.getInputStream();
	    File file = new File(destination + File.separator + fileName);
	    if (!file.exists()) {
		file.createNewFile();
	    }
	    OutputStream fileOutputStream = new FileOutputStream(file);
	    int read = 0;
	    byte[] bytes = new byte[1024];
	    while ((read = fileInputStream.read(bytes)) != -1) {
		fileOutputStream.write(bytes, 0, read);
	    }
	    fileOutputStream.close();
	    fileInputStream.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	FileWriter fw = new FileWriter(destination+File.separator+"request.txt");
	fw.write(request.getParts().toString());
	fw.close();
	String location = this.getServletContext().getContextPath()
		+ "/index.jsp";
	response.sendRedirect(location);
    }

    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

    }

    public String getFileName(Part part) {
	for (String content : part.getHeader("content-disposition").split(";")) {
	    if (content.trim().startsWith("filename")) {
		return content.substring(content.indexOf('=') + 1).trim()
			.replace("\"", "");
	    }
	}
	return null;
    }
}
