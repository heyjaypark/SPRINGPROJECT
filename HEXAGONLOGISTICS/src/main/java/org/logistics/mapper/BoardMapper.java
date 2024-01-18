package org.logistics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	 
	 
	 //regist sale
	 public void RegistSales(ProductRegiVO productvo);
	 public void RegistSalesLog(ProductRegiVO productvo);
	 
	 //regist list
	 public ProductSalesVO SalesList(ProductSalesVO productsales);
	 
	 
	 
	 
	 

}
