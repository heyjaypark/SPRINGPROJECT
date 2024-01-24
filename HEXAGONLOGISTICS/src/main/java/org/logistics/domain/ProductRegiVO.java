package org.logistics.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class ProductRegiVO {
	private int p_no;
	private String p_name;
	private int p_seoul;
	private int p_suwon;
	private int p_incheon;
	private int price;
	private Date p_date;

	private String writer;

}
