package com.engbaek.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.engbaek.domain.CourseVO;
import com.engbaek.domain.Criteria;
import com.engbaek.domain.ImageAttachVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/course/*")
@AllArgsConstructor
public class CourseController {

	// 강좌소개 목록
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info("list");
	}
	
	// 강좌소개 등록 화면
	@GetMapping("/register")
	public void register() {
		
	}

	// 강좌소개 등록
	@PostMapping("/register")
	public String register(CourseVO course, RedirectAttributes rttr) {
		return "redirect:/course/list";

	}
	
	// 강좌소개 삭제 
	@PostMapping("/remove")
	public String remove(@RequestParam("course_bno") Long course_bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		return "redirect:/course/list";
	}
	
	 
	
	// 강좌소개 상세 조회 or 수정 화면
	@GetMapping({ "/info", "/modify" })
	public void get(@RequestParam("bno") Long course_bno, @ModelAttribute("cri") Criteria cri, Model model) {
		
	}

	// 강좌소개 수정
	@PostMapping("/modify")
	public String modify(CourseVO course, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		return "redirect:/course/info";
	}
	
	// 강좌소개 이미지 첨부
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<ImageAttachVO>> getAttachList(Long course_bno) {
		log.info("getAttachList : " + course_bno);

		return new ResponseEntity<>(service.getAttachList(course_bno), HttpStatus.OK);
	}

	// 강좌소개 이미지 삭제
	private void deleteFiles(List<ImageAttachVO> attachList) {
		if (attachList == null || attachList.size() == 0) {
			return;
		}

		log.info("delete attach files.............");
		log.info(attachList);
		
		attachList.forEach(attach -> {
			try {
				Path file = Paths.get(
						"C:\\upload\\" + attach.getUploadPath() + "\\" + attach.getUuid() + "_" + attach.getFileName());
				Files.deleteIfExists(file);
				
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumbNail = Paths.get("C:\\upload\\" + attach.getUploadPath() + "\\s_" + attach.getUuid() + "_" + attach.getFileName());
					
					Files.delete(thumbNail);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}//END catch

		});//END forEach

	}
}
