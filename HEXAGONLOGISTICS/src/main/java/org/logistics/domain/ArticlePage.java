package org.logistics.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Setter
@Getter
public class ArticlePage {
	
	private int total;
	private int currentPage;
	private List<ArticleListVO> content;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public ArticlePage(int total, int currentPage, int size, List<ArticleListVO> content) {
		this.total=total;
		this.currentPage=currentPage;
		this.content=content;
		
		if(total==0) {
			totalPages=0;
			startPage=0;
			endPage=0;
			/* 마지막페이지를 추가하는 로직
			 * 最後のページを追加するロジック*/
		}else {
			totalPages=total/size;
			if(total%size>0) {
				totalPages++;
			}/* 페이지번호를 1부터 5개씩 출력하고 마지막페이지가 총페이지보다 크지 않도록한다
			 * ページ番号を5つずつ出力し、最後のページが総ページより大きくないようにする */
			int modVal=currentPage %5;
			startPage = currentPage / 5* 5 + 1;
			if(modVal ==0) startPage-=5;
			
			endPage = startPage+4;
			if(endPage>totalPages)endPage = totalPages;
			
		}
	}

	
	public boolean hasNoArticles() {
		return total==0;
	}
	public boolean hasArticles() {
		return total>0;
		
	}
	

}
