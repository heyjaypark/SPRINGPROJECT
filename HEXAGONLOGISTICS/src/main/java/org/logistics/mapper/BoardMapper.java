package org.logistics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.logistics.domain.ProductLogVO;
import org.logistics.domain.ProductVO;



public interface BoardMapper {
	public List<ProductVO> getList();
	List<ProductVO> getListWithPaging(@Param("pageNum") int pageNum, @Param("size") int size);
	public int getTotalCount();
	public int getNameTotalCount(@Param("code") String code);
	List<ProductVO> getSearchNameList(@Param("pageNum") int pageNum, @Param("size") int size, @Param("code") String code);
	List<ProductVO> getSearchNumberList(@Param("code") int code);
	
	public int getNameLogTotalCount(@Param("code") String code);
	List<ProductLogVO> getSearchNameLogList(@Param("pageNum") int pageNum, @Param("size") int size, @Param("code") String code);
	List<ProductLogVO> getSearchNumberLogList(@Param("code") int code);
	List<ProductLogVO> getListWithLogPaging(@Param("pageNum") int pageNum, @Param("size") int size);
	public int getLogTotalCount();
	
	ProductVO ProductRegi(@Param("productvo")ProductVO productvo);

}
