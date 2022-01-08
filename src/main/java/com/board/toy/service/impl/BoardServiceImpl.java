package com.board.toy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.toy.dao.BoardDao;
import com.board.toy.request.BoardRequestDto;
import com.board.toy.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	// 생성자 주입방식 외에 많이 사용되는 필드 주입방식 사용
	@Autowired
	BoardDao boardDao;

	@Override
	public List<BoardRequestDto> select() throws Exception {

		return boardDao.select();
	}

	@Override
	public int write(BoardRequestDto requestBoard) throws Exception {

		return boardDao.write(requestBoard);
	}

	@Override
	public BoardRequestDto content(BoardRequestDto requestBoard) throws Exception {

		return boardDao.content(requestBoard);
	}

	@Override
	public List<BoardRequestDto> commentContent(BoardRequestDto requestBoard) throws Exception {
		return boardDao.commentContent(requestBoard);
	}

}
