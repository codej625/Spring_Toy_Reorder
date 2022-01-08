package com.board.toy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.toy.request.BoardRequestDto;
import com.board.toy.service.BoardService;

@Controller
public class BoardController {

	BoardService service;
	
	// 생성자가 1개만 있을 경우에 @Autowired를 생략해도 주입이 가능
	BoardController(BoardService service) {
		this.service = service;
	}
	
	// main page
	@GetMapping(value = "/")
	public String main(Model model) throws Exception {
		
		List<BoardRequestDto> list;
		list = service.select();

		model.addAttribute("list", list);
		
		return "main";
	}
	
	// board write page(수정 예정)
	@GetMapping(value = "/write")
	public String write() {

		return "write";
	}
	
	// board write insert(수정 예정)
	@PostMapping(value = "/write")
	public String writeAction(BoardRequestDto requestBoard, RedirectAttributes attributes) throws Exception {
		
		int result = 0;
		result = service.write(requestBoard);
		// redirect후 객체를 넘길때 사용하는 RedirectAttributes Interface test
		attributes.addFlashAttribute("result", result);
		
		return "redirect:/";
	}
	
	// board content
	@GetMapping(value = "/content")
	@ResponseBody
	public Map<String, Object> contnet(BoardRequestDto requestBoard) throws Exception{
		Map<String, Object> content = new HashMap<String, Object>();
		requestBoard = service.content(requestBoard);
		content.put("content", requestBoard);
		
		return content;
	}
		
	// comment content
	@GetMapping(value = "/commentContent")
	@ResponseBody
	public Map<String, Object> commentContent(BoardRequestDto requestBoard) throws Exception {
		Map<String, Object> commentContent = new HashMap<String, Object>();
		List<BoardRequestDto> test = null;
		
		test = service.commentContent(requestBoard);
		
		System.out.println(test.get(0).getCommentVo().getContents());
		commentContent.put("commentContent", test);

		return commentContent;
	}
}
