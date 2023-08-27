package kr.kh.app.controller;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

/** 서블릿 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Home() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 실행");
	}

	
	public void destroy() {
		System.out.println("distroy 실행");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버에서 화면에게 데이터를 전송
		request.setAttribute("msg", "hello");
		// 미리 만들어 놓은 home.jsp와 연결
		request.getRequestDispatcher("WEB-INF/views/home.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면에서 보낸 id를 가져옴
		String id = request.getParameter("id");
		System.out.println(id);
		doGet(request, response);
	}

}
