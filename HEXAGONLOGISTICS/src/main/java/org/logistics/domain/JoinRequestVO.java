package org.logistics.domain;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class JoinRequestVO {
	
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	

	
	// 비밀번호와 확인 비밀번호가 일치하는지 확인
	// パスワードと確認用パスワードが一致するかどうかを確認
	public boolean isPasswordEqualToConfirm() {
		return password != null && password.equals(confirmPassword);
	}
	
	// 유효성 검사를 수행하는 메서드
	// バリデーションを実行するメソッド
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, id, "id");
		checkEmpty(errors, name, "name");
		checkEmpty(errors, password, "password");
		checkEmpty(errors, confirmPassword, "confirmPassword");
		if(!errors.containsKey("confirmPassword")) {
			if(!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}
	
	// 값이 비어있는지 확인하는 메서드
	// 値が空であるかを確認するメソッド
	private void checkEmpty(Map<String, Boolean> errors,
			String value, String fieldName) {
		if(value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}

}
