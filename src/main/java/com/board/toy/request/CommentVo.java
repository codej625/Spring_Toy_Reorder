package com.board.toy.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentVo {

	private Integer comment_no;
	private Integer parent;
	private String  contents;

}
