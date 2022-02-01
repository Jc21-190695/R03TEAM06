import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/kaimono")
public class kaimonolist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String driverName = "com.mysql.jdbc.Driver";
		final String url = "jdbc:mysql://192.168.54.194:3306/webapp";
		final String id = "webapp";
		final String pass = "webapp";

		try {
			HttpSession session = request.getSession();
			String userid = (String)session.getAttribute("userid");
			
			Class.forName(driverName);
			Connection connection=DriverManager.getConnection(url,id,pass);
			PreparedStatement st =
					connection.prepareStatement(
							"select * from comm_table where sort_id=1 and add_id=2 and user_id=?"
						);
			st.setString(1, userid);
			PreparedStatement at =
					connection.prepareStatement(
							"select * from comm_table where sort_id=2 and add_id=2 and user_id=?"
						);
			at.setString(1, userid);
			
			ResultSet result1 = st.executeQuery();
			ResultSet result2 = at.executeQuery();

			List<String[]> list1 = new ArrayList<>();
			List<String[]> list2 = new ArrayList<>();
			
			while( result1.next() == true) {
				String[] s = new String[4];
				s[0]=result1.getString("comm_id");
				s[1]=result1.getString("comm_name");
				s[2]=result1.getString("add_id");
				s[3]=result1.getString("count");
				

				list1.add(s);
			}
			while( result2.next() == true) {
				String[] s = new String[4];

				s[0]=result2.getString("comm_id");
				s[1]=result2.getString("comm_name");
				s[2]=result2.getString("add_id");
				s[3]=result2.getString("count");
				

				list2.add(s);
			}
			
			request.setAttribute("list1",list1);
			request.setAttribute("list2",list2);
			request.getRequestDispatcher("/kaimono.jsp")
			.forward(request,response);
			
		} catch (ClassNotFoundException e ) {
			e.printStackTrace();
		} catch (SQLException e ) {
			e.printStackTrace();
		}
	}
}
