package org.logistics.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class ProductSalesVO {
	private int s_num;
	private String p_name;
	private int p_no;
	private int s_seoul;
	private int s_suwon;
	private int s_incheon;
	private int price;
	private Date s_date;
	private String s_registrant;
	
	
	
	

}
