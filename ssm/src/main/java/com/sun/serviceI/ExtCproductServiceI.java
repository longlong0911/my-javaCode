package com.sun.serviceI;

import java.util.List;

import com.sun.entity.ExtCproduct;

public interface ExtCproductServiceI{
	public ExtCproduct findById(String id);
	public List<ExtCproduct> findAll();
	public void addExtCproduct(ExtCproduct extCproduct);
	public void deleteById(String id);
	public void deleteByIds(String[] ids);
	public void updateExtCproduct(ExtCproduct extCproduct);
	public List<ExtCproduct> findByParam(String contractProductId);
	public void deleteByContractId(String contractId);
}
