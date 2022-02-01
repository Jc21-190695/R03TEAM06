import java.io.IOException;
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
@MultipartConfig

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
			/*Part part=request.getPart("file");
			//ファイル名を取得
			//String filename=part.getSubmittedFileName();//ie対応が不要な場合
			String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
			
			
			PreparedStatement at = con.prepareStatement(
					"insert into file_table values(?)");
			
			at.setString(1,"filename");*/
			
			PreparedStatement st = con.prepareStatement(
					"insert into comm_table values(null,?,?,?,1,?)");
			
			st.setString(1, userid);
			if(comm.equals("niti")) {
				st.setInt(2,  1);	
			}else {
				st.setInt(2,  2);	
			}
			
			st.setString(3,  name);
			st.setString(4,count);
			
			
			
			int line = st.executeUpdate();
			
			if (line > 0) {
				
				out.println("追加しました。");
			}
			
			st.close();
			con.close();
			} catch (Exception e) {
				out.println("<pre>");
				e.printStackTrace(out);
			}
	}
	
}