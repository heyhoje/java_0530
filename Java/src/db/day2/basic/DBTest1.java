package db.day2.basic;

import java.sql.*;
import java.util.*;

public class DBTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Connection con = null; // db와 연결해서 연결여부를 알려줌
		
		String url = "jdbc:mysql://localhost:3306/test";
		System.out.print("DB 계정 : "); 
		String dbid = sc.next();// <- 깃에 계정정보가 안남는다.
		System.out.print("DB 비번 : ");
		String dbpw = sc.next();// <- 깃에 계정정보가 안남는다.
//		String dbid = "root";
//		String dbpw = "root";
		
		try {
			//con = DriverManager.getConnection("url-DBMS종류, 주소, DB명", "계정", "비밀번호");
			//con = DriverManager.getConnection("JDBC:mysql://localhost:3306/test", "root", "root");
			con = DriverManager.getConnection(url, dbid, dbpw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("연결 성공!");
		
		
		// insert/delete/update 등 가능
		// stmt / pstmt = 쿼리의 값을 고정/가변(prepared 미리 준비)
		// 혼란을 막기위해 pastmt(이후 ps로 설명됨)
		
		/* INSERT 쿼리
		String sql = "insert into member(me_id, me_pw) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// 회원가입한 아이디와 비번을 입력받음
			System.out.print("ID : ");
			String id = sc.next();
			System.out.print("PW : ");
			String pw = sc.next();
			
			// 쿼리에 있는 ? 대신 입력한 아이디와 비번을 넣어줌(쿼리를 준비)
			// setXXX(index, value) : index는 ?의 위치로 1부터 시작, value는 ? 대신 들어갈 값
			ps.setString(1, id);
			ps.setString(2, pw);
			
			// (쿼리를 실행)
			int resultCount = ps.executeUpdate();
			if(resultCount != 0) {
				System.out.println("회원가입 성공!");
			}else {
				System.out.println("회원가입 실패..");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		/* UPDATE 쿼리
		String sql = "update member set me_board_count = ? where me_id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ?에 들어갈 값을 설정해줘야함.
			System.out.print("ID : ");
			String id = sc.next();
			ps.setString(2, id);
			
			System.out.print("board count : ");
			int count = sc.nextInt();
			ps.setInt(1, count);
			
			int resultCount = ps.executeUpdate(); // 실행이 적용된 행의 갯수. select는 적용안됨. insert/delete/update
			if(resultCount != 0) { // 적용된게 없으면 0, 있으면 적용된 갯수만큼 값으로 나옴
				System.out.println("수정 성공!");
			}else {
				System.out.println("수정 실패..");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} */
		
		
		// SELECT 쿼리
		String sql = "select * from member";
		// String sql = "select me_id, me_pw, me_board_count from member"; // 순서를 모를때는 속성명을 써주면 된다. 
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ? 설정 -> ? 가 없어서 생략
			
			// 쿼리를 실행 - select는 검색 결과를 가져와야함
			ResultSet resultSet = ps.executeQuery(); // member테이블 콘솔창의 표가 resultSet
			// select문은 반복문을 통해서 값을 읽어옴
			while(resultSet.next()) { // 다음행이 있는지 확인, 있으면 하나씩 꺼냄. 속성 순서가 중요
				String id = resultSet.getString(1);
				String pw = resultSet.getString(2);
				int boardCount = resultSet.getInt(3); // (각 열 순서대로 가져옴)
				
				System.out.println(id + " : " + pw + " : " + boardCount);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			// 연결한 connection을 닫아줌 / 연결이 안되서 null 일 수 있기 때문
			if(con != null && !con.isClosed()) {
				con.close();
			}
			sc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
