package org.logistics.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class UserVO {
	
	private String id;
	private String name;
	public UserVO(String id, String name) {
		this.id = id;
		this.name = name;
	}

	


}
