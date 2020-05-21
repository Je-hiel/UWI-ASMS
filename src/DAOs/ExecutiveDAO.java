package DAOs;

import java.io.*;
import java.sql.*;
import java.util.*;
import Executive.*;

public class ExecutiveDAO {
	
	private Connection conn;
	
	public ExecutiveDAO() throws Exception {
		
		// Get database properties
		Properties props = new Properties();
		props.load(new FileInputStream("asms.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String url = props.getProperty("url");
		
		// Connect to database
		conn = DriverManager.getConnection(url, user, password);
		
		System.out.println("DB connection successful to: " + url);
	}
	
	public List<Executive> getAllExecutives() throws Exception {
		List<Executive> executives = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM executive");
			
			while (rs.next()) {
				Executive temp = convertRowToExecutive(rs);
				executives.add(temp);
			}
			
			return executives;
			
		} finally {
		
			close(stmt, rs);
			
		}
	}
	
	public List<Executive> searchExecutives(String lastName) throws Exception {
		List<Executive> executives = new ArrayList<>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			lastName += "%";
			stmt = conn.prepareStatement("SELECT * FROM executive WHERE last_name like ?");
			
			stmt.setString(1, lastName);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Executive temp = convertRowToExecutive(rs);
				executives.add(temp);
			}
			
			return executives;
			
		} finally {
		
			close(stmt, rs);
			
		}
	}
	
	
	public List<Executive> searchExecutives(int id) throws Exception {
		List<Executive> executives = new ArrayList<>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("SELECT * FROM executive WHERE executive_id = ?");
			
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Executive temp = convertRowToExecutive(rs);
				executives.add(temp);
			}
			
			return executives;
			
		} finally {
		
			close(stmt, rs);
			
		}
	}
	
	public Executive login(String lastName, String password) throws Exception {
		Executive executive = null;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("SELECT * FROM executive e JOIN member m ON m.member_id = e.executive_id WHERE m.last_name = ? AND e.password = ?");
			
			stmt.setString(1, lastName);
			stmt.setString(2, password);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				executive = convertRowToExecutive(rs);
			}
			
			return executive;
			
		} finally {
		
			close(stmt, rs);
			
		}
	}
	
	private Executive convertRowToExecutive(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("executive_id");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		String email = rs.getString("email");
		String major = rs.getString("major");
		String status = rs.getString("status");
		String position = rs.getString("position");
		String password = rs.getString("password");
		
		Executive temp;
		
		
		switch (position) {
			case "President":
				temp = new President(id, firstName, lastName, email, major, status, password);
				break;
			case "Secretary":
				temp = new Secretary(id, firstName, lastName, email, major, status, password);
				break;
			case "Treasurer":
				temp = new Treasurer(id, firstName, lastName, email, major, status, password);
				break;
			case "External Affairs Chairperson":
				temp = new EAC(id, firstName, lastName, email, major, status, password);
				break;
			case "Publications Committee Chairperson":
				temp = new PCC(id, firstName, lastName, email, major, status, password);
				break;
			default:
				temp = new President(id, firstName, lastName, email, major, status, password);
				break;
		}
		
		return temp;
	}
	
	private static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		
		if (rs != null) {
			rs.close();
		}
		
		if (stmt != null) {
			
		}
		
		if (conn != null) {
			conn.close();
		}
		
	}
	
	private void close(Statement stmt, ResultSet rs) throws SQLException {
		close(null, stmt, rs);
	}
	
	public static void main(String[] args) throws Exception {
		ExecutiveDAO dao = new ExecutiveDAO();
		System.out.println(dao.getAllExecutives());
		System.out.println(dao.searchExecutives("Crutch"));
		System.out.println(dao.searchExecutives(4));
	}
	
}
