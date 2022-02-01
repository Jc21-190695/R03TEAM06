import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/list")

public class listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String driverName = "com.mysql.jdbc.Driver";
		final String url = "jdbc:mysql://192.168.54.194:3306/webapp";
		final String id = "webapp";
		final String pass = "webapp";

		try {
			//↓↓セッション取得　emailをとってくる↓↓
			
			HttpSession session = request.getSession();
			String email = (String)session.getAttribute("email");
			System.out.println(email);
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup(
					"java:/comp/env/jdbc/webapp");
			Connection con = ds.getConnection();
			PreparedStatement st = con.prepareStatement(
					"insert ignore into user_table values(null,2,?)");
			st.setString(1,  email);
			st.executeUpdate();
			st.close();

			//↑↑メールアドレスをデータベースに追加↑↑
			
			//↓↓自分のメールアドレスのidを取得↓↓
			

			
			PreparedStatement st20 = con.prepareStatement(
					"select user_id from user_table where mail_address=?");
			
			st20.setString(1, email);

			ResultSet result10 = st20.executeQuery();
			result10.next();
			String userid = result10.getString("user_id");
			System.out.println(userid);

			st20.close();
			
			session.setAttribute("userid", userid);
			
			Class.forName(driverName);
			Connection connection=DriverManager.getConnection(url,id,pass);
			PreparedStatement st1 =
					connection.prepareStatement(
							"select * from comm_table where sort_id=1 and add_id=1 and user_id=?"
						);
			st1.setString(1, userid);
			PreparedStatement st2 =
					connection.prepareStatement(
							"select * from comm_table where sort_id=1 and add_id=2 and user_id=?"
						);
			st2.setString(1, userid);
			PreparedStatement at1 =
					connection.prepareStatement(
							"select * from comm_table where sort_id=2 and add_id=1 and user_id=?"
						);
			at1.setString(1, userid);
			PreparedStatement at2 =
					connection.prepareStatement(
							"select * from comm_table where sort_id=2 and add_id=2 and user_id=?"
						);
			at2.setString(1, userid);
			

			
			
			ResultSet result1 = st1.executeQuery();
			ResultSet result2 = st2.executeQuery();
			ResultSet result3 = at1.executeQuery();
			ResultSet result4 = at2.executeQuery();

			List<String[]> list1 = new ArrayList<>();
			List<String[]> list2 = new ArrayList<>();
			List<String[]> list3 = new ArrayList<>();
			List<String[]> list4 = new ArrayList<>();
			
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
			while( result3.next() == true) {
				String[] s = new String[4];
				s[0]=result3.getString("comm_id");
				s[1]=result3.getString("comm_name");
				s[2]=result3.getString("add_id");
				s[3]=result3.getString("count");
				

				list3.add(s);
			}
			while( result4.next() == true) {
				String[] s = new String[4];

				s[0]=result4.getString("comm_id");
				s[1]=result4.getString("comm_name");
				s[2]=result4.getString("add_id");
				s[3]=result4.getString("count");
				

				list4.add(s);
			}

			request.setAttribute("list1",list1);
			request.setAttribute("list2",list2);
			request.setAttribute("list3",list3);
			request.setAttribute("list4",list4);
			request.getRequestDispatcher("/list.jsp")
			.forward(request,response);
			
			con.close();
		/*} catch (ClassNotFoundException e ) {
			e.printStackTrace();
		} catch (SQLException e ) {
			e.printStackTrace();
		}*/
		} catch (Exception e) {
			e.printStackTrace();
	}
	}
}
