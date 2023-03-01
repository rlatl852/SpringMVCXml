package com.SpringMVCXml.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SpringMVCXml.domain.BoardDTO;
import com.SpringMVCXml.domain.Criteria;
import com.SpringMVCXml.domain.PageVO;
import com.SpringMVCXml.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/Board")
@Log4j
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 게시물 목록
	@GetMapping("/list")
	public String boardList(Model model, Criteria criteria) {
		List<BoardDTO> readAll = boardService.readAll(criteria);
		PageVO pageVo = new PageVO(boardService.totalCount(criteria), criteria);
		model.addAttribute("list", readAll);
		model.addAttribute("pageMarker", pageVo);
		return "board/boardList";
	}

	// 게시물 조회
	@GetMapping("/content")
	public String getBoard(int bno, Model model, HttpServletRequest request, HttpServletResponse response) {
		BoardDTO board = boardService.read(bno);
		model.addAttribute("board", board);
		Cookie oldCookie = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("postView")) {
					oldCookie = cookie;
				}
			}
		}

		if (oldCookie != null) {
			if (!oldCookie.getValue().contains("[" + bno + "]")) {
				this.boardService.readCount(bno);
				oldCookie.setValue(oldCookie.getValue() + "_[" + bno + "]");
				oldCookie.setPath("/");
				oldCookie.setMaxAge(60 * 60 * 24); // 쿠키 시간
				response.addCookie(oldCookie);
			}
		} else {
			this.boardService.readCount(bno);
			Cookie newCookie = new Cookie("postView", "[" + bno + "]");
			newCookie.setPath("/");
			newCookie.setMaxAge(60 * 60 * 24); // 쿠키 시간
			response.addCookie(newCookie);
		}
		return "board/content";
	}

	// 글쓰기 폼
	@GetMapping("/register")
	public String getRegisterView() {
		return "board/register";
	}

	// 글쓰기 등록 처리
	@PostMapping("/register")
	public String register(BoardDTO boardDTO) {
		boardService.register(boardDTO);
		return "redirect:list";
	}

	// 수정 폼
	@GetMapping("/modify")
	public String getModifyForm(int bno, Model model) {
		BoardDTO board = boardService.read(bno);
		model.addAttribute("board", board);
		return "board/modify";
	}

	// 수정 처리
	@PostMapping("/modify")
	public String modify(BoardDTO boardDTO) {
		boardService.modify(boardDTO);
		return "redirect:list";
	}

	// 삭제 처리
	@PostMapping("/remove")
	public String remove(int bno) {
		boardService.remove(bno);
		return "redirect:list";
	}
}
