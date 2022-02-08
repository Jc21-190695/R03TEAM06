import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.DataSource;

//データベース追加用サーブレット　

@WebServlet("/tuika")
@MultipartConfig(location = "")

public class Tuika extends HttpServlet {
	
	public void doPost(
			HttpServletRequest request, HttpServletResponse response
		) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup(
					"java:/comp/env/jdbc/webapp");
			Connection con = ds.getConnection();
			String name = request.getParameter("name");
			String comm = request.getParameter("comm");
			String count = request.getParameter("count");
			
			HttpSession session = request.getSession();
			String userid = (String)session.getAttribute("userid");
			Part part=request.getPart("file");
			InputStream inputStream = part.getInputStream();
			
			byte[] bt = convertInputStreamToArray(inputStream);
			ImageBean imageBean = new ImageBean();
			imageBean.setImage(bt);
			
			
			PreparedStatement at = con.prepareStatement(
					"insert into file_table values(null,?)");
			
			at.setBinaryStream(1, new ByteArrayInputStream(bt));
            at.executeUpdate();
			
			PreparedStatement st = con.prepareStatement(
					"insert into comm_table values(null,?,?,?,1,?)");
			
			st.setString(1, userid);
			if(comm.equals("niti")) {
				st.setInt(2,  2);	
			}else {
				st.setInt(2,  1);	
			}
			
			st.setString(3,  name);
			st.setString(4,count);
			
			
			
			int line = st.executeUpdate();
			
			if (line > 0) {
				
				response.sendRedirect("http://localhost:8080/R03Team06/tuikasimasita.jsp");
			}
			
			st.close();
			con.close();
			} catch (Exception e) {
				out.println("<pre>");
				e.printStackTrace(out);
			}
	}
	public static byte[] convertInputStreamToArray(InputStream inputStream) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int nRead;
		byte[] data = new byte[16777215];	
		while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}
		return buffer.toByteArray();
	}
	
}