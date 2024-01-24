package org.logistics.controller;

import java.util.HashMap;
import java.util.Map;

import org.logistics.domain.ProductRegiVO;
import org.logistics.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.AllArgsConstructor;

@Controller
@SessionAttributes("authUser")
@RequestMapping("/in/*")
@AllArgsConstructor
public class SalesController {
	private BoardService service;

	
	/* SALE REGI */
	@PostMapping("/searchsales")
	public String searchsales(@RequestParam("p_no") String p_no, Model model) {

		model.addAttribute("prod",service.SearchNumberProduct(Integer.parseInt(p_no)));
		
		return "/in/RegistSales";

	}
	@PostMapping("/registSales")
	public String registSales(@ModelAttribute ProductRegiVO productregivo) {
		service.RegistSales(productregivo);
		service.RegistSalesLog(productregivo);
		
		
		return "/in/RegistSales";
	}
	
	@GetMapping("/RegistSales")
	public void RegistSales() {
		
		
	}
	/* SALE REGI FINISH */
	
	
	
	  @GetMapping("/ListSales_overview") 
	  public void ListSales_overview(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, Model model) {
	  
	  model.addAttribute("salesPage", service.SalesList(pageNum));
	  
	  }
	
	  
	  
	  @GetMapping("/ListSales_Searchview") 
	  public void ListSales_Searchview(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
	  @RequestParam("select_num") int selectNum, @RequestParam("code") String code,
	  Model model) {
		  
		  Map<String, Boolean> errors = new HashMap<>();
			model.addAttribute("errors", errors);

			try {
				if (selectNum == 1) {

					model.addAttribute("salesPage", service.getNumberSalesList(Integer.parseInt(code)));
							

				} else {

					model.addAttribute("salesPage", service.getProductCodeSalesList(Integer.parseInt(code), pageNum));
				}
			} catch (NumberFormatException e) {
				errors.put("NumberFormatException", Boolean.TRUE);

			}
			model.addAttribute("errors", errors);
	  
	  
	  
	  
	  }
	 
	 
	 
	
	



}
