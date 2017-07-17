package com.sun.serviceIpl;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.sun.serviceI.ExportServiceI;


@Service
@Transactional
public class ExportServiceIpl implements ExportServiceI{
	@Resource
	private ExportMapper exportMapper;
	@Resource
	private ContractMapper contractMapper;
	@Resource
	private ContractProductMapper contractProductMapper;
	@Resource
	private ExportProductMapper exportProductMapper;
	@Resource
	private ExtCproductMapper extCproductMapper;
	@Resource
	private ExtEproductMapper extEproductMapper;
	
	@Override
	public Export findById(String id) {
		return exportMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Export> findAll() {
		return exportMapper.getAll();
	}

	@Override
	public void addExport(String[] ids) {
		
		//1.把选择的多个合同的ID和合同号保存到报运表中
		//2.把这几个合同下的货物信息插入到当前报运下的货物表中（冗余设计）
		//3.把这几个货物下的附件信息插入到当前对于的货物的附件下（冗余设计）
		//4.保存报运对象
		
		StringBuffer contractIdsBuf = new StringBuffer();			//合同id集合
		StringBuffer contractNosBuf = new StringBuffer();			//合同号集合
		for(String contractId : ids ){
			contractIdsBuf.append(contractId).append(",");
			Contract contract = contractMapper.selectByPrimaryKey(contractId);	//获取合同对象
			contractNosBuf.append(contract.getContractNo()).append(" ");
		}
		contractIdsBuf.delete(contractIdsBuf.length()-1, contractIdsBuf.length());		//删除最后一个字符
		
		
		Export export = new Export();
		export.setId(UUID.randomUUID().toString());
		export.setContractIds(contractIdsBuf.toString());
		export.setCustomerContract(contractNosBuf.toString());
		export.setState(0);			//0草稿
		
		//处理货物信息
		for(int i=0;i<ids.length;i++){
			String contractId = ids[i];
			List<ContractProduct> cpList = contractProductMapper.selectByParam(contractId);
			
			for(int j=0;j<cpList.size();j++){
				ContractProduct cp = cpList.get(j);	//获取当前货物
				
				ExportProduct ep = new ExportProduct();
				ep.setId(UUID.randomUUID().toString());
				ep.setExportId(export.getId());		//外键值
				
				ep.setProductNo(cp.getProductNo());
				ep.setFactoryName(cp.getFactoryName());
				ep.setPackingUnit(cp.getPackingUnit());
				ep.setCnumber(cp.getCnumber());	
				ep.setBoxNum(cp.getBoxNum());
				
				exportProductMapper.insert(ep);
				
				//处理附件
				List<ExtCproduct> extcpList = extCproductMapper.selectByParam(cp.getId());      //货物id查找附件
				for(int k=0;k<extcpList.size();k++){
					ExtCproduct extCproduct = extcpList.get(k);		//附件信息
					
					ExtEproduct extEproduct = new ExtEproduct();
					
					BeanUtils.copyProperties(extCproduct, extEproduct);
					extEproduct.setId(UUID.randomUUID().toString());
					extEproduct.setExportProductId(ep.getId());		//外键值
					
					extEproductMapper.insert(extEproduct);
				}
				
			}
		}
		
		exportMapper.insert(export);
	}

	@Override
	public void deleteById(String id) {
		exportMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByIds(String[] ids) {
		//级联删除
		for(String exportId : ids){
			exportProductMapper.deleteByExportId(exportId);
			extEproductMapper.deleteByExportId(exportId);
		}
		for(String id : ids){
			exportMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public void updateExport(Export export,Integer[] mr_orderNo, String[] mr_id, Integer[] mr_changed,
			Integer[] mr_cnumber, Double[] mr_grossWeight,
			Double[] mr_netWeight, Double[] mr_sizeLength,
			Double[] mr_sizeWidth, Double[] mr_sizeHeight, Double[] mr_exPrice,
			Double[] mr_tax) {
		
		exportMapper.update(export);
		
		//处理货物信息
		for(int i=0;i<mr_orderNo.length;i++){
//			if(mr_changed.equals("1")){			//修改优化
				ExportProduct ep = exportProductMapper.selectByPrimaryKey(mr_id[i]);
				
				ep.setCnumber(mr_cnumber[i]);
				ep.setGrossWeight(mr_grossWeight[i]);
				ep.setNetWeight(mr_netWeight[i]);
				ep.setSizeLength(mr_sizeLength[i]);
				ep.setSizeWidth(mr_sizeWidth[i]);
				ep.setSizeHeight(mr_sizeHeight[i]);
				ep.setExPrice(mr_exPrice[i]);
				ep.setTax(mr_tax[i]);
				
				exportProductMapper.update(ep);
//			}
		}
	}

	
 }
