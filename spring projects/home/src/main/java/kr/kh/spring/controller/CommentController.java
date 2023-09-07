package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring.service.CommentService;
import kr.kh.spring.vo.CommentVO;

//@RestController
@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@ResponseBody
	@PostMapping("/comment/insert")
	public Map<String, Object> insert(@RequestBody CommentVO comment){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = commentService.insertComment(comment);
		
		map.put("res", res);
		return map;
	}
}
