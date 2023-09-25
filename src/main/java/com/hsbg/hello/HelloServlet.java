package com.hsbg.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hsbg.hello.Policy;
/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, Policy> policyMap;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        policyMap = new HashMap<String,Policy>();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		//writer.println("<h1>Hello " + yourName + "</h1>");
		
		String policyId = request.getParameter("id");
		String customerName = request.getParameter("name");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		System.out.println(policyId);
		System.out.println(customerName);
		System.out.println(address);
		System.out.println(contact);
		
		Policy policy = new Policy();
		policy.setPolicyId(policyId);
		policy.setCustomerName(customerName);
		policy.setContact(contact);
		policy.setAddress(address);
		
		policyMap.put(policyId, policy);
		
		
		writer.println("<script>");

		writer.println("function createPolicy(){");

		writer.println("var form = document.getElementById(\"polcyForm\");");
			
		writer.println("form.action=\"/helloServlet\";");
		writer.println("form.method=\"POST\";");
		writer.println("form.method.type=\"POST\";");
		writer.println("form.submit();");
		writer.println("}");
		writer.println("function updatePolicy(){");
		writer.println("var form = document.getElementById(\"polcyForm\");");
		writer.println("form.action=\"/helloServlet\";");
		writer.println("form.method=\"PUT\";");
		writer.println("form.method.type=\"PUT\";");
		writer.println("form.submit();");
		writer.println("}");
		writer.println("function deletePolicy(){");
		writer.println("var form = document.getElementById(\"polcyForm\");");
		writer.println("form.action=\"/helloServlet\";");
		writer.println("form.method=\"DELETE\";");
		writer.println("form.method.type=\"DELETE\";");
		writer.println("form.submit();");
		writer.println("</script>");
		
		writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Hello World web application</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<form action=\"addpolicy\" id=\"polcyForm\" type=\"POST\">");
		writer.println("<br>");
		writer.println("Enter your ID: <input type=\"text\" name=\"id\" size=\"20\">");
		writer.println("<br>");
		writer.println("Enter your name: <input type=\"text\" name=\"name\" size=\"20\">");
		writer.println("<br>");
		writer.println("Enter your address: <input type=\"text\" name=\"address\" size=\"50\">");
		writer.println("<br>");
		writer.println("Enter your contact: <input type=\"text\" name=\"contact\" size=\"50\">");
		writer.println("<table>");
		writer.println("<thead>");
		writer.println("<tr>");
		writer.println("<th>Policy ID</th>");
		writer.println("<th>Customer Name</th>");
		writer.println("<th>Customer Address</th>");
		writer.println("<th>Contact Number</th>");
		writer.println("</tr>");
		writer.println("</thead>");
		writer.println("<tbody>");
		writer.println("<tr>");
				//INCLUDE LOOP HERE 
		Iterator iterator = policyMap.values().iterator();
		while (iterator.hasNext()) {
			Policy p1 = (Policy)iterator.next();
			writer.println("<td>"+p1.getPolicyId()+"</td>");
			writer.println("<td>"+p1.getCustomerName()+"</td>");
			writer.println("<td>"+p1.getAddress()+"</td>");
			writer.println("<td>"+p1.getContact()+"</td>");
						
		}
		
		writer.println("</tr>");
		writer.println("</tbody>");
		writer.println("</table>");
		writer.println("<input type=\"submit\" value=\"Create Insurance\"  onClick=\"javascript:createPolicy()\"/>");
		writer.println("<input type=\"button\" value=\"Update Insurance\"  onclick=\"javascript:updatePolicy()\"/>");
		writer.println("<input type=\"button\" value=\"Delete Insurance\"  onclick=\"javascript:deletePolicy()\"/>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");

		writer.close();
		
	}

}
