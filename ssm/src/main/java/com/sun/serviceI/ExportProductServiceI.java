package com.sun.serviceI;

import java.util.List;

import com.sun.entity.ExportProduct;

public interface ExportProductServiceI{
//	 ExportProduct findById(String id);
//	 List<ExportProduct> findAll();
//	 void addExportProduct(ExportProduct exportProduct);
//	 void deleteById(String id);
//	 void deleteByIds(String[] ids);
//	 List<ExportProduct> findByContractId(String contractId);
//	 void deleteByContractId(String contractId);
	 List<ExportProduct> findByExportId(String exportId);
	 void updateExportProduct(ExportProduct exportProduct);

}
