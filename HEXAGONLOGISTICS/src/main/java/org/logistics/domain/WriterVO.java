package org.logistics.domain;

 
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class WriterVO {

	private String id;
	private String name;
	public WriterVO(String id, String name) {
		this.id = id;
		this.name=name;
	}
	
}
