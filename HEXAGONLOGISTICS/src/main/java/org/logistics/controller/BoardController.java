package org.logistics.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.logistics.domain.ProductVO;
import org.logistics.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;

@Controller

@RequestMapping("/in/*")
@AllArgsConstructor
public class BoardController {
	private BoardService service;

	/* PRODUCTLIST */
	@GetMapping("/ProductList")
	public void ProductList(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, Model model) {

		model.addAttribute("product", service.getProductPage(pageNum));

	}

	@GetMapping("/ProductSearchlist")
	public void ProductSearchlist(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam("select_num") int selectNum, @RequestParam("code") String code, Model model) {

		Map<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		try {
			if (selectNum == 1) {

				model.addAttribute("product", service.getNumberProduct(Integer.parseInt(code)));

			} else {

				model.addAttribute("product", service.getNameProduct(code, pageNum));
			}
		} catch (NumberFormatException e) {
			errors.put("NumberFormatException", Boolean.TRUE);

		}
		model.addAttribute("errors", errors);
	}
	/* PRODUCTLIST FINISH*/
	
	/* PRODUCTLOG */
	@GetMapping("/ProductLogList")
	public void ProductLogList(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, Model model) {
		
		model.addAttribute("product", service.getProductLogPage(pageNum));
		
	}
	
	@GetMapping("/ProductLogSearchList")
	public void ProductLogSearchList(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam("select_num") int selectNum, @RequestParam("code") String code, Model model) {

		Map<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		try {
			if (selectNum == 1) {

				model.addAttribute("product", service.getNumberProductLog(Integer.parseInt(code)));

			} else {

				model.addAttribute("product", service.getNameProductLog(code, pageNum));
			}
		} catch (NumberFormatException e) {
			errors.put("NumberFormatException", Boolean.TRUE);

		}
		model.addAttribute("errors", errors);
	}
	/* PRODUCTLOG FINISH*/
	
	/* PRODUCT REGI */
	
	
	@GetMapping("/Productregi")
	public void ProductRegi() {
		
	}
	
	@PostMapping("/ProductRegist")
	public String register(@RequestParam("p_name") String p_name,@RequestParam("p_seoul")int p_seoul,@RequestParam("p_suwon") int p_suwon,@RequestParam("p_incheon")int p_incheon,@RequestParam("price") int price,@RequestParam("date") Date date,@RequestParam("writer") String writer, RedirectAttributes rttr) {
		ProductVO productvo = new ProductVO(p_name, p_seoul, p_suwon,p_incheon,price,date,writer);

		
		rttr.addFlashAttribute("result","Success");

		return "redirect:/in/Productregi";
	}
	
			 
	
	


}
