package com.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.dto.BoardDTO;
import com.springboot.entity.Board;
import com.springboot.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/boards")
@Controller  //빈(bean) 등록
public class BoardController {
	
	private final BoardService service;
	
	//게시글 목록
	@GetMapping
	public String getBoardList(Model model) {
		List<Board> boardList = service.findAll();
		model.addAttribute("boardList", boardList); //리스트 보내기
		return "board/list";
	}
	
	//게시글 목록(페이지 처리)
	@GetMapping("/pages")
	public String getBoardPages(Model model) {
		List<Board> boardList = service.findAll();
		model.addAttribute("boardList", boardList); //리스트 보내기
		return "board/pages";
	}
	
	
	//글 쓰기 페이지 
	@GetMapping("/write")
	public String writeForm() {
		return "board/write";  // board/write.html
	}
	
	//글 쓰기 처리
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDTO dto) {
		log.info("BoardDTO: " + dto);
		service.save(dto);
		return "redirect:/boards";
	}
	
	//글 상세보기
	@GetMapping("/{id}")
	public String getBoard(@PathVariable Long id,
			Model model) {
		try {
			//조회수 증가
			service.updateHits(id);
			
			//상세보기 호출
			Board board = service.findById(id);  
			model.addAttribute("board", board);
			return "board/detail";
		}catch(Exception e) {
			return "error/errorPage";
		}
	}
	
	//글 삭제
	@GetMapping("/delete/{id}")
	public String deleteBoard(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/boards";
	}
	
	//글 수정 페이지
	@GetMapping("/update/{id}")
	public String updateForm(@PathVariable Long id,
			Model model) {
		Board board = service.findById(id); //해당 게시글 가져옴
		model.addAttribute("board", board); //수정페이지로 보냄
		return "board/update";
	}
	
	//글 수정 처리
	@PostMapping("/update")
	public String updateBoard(BoardDTO dto) {
		service.update(dto);
		return "redirect:/boards/" + dto.getId();
	}
}







