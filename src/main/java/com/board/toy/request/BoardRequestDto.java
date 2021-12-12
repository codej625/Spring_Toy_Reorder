package com.board.toy.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDto {

	private int    no;
	private String title;
	private String contents;
	
	// 댓글 갯수 저장용 field
	private int    reorder;

}
