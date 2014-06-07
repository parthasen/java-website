package skornyakov.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by A on 07.06.2014.
 */
@MultipartConfig
public class Upload extends HttpServlet {
    private String fileName;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = request.getParameter("destination");
        Part filePart = request.getPart("file");
        String fileName = getFileName(filePart);
        InputStream fileContent = null;
        try {
            fileContent = filePart.getInputStream();
            File fileOnDisk = new File(destination + File.separator + fileName);
            if (!fileOnDisk.exists()) {
                fileOnDisk.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(fileOnDisk);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = fileContent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.close();
            fileContent.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
