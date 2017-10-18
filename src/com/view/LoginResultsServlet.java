package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.servlets.StudentsInfoBean;
import com.mysql.jdbc.Driver;

public class LoginResultsServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{	StudentsInfoBean student = (StudentsInfoBean)req.getAttribute("student");
		PrintWriter out=resp.getWriter();
//			process the result
		if(student!=null)
		{
			int regno=student.getRegno();
			String fnm=student.getFirstname();
			String mnm=student.getGmiddlename();
			String lnm=student.getGlastname();
			String gfnm=student.getGfirstname();
			String gmnm=student.getGmiddlename();
			String glnm=student.getGlastname();
			
			String isAdmin=student.getIsadmin();
			
		
			out.print("<html>"
					+ "<head>"
					+ "<title>Display all Students</title>"
					+ "</head>"
					+ "<body>"
					+ "<table border='1' width=00%>"
					+"<tr>"
					+ "<td>"
					+ "Regno"
					+ "</td>"
					+ "<td>"
					+ "firstname"
					+ "</td>"
					
					+ "<td>"
					+ "MiddleName"
					+ "</td>"
					+ "<td>"
					+ "LastName"
					+ "</td>"
					+ "<td>"
					+ "GFirstName"
					+ "</td>"
					+ "<td>"
					+ "GMiddleNAme"
					+ "</td>"
					+ "<td>"
					+ "GLASTNAME"
					+ "</td>"
					+ "<td>"
					+ "isAdmin"
					+ "</td>"
					+"<td>"
				    + "</tr>"
					+ "<tr>"
					+ "<td>"
					+regno
					+"</td>"
					+ "<td>"
					+ fnm
					+ "</td>"
					+ "<td>"
					+ mnm
					+ "</td>"
					+ "<td>"
					+ lnm
					+ "</td>"
					+ "<td>"
					+ gfnm
					+ "</td>"
					+ "<td>"
					+  gmnm
					+ "</td>"
					+ "<td>"
					+ glnm
					+ "</td>"
					+ "<td>"
					+ isAdmin
					+ "</td>"
					+ "</tr>"
					+ "");
			
						/*+ "<td>lastname</td>"
						+ lnm
						+ "<td>gfirstname</td>"
						+ gfnm
						+ "<td>gmiddlename</td>"
						+ gmnm
						+ "<th>glastname</th>"
						+ glnm
						+ "<th>isAdmin</th>"
						+ isAdmin
						+ "<th>password</th>"
						+ pwd
						+ "<th>Delete</th>";*/
						/*if (isAdmin.equals("Y")) {
							output=output+"<tr>"
									+ "<a href=\"http://localhost:8080/studentsApp/delete?regno=\"+regno+\">delete</a>"
									+ "</tr>";
						}*/
						
						if(isAdmin.equals("Y")) {
							out.print("<tr>"
									+ "<a href=\"http://localhost:8080/studentsApp/ViewAllStudentsController\">View All Students</a>"
									+ "</tr>");
						}
                }
		else {
			out.print("Enter Valid Data");
		}


}

}