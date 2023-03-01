package com.SpringMVCXml.mapper;

import java.util.List;

import com.SpringMVCXml.domain.BoardDTO;
import com.SpringMVCXml.domain.Criteria;

public interface BoardMapper {

	List<BoardDTO> getList(Criteria criteria);
	
	int totalCount(Criteria criteria);
	
	BoardDTO getBoard(int bno);
	
	void insert(BoardDTO boardDTO);
	
	void readCount(int bno);
	
	void update(BoardDTO boardDTO);
	
	void delete(int bno);
}
