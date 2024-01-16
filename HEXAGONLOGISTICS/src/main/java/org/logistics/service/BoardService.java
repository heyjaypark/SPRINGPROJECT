package org.logistics.service;

import org.logistics.domain.PageDTO;
import org.logistics.domain.PageLogDTO;


public interface BoardService {
	
	public PageDTO getProductPage(int pageNum);
	public PageDTO getNameProduct(String code, int pageNum);
	public PageDTO getNumberProduct(int code);
	
	public PageLogDTO getProductLogPage(int pageNum);
	public PageLogDTO getNameProductLog(String code, int pageNum);
	public PageLogDTO getNumberProductLog(int code);
	
	

}
