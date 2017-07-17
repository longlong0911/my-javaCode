package com.sun.serviceI;

import java.util.List;

import com.sun.entity.PackingList;

public interface PackingListServiceI{
	 PackingList findById(String id);
	 List<PackingList> findAll();
	 void addPackingList(PackingList packingList);
	 void deleteById(String id);
	 void deleteByIds(String[] ids);
	 void updatePackingList(PackingList packingList);
	 
	 public String findCustomerContract(String[] ids);
}
