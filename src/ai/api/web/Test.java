package ai.api.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ai.api.GsonFactory;
import request.GoogleRequest;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private final Gson gson = GsonFactory.getDefaultFactory().getGson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 StringBuilder sb = new StringBuilder();
         String s;
         while ((s = request.getReader().readLine()) != null) {
             sb.append(s);
         }

         GoogleRequest googlerequest = (GoogleRequest) gson.fromJson(sb.toString(), GoogleRequest.class);
         
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String responseStr = "{\r\n" + 
		"  \"fulfillmentText\": \"You asked me to,  "+googlerequest.getQueryResult().getQueryText()+". Here deivice name is, " +googlerequest.getQueryResult().getParameters().get("DeviceName")+". \",\r\n" + 
		"  \"outputContexts\": []\r\n" + 
		"}";
        out.print(responseStr );
        out.flush();   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
