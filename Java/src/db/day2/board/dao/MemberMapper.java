package db.day2.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.day2.board.vo.MemberVO;

public class MemberMapper implements MemberDAO{
	// DAO를 구현한 구현클래스
	// 컨트롤러 > 서비스/임플 > 다오/매퍼
	// 오른쪽으로 일을 시키는 구조. ㄴDB에 접근하는 작업을 DAO가 해줌(insert/delete/update)
	// vo는 데이터를 쉽게 주고받기 위해서 클래스로 만든것 (vo패키지)

	private Connection con;
	
	public MemberMapper(Connection con) {
		this.con = con;
	}

	@Override
	public MemberVO getMember(String id) {
		// 쿼리를 생성
		String sql = "select me_id, me_pw, me_board_count from member where me_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery(); // select문이라
			
			while(rs.next()) { // 회원정보 가져올때 양식처럼
				String me_id = rs.getString(1);
				String me_pw = rs.getString(2);
				int me_board_count = rs.getInt(3);
				return new MemberVO(me_id, me_pw, me_board_count);
			}
		} catch (SQLException e) {
			return null;
		}
		return null;
	}

	@Override
	public void insertMember(String id, String pw) {
		// 쿼리를 생성
			String sql = "insert into member(me_id, me_pw) values(?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				// ?? 설정
				ps.setString(1, id);
				ps.setString(2, pw);
				// (insert) 실행
				ps.executeUpdate();
			} catch (SQLException e) { 
				
			}
					
	}

	@Override
	public void deleteMember(String id) {
		String sql = "delete from member where me_id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ? 설정
			ps.setString(1, id);
			// 실행
			ps.executeUpdate();
		} catch (SQLException e) {

		}
	}
}
// 회원가입 / 탈퇴 - board
// 게시글 등록 수정 삭제 - board2
