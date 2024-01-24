package org.logistics.domain;



import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class ArticleListVO {
	private Integer article_no;	
	private String title;
	private String id;
	private String name;
	private Date regDate;
	private Date modifiedDate;
	private int read_cnt;

}
