package org.logistics.controller;

import java.util.Date;

import org.logistics.domain.ArticleContentReadVO;
import org.logistics.domain.ArticleContentVO;
import org.logistics.domain.ArticleData;
import org.logistics.domain.ArticleListVO;
import org.logistics.domain.ArticleVO;
import org.logistics.domain.UserVO;
import org.logistics.domain.WriterVO;
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
public class ArticleListController {
	private BoardService service;

	
	@GetMapping("/listArticle")
	public void listArticle(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, Model model) {
		model.addAttribute("articlePage",service.ArticlePage(pageNum));
		
		
		
	}
	@GetMapping("/read")
	public String read(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,@RequestParam(name = "no") int no, Model model) {
		
		
		ArticleContentReadVO content = service.ArticleRead(no);
		ArticleListVO article = service.ArticleListVO(no);
		ArticleData articleData = new ArticleData(article,content);
		model.addAttribute("articleData",articleData);
		model.addAttribute("pageNum",pageNum);
		
		return "/in/readArticle";
		
		
		
	}
	
	
	
	
	@GetMapping("/newArticleForm")
	public void newArticleForm() {
		
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute ArticleVO articlevo,@ModelAttribute("authUser") UserVO user, @RequestParam String content,Model model) {
		System.out.println("ArticleVO"+ articlevo);
		System.out.println("content"+ content);
		
		WriterVO writervo = new WriterVO(user.getId(),user.getName());
		articlevo.setWriter(writervo);
		
		ArticleContentVO articlecontentvo = new ArticleContentVO();	
		articlecontentvo.setContent(content);
		
		
		Date now=new Date();
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		articlevo.setRegDate(sqlDate);
		articlevo.setModifiedDate(sqlDate);
		
		
		service.ArticleInsert(articlevo);
		service.ArticleContentInsert(articlecontentvo);
		model.addAttribute("newArticleNo",service.newArticleNumber());
		
		
		return "/in/newArticleSuccess";
	}
	
	
	@GetMapping("/modifyForm")
	public void modifyForm(@RequestParam(name = "no") int no, Model model) {
		ArticleContentReadVO content = service.ArticleRead(no);
		ArticleListVO article = service.ArticleListVO(no);
		ArticleData articleData = new ArticleData(article,content);
		model.addAttribute("articleData",articleData);
		
	
	}
	@PostMapping("/modify")
	public String modify(@RequestParam(name = "no") int no,@RequestParam(name = "title") String title,@RequestParam(name = "content") String content, Model model) {
		service.ArticleModify(no, title, content);
		
		model.addAttribute("no",no);
		
		return "/in/modifySuccess";
	}
	@GetMapping("/DeleteForm")
	public void DeleteForm(@RequestParam(name = "no") int no, Model model) {
		model.addAttribute("no",no);
	}
	@PostMapping("/Delete")
	public String Delete(@RequestParam(name = "no") int no) {
		service.DeleteArticle(no);
		
		
		return "/in/DeleteSuccess";
	}

	
	
	
	}

	 
	 
	 
	
	




