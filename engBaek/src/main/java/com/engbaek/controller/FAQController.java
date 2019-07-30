package com.engbaek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.engbaek.domain.Criteria;
import com.engbaek.domain.FaqVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/faq/*")
@AllArgsConstructor
public class FAQController {
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info("list");
	}

	@GetMapping({ "/read", "/modify" })
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {

	}

	//TODO BoardVO 변경
	@PostMapping("/modify")
	public String modify(FaqVO faq, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		return "redirect:/faq/read";
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		return "redirect:/faq/list";
	}

	@GetMapping("/register")
	public void register() {

	}

	//TODO BoardVO 변경
	@PostMapping("/register")
	public String register(FaqVO faq, RedirectAttributes rttr) {
		return "redirect:/faq/list";

	}
}
