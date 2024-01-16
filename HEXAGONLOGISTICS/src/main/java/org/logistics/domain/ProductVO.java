package org.logistics.domain;

 
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class ProductVO {
	private int num;
	private int p_no;
	private String p_name;
	private int p_seoul;
	private int p_suwon;
	private int p_incheon;
	private int price;
	private Date date;
	private String writer;
	
	public ProductVO(String p_name, int p_seoul, int p_suwon, int p_incheon, int price, Date date, String writer) {
		this.p_name = p_name;
		this.p_seoul = p_seoul;
		this.p_suwon = p_suwon;
		this.p_incheon = p_incheon;
		this.price = price;
		this.date = date;
		this.writer = writer;
	}
	

}
