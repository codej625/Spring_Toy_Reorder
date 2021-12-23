package com.board.toy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.toy.dao.BoardDao;
import com.board.toy.request.BoardRequestDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	SqlSession session;

	@Override
	public List<BoardRequestDto> select() throws Exception {

		// 쿼리문 개선으로 사용되지 않는 코드
//		List<BoardRequestDto> list = session.selectList("board.select");
		// 게시글 댓글의 수를 가져와 list의 할당
//		for (int i = 0; i < list.size(); i++) {
		// reorder의 인덱스 i에 no값을 reorderNum 변수에 할당
//			int reorderNum = list.get(i).getNo();
		// 변수 reorderNum를 parameter로 select하고 그결과를 reorderNum에 재할당
//			reorderNum = session.selectOne("board.reorder", reorderNum);
		// reorderNum에 값을 reorder의 인덱스 i에 reorder에 할당
//			list.get(i).setReorder(reorderNum);
//		}

		return session.selectList("board.select");
	}

	@Override
	public int write(BoardRequestDto requestBoard) throws Exception {

		return session.insert("board.insert", requestBoard);
	}

	@Override
	public BoardRequestDto content(BoardRequestDto requestBoard) throws Exception {

		return session.selectOne("board.content", requestBoard);
	}

}
