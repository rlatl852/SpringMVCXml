package com.SpringMVCXml.service;

import java.util.List;

import com.SpringMVCXml.domain.BoardDTO;
import com.SpringMVCXml.domain.Criteria;

public interface BoardService {

	List<BoardDTO> readAll(Criteria criteria);

	int totalCount(Criteria criteria);
	
	BoardDTO read(int bno);
	
	void register(BoardDTO boardDTO);
	
	void readCount(int bno);
	
	void modify(BoardDTO boardDTO);
	
	void remove(int bno);
	
}
