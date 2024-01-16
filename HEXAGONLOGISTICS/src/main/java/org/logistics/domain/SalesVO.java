package org.logistics.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class SalesVO {
	private int s_num;
	private int p_no;
	private int s_seoul;
	private int s_suwon;
	private int s_incheon;
	private Date s_date;
	private String s_registrant;
}
