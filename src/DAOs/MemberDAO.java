package DAOs;

import java.io.*;
import java.sql.*;
import java.util.*;
import Club.Member;

public class MemberDAO {
	
	private Connection conn;
	
	public MemberDAO() throws Exception {
		
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
	
	public List<Member> getAllMembers() throws Exception {
		List<Member> members = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM member");
			
			while (rs.next()) {
				Member temp = convertRowToMember(rs);
				members.add(temp);
			}
			
			return members;
			
		} finally {
		
			close(stmt, rs);
			
		}
	}
	
	public List<Member> searchMembers(String lastName) throws Exception {
		List<Member> members = new ArrayList<>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			lastName += "%";
			stmt = conn.prepareStatement("SELECT * FROM member WHERE last_name like ?");
			
			stmt.setString(1, lastName);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Member temp = convertRowToMember(rs);
				members.add(temp);
			}
			
			return members;
			
		} finally {
		
			close(stmt, rs);
			
		}
	}
	
	
	public List<Member> searchMembers(int id) throws Exception {
		List<Member> members = new ArrayList<>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("SELECT * FROM member WHERE member_id = ?");
			
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Member temp = convertRowToMember(rs);
				members.add(temp);
			}
			
			return members;
			
		} finally {
		
			close(stmt, rs);
			
		}
	}
	
	private Member convertRowToMember(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("member_id");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		String email = rs.getString("email");
		String major = rs.getString("major");
		String status = rs.getString("status");
		
		Member temp = new Member(id, firstName, lastName, email, major, status);
		
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
		MemberDAO dao = new MemberDAO();
		System.out.println(dao.getAllMembers());
		System.out.println(dao.searchMembers("Crutch"));
		System.out.println(dao.searchMembers(4));
	}
	
}
