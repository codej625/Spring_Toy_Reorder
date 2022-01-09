package com.board.toy.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDto {

	private Integer   no;
	private String    title;
	private String    content;
	// 댓글 count field
	private int       count;
	// row_number
	private int       rowNum;
	// join 
	private CommentVo commentVo;

}
