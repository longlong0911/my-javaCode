package com.sun.serviceIpl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.dao.CodeMapper;
import com.sun.entity.Code;
import com.sun.serviceI.CodeServiceI;


@Service
@Transactional
public class CodeServiceIpl implements CodeServiceI{
	@Resource
	private CodeMapper codeMapper;
	
	@Override
	public List<Code> findAll() {
		return codeMapper.getAll();
	}
}
