package db.day2.board.service;

public interface MemberService { // 서비스는 특별히 할게 없음. Add method? 만해주면 됨. 

	boolean signup(String id, String pw);

	boolean withdraw(String id, String pw);

}
