package com.sun.serviceI;

import java.util.List;

import com.sun.entity.ContractProduct;

public interface ContractProductServiceI{
	public ContractProduct findById(String id);
	public List<ContractProduct> findAll();
	public void addContractProduct(ContractProduct contractProduct);
	public void deleteById(String id);
	public void deleteByIds(String[] ids);
	public void updateContractProduct(ContractProduct contractProduct);
	public List<ContractProduct> findByContractId(String contractId);
	public void deleteByContractId(String contractId);

}
