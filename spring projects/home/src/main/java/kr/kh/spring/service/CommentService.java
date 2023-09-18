package kr.kh.spring.service;

import kr.kh.spring.vo.CommentVO;
import kr.kh.spring.vo.MemberVO;

public interface CommentService {

	boolean insertComment(CommentVO comment);

}
