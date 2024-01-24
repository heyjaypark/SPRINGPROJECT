package org.logistics.service;

import org.logistics.domain.ArticleContentReadVO;
import org.logistics.domain.ArticleContentVO;
import org.logistics.domain.ArticleListVO;
import org.logistics.domain.ArticlePage;
import org.logistics.domain.ArticleVO;
import org.logistics.domain.JoinRequestVO;
import org.logistics.domain.MemberVO;
import org.logistics.domain.PageDTO;
import org.logistics.domain.PageLogDTO;
import org.logistics.domain.ProductRegiVO;
import org.logistics.domain.ProductVO;
import org.logistics.domain.SalesListPageDTO;
import org.logistics.domain.UserVO;


public interface BoardService {
	
	public PageDTO getProductPage(int pageNum);
	public PageDTO getNameProduct(String code, int pageNum);
	public PageDTO getNumberProduct(int code);
	
	public PageLogDTO getProductLogPage(int pageNum);
	public PageLogDTO getNameProductLog(String code, int pageNum);
	public PageLogDTO getNumberProductLog(int code);
	
	public void register(ProductRegiVO productregivo);
	public void Logregister(ProductRegiVO productregivo); 
	
	public ProductVO SearchNumberProduct(int code);
	public void ProductUpdate(ProductRegiVO productregivo);
	public void ProductLogUpdate(ProductRegiVO productregivo);
	
	
	 public void RegistSales(ProductRegiVO productvo);
	 public void RegistSalesLog(ProductRegiVO productvo);
	 
	 public SalesListPageDTO SalesList(int pageNum);
	 public SalesListPageDTO getProductCodeSalesList(int code, int pageNum);
	 public SalesListPageDTO getNumberSalesList(int code);
	 
	 public int duplicateIdtest(JoinRequestVO joinrequestvo);
	 public void JoinMember(JoinRequestVO joinrequestvo);
	 public UserVO LoginMember(MemberVO membervo);
	 
	 public void ArticleInsert(ArticleVO articlevo);
	 public void ArticleContentInsert(ArticleContentVO articlecontentvo);
	 
	 public ArticlePage ArticlePage(int pageNum);
	 public ArticleContentReadVO ArticleRead(int no);
	 public ArticleListVO ArticleListVO(int no);
	 
	 public void ArticleModify(int no, String title, String content); 
	 
	 public void DeleteArticle(int no);
	 
	 public int newArticleNumber();
	

}
