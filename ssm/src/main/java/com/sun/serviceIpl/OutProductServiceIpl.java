package com.sun.serviceIpl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.dao.OutProductMapper;
import com.sun.serviceI.OutProductServiceI;
import com.sun.vo.OutProductVO;


@Service
@Transactional
public class OutProductServiceIpl implements OutProductServiceI{
	@Resource
	private OutProductMapper outProductMapper;

	@Override
	public List<OutProductVO> find(String shipTime) {
		return outProductMapper.find(shipTime);
	}

	
	
}
