package org.logistics.controller;

import java.util.HashMap;
import java.util.Map;

import org.logistics.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.AllArgsConstructor;

@Controller
@SessionAttributes("authUser")
@RequestMapping("/in/*")
@AllArgsConstructor
public class ProductLogController {
	private BoardService service;



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

	
}
