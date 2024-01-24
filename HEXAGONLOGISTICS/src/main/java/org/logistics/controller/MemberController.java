package org.logistics.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.logistics.domain.JoinRequestVO;
import org.logistics.domain.MemberVO;
import org.logistics.domain.UserVO;
import org.logistics.exception.DuplicateIdException;
import org.logistics.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.AllArgsConstructor;

@Controller
@SessionAttributes("authUser")
@RequestMapping("/in/*")
@AllArgsConstructor
public class MemberController {
	private BoardService service;
	
	
	@GetMapping("/loginForm")
	public void loginForm() {
		
	}
	@PostMapping("/joinForm")
	public void joinForm() {
		
	}
	
	@PostMapping("/JoinHexagon")
	public String JoinHexagon(@ModelAttribute JoinRequestVO joinrequestvo, Model model) {
		
		
		if(!joinrequestvo.isPasswordEqualToConfirm()){
			Map<String, Boolean> errors = new HashMap<>();
			errors.put("confirmPassword", Boolean.TRUE);
			 model.addAttribute("errors", errors);
			return "/in/joinForm";
		}
		
		
		int dupIdtest = service.duplicateIdtest(joinrequestvo);
		
		if(dupIdtest == 1) {
			throw new DuplicateIdException();
		}
		
		else if(dupIdtest == 0){
		service.JoinMember(joinrequestvo);
		}
		
		return "/in/joinSuccess";	
	}
	
	
	@PostMapping("/doLogin")
	public String doLogin(@ModelAttribute MemberVO membervo, Model model) {
		
		Map<String, Boolean> errors = new HashMap<>();
	
		// ID 또는 비밀번호가 비어 있는 경우, 오류를 오류 맵에 추가
				// IDまたはパスワードが空の場合、エラーをエラーマップに追加
				if (membervo.getShain_no() == null || membervo.getShain_no().isEmpty()) {
					errors.put("id", Boolean.TRUE);
					}
				
				if (membervo.getPw_id() == null || membervo.getPw_id().isEmpty()) {
					errors.put("password", Boolean.TRUE);
					}
				// 오류 맵이 비어 있지 않은 경우, 폼 뷰로 돌아감
				// エラーマップが空でない場合、フォームビューに戻る
				System.out.println(Boolean.TRUE.equals(errors.get("id")) || Boolean.TRUE.equals(errors.get("password")));
				if (Boolean.TRUE.equals(errors.get("id")) || Boolean.TRUE.equals(errors.get("password"))) {
					model.addAttribute("errors", errors);
					 System.out.println("Returning to /in/loginForm");
					return "/in/loginForm";
				}
				
				try {
					membervo.setShain_no(membervo.getShain_no().trim());
					membervo.setPw_id(membervo.getPw_id().trim());
				
				UserVO user = service.LoginMember(membervo);
				model.addAttribute("authUser", user);
				  System.out.println("Returning to /");

				return "/home";
				}catch(Exception e) {
					 e.printStackTrace(); // 예외 내용을 출력
					    // 예외 처리 로직 추가
					    return "/in/loginForm"; // 예외 발생 시 이동할 페이지 지정
				}
	}
	


	

	
}
