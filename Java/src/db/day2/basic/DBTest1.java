package db.day2.basic;

import java.sql.*;
import java.util.*;

public class DBTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Connection con = null; // db�� �����ؼ� ���Ῡ�θ� �˷���
		
		String url = "jdbc:mysql://localhost:3306/test";
		System.out.print("DB ���� : "); 
		String dbid = sc.next();// <- �꿡 ���������� �ȳ��´�.
		System.out.print("DB ��� : ");
		String dbpw = sc.next();// <- �꿡 ���������� �ȳ��´�.
//		String dbid = "root";
//		String dbpw = "root";
		
		try {
			//con = DriverManager.getConnection("url-DBMS����, �ּ�, DB��", "����", "��й�ȣ");
			//con = DriverManager.getConnection("JDBC:mysql://localhost:3306/test", "root", "root");
			con = DriverManager.getConnection(url, dbid, dbpw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("���� ����!");
		
		
		// insert/delete/update �� ����
		// stmt / pstmt = ������ ���� ����/����(prepared �̸� �غ�)
		// ȥ���� �������� pastmt(���� ps�� �����)
		
		/* INSERT ����
		String sql = "insert into member(me_id, me_pw) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ȸ�������� ���̵�� ����� �Է¹���
			System.out.print("ID : ");
			String id = sc.next();
			System.out.print("PW : ");
			String pw = sc.next();
			
			// ������ �ִ� ? ��� �Է��� ���̵�� ����� �־���(������ �غ�)
			// setXXX(index, value) : index�� ?�� ��ġ�� 1���� ����, value�� ? ��� �� ��
			ps.setString(1, id);
			ps.setString(2, pw);
			
			// (������ ����)
			int resultCount = ps.executeUpdate();
			if(resultCount != 0) {
				System.out.println("ȸ������ ����!");
			}else {
				System.out.println("ȸ������ ����..");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		/* UPDATE ����
		String sql = "update member set me_board_count = ? where me_id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ?�� �� ���� �����������.
			System.out.print("ID : ");
			String id = sc.next();
			ps.setString(2, id);
			
			System.out.print("board count : ");
			int count = sc.nextInt();
			ps.setInt(1, count);
			
			int resultCount = ps.executeUpdate(); // ������ ����� ���� ����. select�� ����ȵ�. insert/delete/update
			if(resultCount != 0) { // ����Ȱ� ������ 0, ������ ����� ������ŭ ������ ����
				System.out.println("���� ����!");
			}else {
				System.out.println("���� ����..");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} */
		
		
		// SELECT ����
		String sql = "select * from member";
		// String sql = "select me_id, me_pw, me_board_count from member"; // ������ �𸦶��� �Ӽ����� ���ָ� �ȴ�. 
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ? ���� -> ? �� ��� ����
			
			// ������ ���� - select�� �˻� ����� �����;���
			ResultSet resultSet = ps.executeQuery(); // member���̺� �ܼ�â�� ǥ�� resultSet
			// select���� �ݺ����� ���ؼ� ���� �о��
			while(resultSet.next()) { // �������� �ִ��� Ȯ��, ������ �ϳ��� ����. �Ӽ� ������ �߿�
				String id = resultSet.getString(1);
				String pw = resultSet.getString(2);
				int boardCount = resultSet.getInt(3); // (�� �� ������� ������)
				
				System.out.println(id + " : " + pw + " : " + boardCount);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			// ������ connection�� �ݾ��� / ������ �ȵǼ� null �� �� �ֱ� ����
			if(con != null && !con.isClosed()) {
				con.close();
			}
			sc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
