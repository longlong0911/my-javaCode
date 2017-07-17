package com.sun.serviceI;

import java.util.List;

import com.sun.entity.Contract;
import com.sun.vo.ContractVO;

public interface ContractServiceI{
	public Contract findById(String id);
	public List<Contract> findAll();
	public void addContract(Contract contract);
	public void deleteById(String id);
	public void deleteByIds(String[] ids);
	public void updateContract(Contract contract);
	public void contractStateClose(String[] ids);
	public void contractStateOpen(String[] ids);
	public ContractVO findVO(String contractId);
	public void deleteByContractId(String contractId);
	public void intoHis(String[] ids);
	public void intoFrom(String[] ids);
	
	public List<Contract> findHisContract();
}
