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
import com.engbaek.domain.RefundInfoVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/refund_info/*")
@AllArgsConstructor
public class RefundInfoController {
	
	// 환불 규정 상세 조회 or 수정 화면
	@GetMapping({ "/read", "/modify" })
	public void get(@RequestParam("refund_info_bno") Long refund_info_bno, @ModelAttribute("cri") Criteria cri, Model model) {

	}

	// 환불 규정 상세 수정
	@PostMapping("/modify")
	public String modify(RefundInfoVO refundInfo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		return "redirect:/refund_info/read";
	}
}
