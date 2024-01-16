package org.logistics.service;

import java.util.List;

import org.logistics.domain.PageDTO;
import org.logistics.domain.PageLogDTO;
import org.logistics.domain.ProductLogVO;
import org.logistics.domain.ProductVO;
import org.logistics.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public PageDTO getNameProduct(String code,int pageNum) {
		int size = 10;
		List<ProductVO> content = mapper.getSearchNameList(pageNum, size, code);
			
			int total = mapper.getNameTotalCount(code);
			
			PageDTO pageDTO = new PageDTO(total,pageNum,size,content);
					return pageDTO;
		}
		
		

	@Override
	public PageDTO getNumberProduct(int code) {
		int size = 10;
		int pageNum = 1;

			List<ProductVO> content = mapper.getSearchNumberList(code);
			PageDTO pageDTO = new PageDTO(1,pageNum,size,content);
			return pageDTO;

		
		}
	/* ProductList Finish*/
	
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
	public PageLogDTO getNameProductLog(String code,int pageNum) {
		int size = 10;
		List<ProductLogVO> content = mapper.getSearchNameLogList(pageNum, size, code);
		
		int total = mapper.getNameLogTotalCount(code);
		
		PageLogDTO pageLogDTO = new PageLogDTO(total,pageNum,size,content);
		return pageLogDTO;
	}
	
	
	
	@Override
	public PageLogDTO getNumberProductLog(int code) {
		int size = 10;
		int pageNum = 1;
		
		List<ProductLogVO> content = mapper.getSearchNumberLogList(code);
		PageLogDTO pageLogDTO = new PageLogDTO(1,pageNum,size,content);
		return pageLogDTO;
		
		
	}
	
	/* ProductLogList Finish*/
	
	
		
		
	}
	
	
	
	
	
