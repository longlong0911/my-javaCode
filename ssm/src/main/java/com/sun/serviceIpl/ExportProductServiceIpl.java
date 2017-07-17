package com.sun.serviceIpl;


import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.dao.ContractMapper;
import com.sun.dao.ContractProductMapper;
import com.sun.dao.ExportMapper;
import com.sun.dao.ExportProductMapper;
import com.sun.dao.ExtCproductMapper;
import com.sun.dao.ExtEproductMapper;
import com.sun.entity.Contract;
import com.sun.entity.ContractProduct;
import com.sun.entity.Export;
import com.sun.entity.ExportProduct;
import com.sun.entity.ExtCproduct;
import com.sun.entity.ExtEproduct;
import com.sun.serviceI.ExportProductServiceI;


@Service
@Transactional
public class ExportProductServiceIpl implements ExportProductServiceI{
	@Resource
	private ExportProductMapper exportProductMapper;
	
	@Override
	public List<ExportProduct> findByExportId(String exportId) {
		return exportProductMapper.findByExportId(exportId);
	}

	@Override
	public void updateExportProduct(ExportProduct exportProduct) {
		exportProductMapper.update(exportProduct);
	}
	
	
}
