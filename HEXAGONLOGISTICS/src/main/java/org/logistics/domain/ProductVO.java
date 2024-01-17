package org.logistics.domain;

 
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class ProductVO {
	
	private int p_no;
	private String p_name;
	private int p_seoul;
	private int p_suwon;
	private int p_incheon;
	private int price;
	private Date date;
	

}
