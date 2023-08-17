package db.day1;

import java.sql.*;
import java.util.ArrayList;

public class DBEx1 {

	public static void main(String[] args) throws SQLException {
		//MySQL�� �����ϴ� �ڵ�
		String url = "jdbc:mysql://localhost:3306/test";
		String dbId = "root";
		String dbPw = "root";
	
		Connection con = dbConnect(url, dbId, dbPw);
		
		String id = "ABC123";
		String pw = "root";
		//insertMember(con, id, pw);
		//deleteMember(con, id);
		//updateMember(con, id, 10);
		
		//System.out.println("Signup Success!");
		
		ArrayList<Member> list = getMembers(con);
		for(Member tmp : list) {
			System.out.println(tmp);
		}
		
	}
	
	
	public static int insertMember(Connection con, String id, String pw) throws SQLException {

		// ȸ���߰��ϴ� ����(INSERT)
		// ������ ������ �̿� : select * from member where me_id = 'abc123'
		/* String sql = "insert into member(me_id, me_pw) values('asdasd1', 'asdasd1')";
		Statement stmt = null;
		stmt = con.createStatement();
		stmt.execute(sql); 
		System.out.println("Signup Success!");
		*/
		
		
		// ���� ������ �̿� : select * from member where me_id = ? => ����ǥ�� �´� ���� ���߿� �־���
		String sql = "insert into member(me_id, me_pw) values(?, ?)";
		PreparedStatement pstmt = null; 
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "id");
		pstmt.setString(2, "pw");
		
		//������ ����� ���� ������ ����. MySQL���� ���� ����� x row(s) affected���� x�� �ش�.
		return pstmt.executeUpdate(); //  0�̸� ������ ���� ���Ѱ�, 1�̻��̾����
		
	}
	
	public static int deleteMember(Connection con, String id) throws SQLException {
		
		// ���� ������ �̿� : select * from member where me_id = ? => ����ǥ�� �´� ���� ���߿� �־���
		String sql = "delete from member where me_id = ?";
		PreparedStatement pstmt = null; 
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "id");
		
		//������ ����� ���� ������ ����. MySQL���� ���� ����� x row(s) affected���� x�� �ش�.
		return pstmt.executeUpdate(); //  0�̸� ������ ���� ���Ѱ�, 1�̻��̾����
		
	}
	
	public static int updateMember(Connection con, String id, int count) throws SQLException{
		
		// ���� ������ �̿� : select * from member where me_id = ? => ����ǥ�� �´� ���� ���߿� �־���
		String sql = "update member set me_board_count = ? where me_id = ?";
		PreparedStatement pstmt = null; 
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, count);
		pstmt.setString(2, id);
		
		
		//������ ����� ���� ������ ����. MySQL���� ���� ����� x row(s) affected���� x�� �ش�.
		return pstmt.executeUpdate(); //  0�̸� ������ ���� ���Ѱ�, 1�̻��̾����
		
	}
	
	public static ArrayList<Member> getMembers(Connection con) throws SQLException{
		ArrayList<Member> list = new ArrayList<>();
		
		String sql = "select * from member";
		ResultSet rs = null;
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			String me_id = rs.getString(1);
			String me_pw = rs.getString(2);
			int me_board_count = rs.getInt(3);
			
			// System.out.println("ID : " + me_id + ", board count : " + me_board_count);
			Member member = new Member(me_id, me_pw, me_board_count);
			list.add(member);
		}
		return list;
		
	}
		
	//MySQL�� �����ϴ� �ڵ�
	public static Connection dbConnect(String url, String id, String pw) {
		Connection con = null;	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // * �ڹ� ������ �������� �����Ҷ� �� �����������, �ڹٹ����� ������ �ڵ����� �ҷ����� ������ �����ص���
													   // �� �̸��� ���� Ŭ������ �ִ��� üũ => �ش� Ŭ������ �޸𸮿� �ø�
			//url : jdbc:dbms����:url�ּ�
			con = DriverManager.getConnection(url, id, pw); // * 
		} catch (SQLException e) {
			System.out.println("Connection Fail");
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found!");
			return null;
		}
		System.out.println("Connection Success!");
		
		return con;
		
	}
}
