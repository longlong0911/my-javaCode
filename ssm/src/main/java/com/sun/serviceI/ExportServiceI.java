package com.sun.serviceI;

import java.util.List;

import com.sun.entity.Export;

public interface ExportServiceI{
	public Export findById(String id);
	public List<Export> findAll();
	public void addExport(String[] ids);
	public void deleteById(String id);
	public void deleteByIds(String[] ids); 
	public void updateExport(Export export,Integer[] mr_orderNo, String[] mr_id, Integer[] mr_changed,
			Integer[] mr_cnumber, Double[] mr_grossWeight,
			Double[] mr_netWeight, Double[] mr_sizeLength,
			Double[] mr_sizeWidth, Double[] mr_sizeHeight, Double[] mr_exPrice,
			Double[] mr_tax);
}
