package org.logistics.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class ProductLogVO {
	
	private int p_no;
	private String l_name;
	private int l_seoul;
	private int l_suwon;
	private int l_incheon;
	private int l_price;
	private String l_writer;
	private Date l_date;
	private String l_class;
	private int l_no;

}
