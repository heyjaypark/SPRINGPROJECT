package org.logistics.service;

import java.util.List;

import org.logistics.domain.ArticleContentReadVO;
import org.logistics.domain.ArticleContentVO;
import org.logistics.domain.ArticleListVO;
import org.logistics.domain.ArticlePage;
import org.logistics.domain.ArticleVO;
import org.logistics.domain.JoinRequestVO;
import org.logistics.domain.MemberVO;
import org.logistics.domain.PageDTO;
import org.logistics.domain.PageLogDTO;
import org.logistics.domain.ProductLogVO;
import org.logistics.domain.ProductRegiVO;
import org.logistics.domain.ProductSalesVO;
import org.logistics.domain.ProductVO;
import org.logistics.domain.SalesListPageDTO;
import org.logistics.domain.UserVO;
import org.logistics.exception.LoginFailException;
import org.logistics.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	/* ProductList */
	@Override
	public PageDTO getProductPage(int pageNum) {
		int size = 10;

		List<ProductVO> content = mapper.getListWithPaging(pageNum, size);

		int total = mapper.getTotalCount();

		PageDTO pageDTO = new PageDTO(total, pageNum, size, content);

		// PageDTO에서 startPage 값을 확인
		int endPage = pageDTO.getEndPage();
		System.out.println("endPage: " + endPage);

		return pageDTO;
	}

	@Override
	public PageDTO getNameProduct(String code, int pageNum) {
		int size = 10;
		List<ProductVO> content = mapper.getSearchNameList(pageNum, size, code);

		int total = mapper.getNameTotalCount(code);

		PageDTO pageDTO = new PageDTO(total, pageNum, size, content);
		return pageDTO;
	}

	@Override
	public PageDTO getNumberProduct(int code) {
		int size = 10;
		int pageNum = 1;

		List<ProductVO> content = mapper.getSearchNumberList(code);
		PageDTO pageDTO = new PageDTO(1, pageNum, size, content);
		return pageDTO;

	}
	/* ProductList Finish */

	/* ProductLogList */

	@Override
	public PageLogDTO getProductLogPage(int pageNum) {
		int size = 10;

		List<ProductLogVO> content = mapper.getListWithLogPaging(pageNum, size);

		int total = mapper.getLogTotalCount();

		PageLogDTO pageLogDTO = new PageLogDTO(total, pageNum, size, content);

		// PageDTO에서 startPage 값을 확인
		int endPage = pageLogDTO.getEndPage();
		System.out.println("endPage: " + endPage);

		return pageLogDTO;
	}

	@Override
	public PageLogDTO getNameProductLog(String code, int pageNum) {
		int size = 10;
		List<ProductLogVO> content = mapper.getSearchNameLogList(pageNum, size, code);

		int total = mapper.getNameLogTotalCount(code);

		PageLogDTO pageLogDTO = new PageLogDTO(total, pageNum, size, content);
		return pageLogDTO;
	}

	@Override
	public PageLogDTO getNumberProductLog(int code) {
		int size = 10;
		int pageNum = 1;

		List<ProductLogVO> content = mapper.getSearchNumberLogList(code);
		PageLogDTO pageLogDTO = new PageLogDTO(1, pageNum, size, content);
		return pageLogDTO;

	}

	/* ProductLogList Finish */

	/* PRODUCTREGI */
	@Override
	public void register(ProductRegiVO productregivo) {
		mapper.ProductRegi(productregivo);
	}

	@Override
	public void Logregister(ProductRegiVO productregivo) {
		mapper.ProductLogRegi(productregivo);
	}

	/* PRODUCTREGI FINISH */

	/* PRODUCTUPDATE */

	@Override
	public ProductVO SearchNumberProduct(int p_no) {

		ProductVO content = mapper.ProductUpdateSearch(p_no);

		return content;

	}

	@Override
	public void ProductUpdate(ProductRegiVO productregivo) {
		mapper.ProductUpdate(productregivo);
	}

	@Override
	public void ProductLogUpdate(ProductRegiVO productregivo) {
		mapper.ProductLogUpdate(productregivo);

	}

	@Override
	public void RegistSales(ProductRegiVO productvo) {
		mapper.RegistSales(productvo);
	}

	@Override
	public void RegistSalesLog(ProductRegiVO productvo) {
		mapper.RegistSalesLog(productvo);
	}

	@Override
	public SalesListPageDTO SalesList(int pageNum) {
		int size = 10;

		List<ProductSalesVO> content = mapper.SalesList(pageNum, size);
		int total = mapper.getTotalSaleCount();
		SalesListPageDTO saleslistpagedto = new SalesListPageDTO(total, pageNum, size, content);

		return saleslistpagedto;

	}
	 @Override
	 public SalesListPageDTO getProductCodeSalesList(int code, int pageNum) {
		 int size = 10;
		 
		 List<ProductSalesVO> content = mapper.getSearchProductCodeSalesList(pageNum, size, code);
		 int total = mapper.getProductCodeSalesTotalCount(code);
		 SalesListPageDTO saleslistpagedto = new SalesListPageDTO(total, pageNum, size, content);
		 return saleslistpagedto;
	 }
	 
	 
	 @Override
	 public SalesListPageDTO getNumberSalesList(int code) {
		 int size = 10;
		 int pageNum = 1;
		 List<ProductSalesVO> content = mapper.getSearchNumberSalesList(code);
		 SalesListPageDTO saleslistpagedto = new SalesListPageDTO(1, pageNum, size, content);
		 return saleslistpagedto;
		 
	 }
	 @Transactional(noRollbackFor = DuplicateKeyException.class)
	 @Override
	 public void JoinMember(JoinRequestVO joinrequestvo) {
		 
				 mapper.MemberRegi(joinrequestvo);
}
	 @Override
	 public int duplicateIdtest(JoinRequestVO joinrequestvo) {
		 int duplicateTest = mapper.SearchID(joinrequestvo.getId());
		 
		 return duplicateTest;
	 }
	 
	/*
	 * @Override public UserVO LoginMember(MemberVO membervo) { String id =
	 * membervo.getId(); System.out.println("id" + id); MemberVO confirm =
	 * mapper.SelectById(id); System.out.println("confirm" + confirm.getId());
	 * System.out.println("MemberVO" + membervo);
	 * 
	 * if (confirm == null) { // 조회된 회원 정보가 없으면 로그인 실패 // 検索された会員情報がない場合はログイン失敗
	 * throw new LoginFailException();
	 * 
	 * }
	 * 
	 * if (!confirm.matchPassword(confirm.getPassword())) { // 일치하지 않으면 로그인 실패 //
	 * 一致しない場合はログイン失敗 throw new LoginFailException(); } return new
	 * UserVO(membervo.getId(),membervo.getName());
	 * 
	 * 
	 * 
	 * }
	 */
	 
	 @Override
	 public UserVO LoginMember(MemberVO membervo) {
	     
	     
	     MemberVO confirm = mapper.SelectById(membervo.getShain_no());
	   

	     if (confirm == null) {
	         // 조회된 회원 정보가 없으면 로그인 실패
	         // 検索された会員情報がない場合はログ인失敗
	    	 System.out.println("confirm ==null ");
	         throw new LoginFailException();
	     }
	     System.out.println("confirm " + confirm.getShain_no());

	     if (!membervo.matchPassword(confirm.getPw_id())) {
	    	 System.out.println("misamatchpassword ");
	         // 일치하지 않으면 로그인 실패
	         // 一致しない場合はログイン失敗
	         throw new LoginFailException();
	     }

	     return new UserVO(confirm.getShain_no(), confirm.getShain_name());
	 }
	 
	 
	 @Override
	 public void ArticleInsert(ArticleVO articlevo) {
		 
		 mapper.ArticleInsert(articlevo);
		 
		 
	 }
	 @Override
	 public void ArticleContentInsert(ArticleContentVO articlecontentvo){
		 mapper.ArticleContentInsert(articlecontentvo);
		 
	 }
	 @Override
	 public ArticlePage ArticlePage(int pageNum) {
		 int size = 10;
		 int total = mapper.TotalArticle();
		 return new ArticlePage(total, pageNum, size, mapper.ArticleList(pageNum, size));
		 
	 }
	 @Override
	 public int newArticleNumber() {
		 return mapper.NewArticleNum();
	 }
	 @Override
	 public ArticleContentReadVO ArticleRead(int no) {
		 mapper.ReadCountplus(no);
		 return mapper.ArticleContentReadVO(no);
	 }
	 
	 @Override
	 public ArticleListVO ArticleListVO(int no) {
		 return mapper.ArticleListVO(no);
	 }
	 
	 @Override
	 public void ArticleModify(int no, String title, String content) {
		 mapper.ArticleContentModify(no, content);
		 mapper.ArticleTitleModify(no, title);
		 
	 }
	 
	 @Override
	 public void DeleteArticle(int no) {
		 mapper.ArticleTitleDelete(no);
		 mapper.ArticleContentDelete(no);
		
	 }
}
