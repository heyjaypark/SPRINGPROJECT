package org.logistics.service;

import org.logistics.domain.PageDTO;
import org.logistics.domain.PageLogDTO;
import org.logistics.domain.ProductRegiVO;
import org.logistics.domain.ProductVO;
import org.logistics.domain.SalesListPageDTO;


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
	

}
