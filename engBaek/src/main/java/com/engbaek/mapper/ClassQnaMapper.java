package com.engbaek.mapper;

import java.util.List;

import com.engbaek.domain.ClassQnaVO;
import com.engbaek.domain.Criteria;

public interface ClassQnaMapper {

	//강의별 QAQ 총 게시물 수  
	public int getTotalCount(Criteria cri);
	
	//강의별 Q&A 게시판 페이징 
	public List<ClassQnaVO> getListWithPaging(Criteria cri);
	
	//강의별 Q&A 수정 
	public int update(ClassQnaVO classQna);
	
	//강의별 Q&A 삭제 
	public int delete(Long classQna_bno);
	
	//강의별 Q&A 읽기 
	public ClassQnaVO read(Long classQna_bno);
	
	//게시물 번호 사용자에게 보이게 하기 
	public Integer insertSelectKey(ClassQnaVO classQna);
	
	/*
	 * //강의별 public void insert(ClassQnaVO classQna_bno);
	 */
	
}
