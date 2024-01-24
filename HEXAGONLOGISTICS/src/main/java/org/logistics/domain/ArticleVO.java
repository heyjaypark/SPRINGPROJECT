package org.logistics.domain;



import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class ArticleVO {
	private Integer num;
	private WriterVO writer;
	private String title;
	private Date regDate;
	private Date modifiedDate;
	private int readCount;
	
	public ArticleVO (WriterVO writer) {
		this.writer = writer;
	}
}
