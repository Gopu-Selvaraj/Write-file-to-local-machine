package a.b.c;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/WriteServlet")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
        PrintWriter PW = response.getWriter();  
          
        String name = request.getParameter("name");  
        String password = request.getParameter("password");  
        String email = request.getParameter("email");  
        String country = request.getParameter("country");
        String gender = request.getParameter("gender");
        
        String LocalPath = "WriteFile";
        
            	try {
	            		// Create file path
	                    String FilePath = getServletContext().getRealPath("") + File.separator + LocalPath;
	        			
	                    File FileDir = new File(FilePath);
	                	
	                    if (!FileDir.exists())
		                    {
	                    		FileDir.mkdir();
		                    }
	                    
	                    FileWriter writer = new FileWriter(FilePath + File.separator + "MyFile.txt",true);
	                    writer.write(" ***** Details Updated ***** ");
	                    writer.write("\r\n");
	                    writer.write(name);
	        			// write new line
	        			writer.write("\r\n");
	        			writer.write(password);
	        			writer.write("\r\n");
	        			writer.write(email);
	        			writer.write("\r\n");
	        			writer.write(country);
	        			writer.write("\r\n");
	        			writer.write(gender);
	        			writer.write("\r\n");
	        				        			
	                    PW.println("<center>File Uploaded Successfully</center>");
	                    writer.flush();
	                    writer.close();
            	}

            	
            	catch (Exception ex)
            	{
            			 request.setAttribute("Sorry", "There was an error:" + ex.getMessage());
            			 PW.println(ex + "There was an error");
            	}

        
	}
}


