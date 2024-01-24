package org.logistics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.logistics.domain.ArticleContentReadVO;
import org.logistics.domain.ArticleContentVO;
import org.logistics.domain.ArticleListVO;
import org.logistics.domain.ArticleVO;
import org.logistics.domain.JoinRequestVO;
import org.logistics.domain.MemberVO;
import org.logistics.domain.ProductLogVO;
import org.logistics.domain.ProductRegiVO;
import org.logistics.domain.ProductSalesVO;
import org.logistics.domain.ProductVO;



public interface BoardMapper {
	
	//productlist
	public List<ProductVO> getList();
	List<ProductVO> getListWithPaging(@Param("pageNum") int pageNum, @Param("size") int size);
	public int getTotalCount();
	public int getNameTotalCount(@Param("code") String code);
	List<ProductVO> getSearchNameList(@Param("pageNum") int pageNum, @Param("size") int size, @Param("code") String code);
	List<ProductVO> getSearchNumberList(@Param("code") int code);
	
	//productloglist
	public int getNameLogTotalCount(@Param("code") String code);
	List<ProductLogVO> getSearchNameLogList(@Param("pageNum") int pageNum, @Param("size") int size, @Param("code") String code);
	List<ProductLogVO> getSearchNumberLogList(@Param("code") int code);
	List<ProductLogVO> getListWithLogPaging(@Param("pageNum") int pageNum, @Param("size") int size);
	public int getLogTotalCount();
	
	
	//product regist, update
	public void ProductRegi(ProductRegiVO productvo);
	 public void ProductLogRegi(ProductRegiVO productvo); 
	 public ProductVO ProductUpdateSearch(@Param("p_no") int p_no); 
	 public void ProductUpdate(ProductRegiVO productvo);
	 public void ProductLogUpdate(ProductRegiVO productvo);
	 
	 
	 //Saleregist
	 public void RegistSales(ProductRegiVO productvo);
	 public void RegistSalesLog(ProductRegiVO productvo);
	 
	 //Saleslist
	 public List<ProductSalesVO> SalesList(@Param("pageNum") int pageNum, @Param("size") int size);
	 public int getTotalSaleCount();
	 
	 //SalesSearch
	 public int getProductCodeSalesTotalCount(@Param("code") int code);
	 List<ProductSalesVO> getSearchProductCodeSalesList(@Param("pageNum") int pageNum, @Param("size") int size, @Param("code") int code);
	 List<ProductSalesVO> getSearchNumberSalesList(@Param("code") int code);
	 
	 //join member
	 public void MemberRegi(JoinRequestVO joinrequestvo);
	 public int SearchID(@Param("id") String id);
	 
	 //login member
	 public MemberVO SelectById(@Param("shain_no") String shain_no);
	 
	 //article insert
	 public void ArticleInsert(ArticleVO articlevo); 
	 public void ArticleContentInsert(ArticleContentVO articlecontentvo); 
	 
	 //article List
	 public List<ArticleListVO> ArticleList(@Param("pageNum") int pageNum, @Param("size") int size);
	 public int TotalArticle();
	 
	 //article Read
	 public ArticleContentReadVO ArticleContentReadVO(@Param("no") int no);
	 public ArticleListVO ArticleListVO(@Param("no") int no);
	 public void ReadCountplus(@Param("no") int no);
	 
	 //article modifiy
	 public void ArticleContentModify(@Param("no") int no,@Param("content") String content);
	 public void ArticleTitleModify(@Param("no") int no,@Param("title") String title);
	 
	 public void ArticleContentDelete(@Param("no") int no);
	 public void ArticleTitleDelete(@Param("no") int no);
	 
	 public int NewArticleNum();
	
	
	 

}
