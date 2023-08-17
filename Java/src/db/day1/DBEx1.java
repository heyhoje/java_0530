package db.day1;

import java.sql.*;
import java.util.ArrayList;

public class DBEx1 {

	public static void main(String[] args) throws SQLException {
		//MySQL과 연결하는 코드
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

		// 회원추가하는 쿼리(INSERT)
		// 고정된 쿼리를 이용 : select * from member where me_id = 'abc123'
		/* String sql = "insert into member(me_id, me_pw) values('asdasd1', 'asdasd1')";
		Statement stmt = null;
		stmt = con.createStatement();
		stmt.execute(sql); 
		System.out.println("Signup Success!");
		*/
		
		
		// 가변 쿼리를 이용 : select * from member where me_id = ? => 물음표에 맞는 값을 나중에 넣어줌
		String sql = "insert into member(me_id, me_pw) values(?, ?)";
		PreparedStatement pstmt = null; 
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "id");
		pstmt.setString(2, "pw");
		
		//쿼리가 적용된 행의 개수를 리턴. MySQL에서 쿼리 실행시 x row(s) affected에서 x에 해당.
		return pstmt.executeUpdate(); //  0이면 쿼리가 동작 안한거, 1이상이어야함
		
	}
	
	public static int deleteMember(Connection con, String id) throws SQLException {
		
		// 가변 쿼리를 이용 : select * from member where me_id = ? => 물음표에 맞는 값을 나중에 넣어줌
		String sql = "delete from member where me_id = ?";
		PreparedStatement pstmt = null; 
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "id");
		
		//쿼리가 적용된 행의 개수를 리턴. MySQL에서 쿼리 실행시 x row(s) affected에서 x에 해당.
		return pstmt.executeUpdate(); //  0이면 쿼리가 동작 안한거, 1이상이어야함
		
	}
	
	public static int updateMember(Connection con, String id, int count) throws SQLException{
		
		// 가변 쿼리를 이용 : select * from member where me_id = ? => 물음표에 맞는 값을 나중에 넣어줌
		String sql = "update member set me_board_count = ? where me_id = ?";
		PreparedStatement pstmt = null; 
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, count);
		pstmt.setString(2, id);
		
		
		//쿼리가 적용된 행의 개수를 리턴. MySQL에서 쿼리 실행시 x row(s) affected에서 x에 해당.
		return pstmt.executeUpdate(); //  0이면 쿼리가 동작 안한거, 1이상이어야함
		
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
		
	//MySQL과 연결하는 코드
	public static Connection dbConnect(String url, String id, String pw) {
		Connection con = null;	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // * 자바 버전이 낮은경우는 연결할때 꼭 써줘야하지만, 자바버전이 높으면 자동으로 불러오기 떄문에 생략해도됨
													   // 이 이름을 가진 클래스가 있는지 체크 => 해당 클래스를 메모리에 올림
			//url : jdbc:dbms종류:url주소
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
