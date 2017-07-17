package com.sun.serviceIpl;


import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.dao.ContractMapper;
import com.sun.dao.ContractProductMapper;
import com.sun.entity.Contract;
import com.sun.entity.ContractProduct;
import com.sun.serviceI.ContractProductServiceI;
import com.sun.utils.Arith;


@Service
@Transactional
public class ContractProductServiceIpl implements ContractProductServiceI{
	@Resource
	private ContractProductMapper contractProductMapper;
	
	@Override
	public List<ContractProduct> findByContractId(String contractId) {
		return contractProductMapper.selectByParam(contractId);
	}
	@Override
	public ContractProduct findById(String id) {
		return contractProductMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<ContractProduct> findAll() {
		return contractProductMapper.getAll();
	}

	@Override
	public void addContractProduct(ContractProduct contractProduct) {
		contractProduct.setId(UUID.randomUUID().toString());
		Arith arith = new Arith(); 
		if(contractProduct.getCnumber()!=null && contractProduct.getPrice()!=null){
			contractProduct.setAmount(new BigDecimal(arith.mul(contractProduct.getCnumber().doubleValue(),contractProduct.getPrice().doubleValue())));
		}
		
		contractProductMapper.insert(contractProduct);
		
	}
	@Override
	public void deleteById(String id) {
		contractProductMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void deleteByIds(String[] ids) {
		contractProductMapper.delete(ids);
	}
	@Override
	public void updateContractProduct(ContractProduct contractProduct) {
		Arith arith = new Arith(); 
		if(contractProduct.getCnumber()!=null && contractProduct.getPrice()!=null){
			contractProduct.setAmount(new BigDecimal(arith.mul(contractProduct.getCnumber().doubleValue(),contractProduct.getPrice().doubleValue())));
		}
		contractProductMapper.updateByPrimaryKey(contractProduct);
		
	}
	@Override
	public void deleteByContractId(String contractId) {
		contractProductMapper.deleteByContractId(contractId);
	}
}
