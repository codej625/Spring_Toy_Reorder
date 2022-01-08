package com.board.toy.dao;

import java.util.List;

import com.board.toy.request.BoardRequestDto;
import com.board.toy.request.CommentVo;

public interface BoardDao {

	public List<BoardRequestDto> select() throws Exception;

	public int write(BoardRequestDto requestBoard) throws Exception;

	public BoardRequestDto content(BoardRequestDto requestBoard) throws Exception;
	
	public List<BoardRequestDto> commentContent(BoardRequestDto requestBoard) throws Exception;
	
	public int contents(CommentVo commentVo) throws Exception;
}
