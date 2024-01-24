package org.logistics.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class ArticleData {
	
	private ArticleListVO article;
	private ArticleContentReadVO content;
	
	public ArticleData(ArticleListVO article, ArticleContentReadVO content) {
		this.article=article;
		this.content=content;
		
	}

	

}
