package com.sun.serviceI;

import java.util.List;

import com.sun.vo.OutProductVO;

public interface OutProductServiceI{
	public List<OutProductVO> find(String shipTime);
}
