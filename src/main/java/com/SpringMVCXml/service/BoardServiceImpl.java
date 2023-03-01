package com.SpringMVCXml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringMVCXml.domain.BoardDTO;
import com.SpringMVCXml.domain.Criteria;
import com.SpringMVCXml.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardDTO> readAll(Criteria criteria) {
		return boardMapper.getList(criteria);
	}

	@Override
	public int totalCount(Criteria criteria) {
		return boardMapper.totalCount(criteria);
	}

	@Override
	public BoardDTO read(int bno) {
		return boardMapper.getBoard(bno);
	}

	@Override
	public void register(BoardDTO boardDTO) {
		boardMapper.insert(boardDTO);
	}

	@Override
	public void readCount(int bno) {
		boardMapper.readCount(bno);
	}

	@Override
	public void modify(BoardDTO boardDTO) {
		boardMapper.update(boardDTO);
	}
	
	@Override
	public void remove(int bno) {
		boardMapper.delete(bno);
	}

}
