package com.sun.dao;

import java.util.List;

import com.sun.vo.OutProductVO;


public interface OutProductMapper {
    
	public List<OutProductVO> find(String shipTime);
	
}