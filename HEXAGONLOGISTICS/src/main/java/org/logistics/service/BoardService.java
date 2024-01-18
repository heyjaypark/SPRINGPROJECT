package org.logistics.service;

import org.logistics.domain.PageDTO;
import org.logistics.domain.PageLogDTO;
import org.logistics.domain.ProductRegiVO;
import org.logistics.domain.ProductSalesVO;
import org.logistics.domain.ProductVO;


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
	 
	 public ProductSalesVO SalesList(ProductSalesVO productsale);
	

}
