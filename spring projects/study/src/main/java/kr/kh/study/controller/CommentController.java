package kr.kh.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.study.service.CommentService;
import kr.kh.study.vo.CommentVO;

@RestController // 컨트롤러에 있는 모든 메소드가 ajax를 사용하는 경우로 되있는 경우, @reponseBody 있는 경우 
@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/comment/insert")
	public Map<String, Object> insert(@RequestBody CommentVO comment){
		Map<String, Object> map = new HashMap<String, Object>();
		
		//System.out.println(comment);
		boolean res = commentService.insertComment(comment);
		map.put("res", res);
		return map;
	}
	
}