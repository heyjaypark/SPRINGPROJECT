package org.logistics.domain;

 
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class MemberVO {
	private String shain_no;
	private String shain_name;
	private String pw_id;
	
	
	public boolean matchPassword(String pwd) {
		return pw_id.equals(pwd);
	}

	public void changePassword(String newPwd) {
		this.pw_id = newPwd;
	}
}
