package kr.kh.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<h1>게시글조회</h1>").append(request.getContextPath());
		
		// 현재 페이지 정보인 Criteria
		int page = 1;
		int perPageNum = 3;
		try {
			page = Integer.parseInt(request.getParameter("page"));
			page = page < 1 ? 1 : page;
		}catch(Exception e) {}
		
		// 전체 게시글 수
		
		// 페이지네이션에서 최대 페이지 개수
		int displayPageNum = 3;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
