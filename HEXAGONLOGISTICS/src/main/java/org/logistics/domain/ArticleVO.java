package org.logistics.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class ArticleVO {
	private Integer number;
	private WriterVO writer;
	private String title;
	private Date regDate;
	private Date modifiedDate;
	private int readCount;
}
