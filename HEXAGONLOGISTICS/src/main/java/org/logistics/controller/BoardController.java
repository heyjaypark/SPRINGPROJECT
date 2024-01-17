package org.logistics.controller;

import java.util.HashMap;
import java.util.Map;

import org.logistics.domain.ProductRegiVO;
import org.logistics.domain.ProductVO;
import org.logistics.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@PostMapping("/productsearchchange")
	public String productsearchchange(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam("code") String code, Model model) {
		
		Map<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);
				
				model.addAttribute("product", service.getNameProduct(code, pageNum));
				
				return "/in/ProductSerchlistAlert";

	}
	@GetMapping("/productsearchchange")
	public String productsearchchangewithpageNum(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam("code") String code, Model model) {
		
		Map<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		
		model.addAttribute("product", service.getNameProduct(code, pageNum));
		
		return "/in/ProductSerchlistAlert";
		
	}
	
	
	
	
	/* PRODUCTLIST FINISH */

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

	/* PRODUCTLOG FINISH */

	/* PRODUCT REGI */
	@GetMapping("/Productregi")
	public void ProductRegi() {

	}

	@GetMapping("/Productupdates")
	public void Productupdates() {

	}
	@GetMapping("/RegistSales")
	public void RegistSales() {
		
	}
	@GetMapping("/ListSales_overview")
	public void ListSales_overview() {
		
	}
	@GetMapping("/listArticle")
	public void listArticle() {
		
	}
	@GetMapping("/newArticleForm")
	public void newArticleForm() {
		
	}
	@GetMapping("/ProductSerchlistAlert")
	public void ProductSerchlistAlert() {
		
	}
	

	@PostMapping("/ProductRegist")
	public String register(@ModelAttribute ProductRegiVO productregivo) {
		System.out.println("ProductRegiVO" + productregivo);

		service.register(productregivo);
		service.Logregister(productregivo);

		return "redirect:/in/Productregi";
	}
	/* PRODUCT REGI FINISH */
	/* PRODUCT UPDATE */
	@PostMapping("/Productupdatesearch")
	public String ProductupdateSearch(@RequestParam("p_no") String p_no, Model model) {

		model.addAttribute("product1",service.SearchNumberProduct(Integer.parseInt(p_no)));
		
		return "/in/Productupdates";

	}
	@PostMapping("/Productupdates")
	public String Productupdate(@ModelAttribute ProductRegiVO productregivo) {
		service.ProductUpdate(productregivo);
		
		service.ProductLogUpdate(productregivo);
		
		return "/in/Productupdates";
	}
			
	
	
	
	
	
	
	
	/* PRODUCT UPDATE FINISH */



}
