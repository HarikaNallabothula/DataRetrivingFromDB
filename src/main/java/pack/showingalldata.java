package pack;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showing")
public class showingalldata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		out.print("<table border='1'><tr><th>equip_id</th><th>type</th><th>color</th><th>location</th><th>install_date</th>");
		out.print("<h1>THIS IS ALL THE DATA PRESENT IN DB</h1>");

		try {
			Connection con;
			con=HelperClass.putConnection();
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select*from playground");
		while(rs.next()) {

		              out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getDate(5)+"</td></tr>");

		   }}
		catch(Exception e) {
			e.printStackTrace();
			}
		out.print("</table>");
		out.println("<a href=showing.html>SHOW ALL DATA IN DATABASE</a>");
		 }
		}