package com.sun.serviceIpl;


import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.dao.ContractMapper;
import com.sun.dao.ContractProductMapper;
import com.sun.dao.ExtCproductMapper;
import com.sun.entity.Contract;
import com.sun.entity.ContractProduct;
import com.sun.entity.ExtCproduct;
import com.sun.serviceI.ExtCproductServiceI;
import com.sun.utils.Arith;


@Service
@Transactional
public class ExtCproductServiceIpl implements ExtCproductServiceI{
	@Resource
	private ExtCproductMapper extCproductMapper;
	
	@Override
	public List<ExtCproduct> findByParam(String contractProductId) {
		return extCproductMapper.selectByParam(contractProductId);
	}
	@Override
	public ExtCproduct findById(String id) {
		return extCproductMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<ExtCproduct> findAll() {
		return extCproductMapper.getAll();
	}

	@Override
	public void addExtCproduct(ExtCproduct extCproduct) {
		extCproduct.setId(UUID.randomUUID().toString());
		Arith arith = new Arith(); 
		if(extCproduct.getCnumber()!=null && extCproduct.getPrice()!=null){
			extCproduct.setAmount(new BigDecimal(arith.mul(extCproduct.getCnumber().doubleValue(),extCproduct.getPrice().doubleValue())));
		}
		extCproductMapper.insert(extCproduct);
		
	}
	@Override
	public void deleteById(String id) {
		extCproductMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void deleteByIds(String[] ids) {
		extCproductMapper.delete(ids);
	}
	@Override
	public void updateExtCproduct(ExtCproduct extCproduct) {
		
		Arith arith = new Arith(); 
		if(extCproduct.getCnumber()!=null && extCproduct.getPrice()!=null){
			extCproduct.setAmount(new BigDecimal(arith.mul(extCproduct.getCnumber().doubleValue(),extCproduct.getPrice().doubleValue())));
		}
		
		extCproductMapper.updateByPrimaryKey(extCproduct);
	}
	@Override
	public void deleteByContractId(String contractId) {
		extCproductMapper.deleteByContractId(contractId);
	}
}
