package com.sun.serviceI;

import java.util.List;

import com.sun.entity.ExtEproduct;

public interface ExtEproductServiceI{
	public ExtEproduct findById(String id);
	public List<ExtEproduct> findAll();
	public void addExtEproduct(ExtEproduct extEproduct);
	public void deleteById(String id);
	public void deleteByIds(String[] ids);
	public void updateExtEproduct(ExtEproduct extEproduct);
	public List<ExtEproduct> findByParam(String contractProductId);
	public void deleteByContractId(String contractId);
}
