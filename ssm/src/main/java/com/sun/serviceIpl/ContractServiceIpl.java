package com.sun.serviceIpl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.dao.ContractMapper;
import com.sun.dao.ContractProductMapper;
import com.sun.dao.ExtCproductMapper;
import com.sun.entity.Contract;
import com.sun.serviceI.ContractServiceI;
import com.sun.utils.ContractRowMapper;
import com.sun.vo.ContractVO;


@Service
@Transactional
public class ContractServiceIpl implements ContractServiceI{
	@Resource
	private ContractMapper contractMapper;
	@Resource
	private ContractProductMapper contractProductMapper;
	@Resource
	private ExtCproductMapper extCproductMapper;
	@Resource
	private JdbcTemplate template;
	
	@Override
	public ContractVO findVO(String contractId) {
		return contractMapper.selectView(contractId);
	}
	@Override
	public Contract findById(String id) {
		return contractMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<Contract> findAll() {
		return contractMapper.getAll();
	}

	@Override
	public void addContract(Contract contract) {
		contract.setId(UUID.randomUUID().toString());
		contract.setState(0); 
		contractMapper.insert(contract);
	}
	@Override
	public void deleteById(String id) {
		contractMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void deleteByIds(String[] ids) {
		contractMapper.delete(ids);
	}
	@Override
	public void updateContract(Contract contract) {
		contract.setState(0);
		contractMapper.updateByPrimaryKey(contract);
		
	}
	
	@Override
	public void contractStateOpen(String[] ids) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state",1);
		map.put("ids",ids);
		contractMapper.updateState(map);
	}
	@Override
	public void deleteByContractId(String contractId) {
		extCproductMapper.deleteByContractId(contractId);
		contractProductMapper.deleteByContractId(contractId);
		contractMapper.deleteByContractId(contractId);
	}
	@Override
	public void contractStateClose(String[] ids) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state",0);
		map.put("ids",ids);
		contractMapper.updateState(map);
	}
	
	@Override
	public void intoHis(String[] ids) {
		
		for(String id : ids){
			//向历史表中插入数据
			String sqlHisContract = "insert into contract_his_c  (select * from contract_c where contract_id=?)";
			String sqlHisContractProduct = "insert into contractproduct_his_c  (select * from contract_product_c where contract_id=?)";
			String sqlHisExtCproduct = "insert into ext_cproduct_his_c (select * from ext_cproduct_c where contract_product_id in (select contract_product_id from contract_product_c where contract_id=?))";

			String sqlExtCproduct = "delete from ext_cproduct_c   where contract_product_id in (select contract_product_id from contract_product_c where contract_id =?)";
			String sqlContractProduct = "delete from contract_product_c   where contract_id=?";
			String sqlContract = "delete from contract_c  where contract_id=?";
			
			Object[] obj = {id};
			
			template.update(sqlHisContract,obj);
			template.update(sqlHisContractProduct,obj);
			template.update(sqlHisExtCproduct,obj);
		
			template.update(sqlExtCproduct,obj);
			template.update(sqlContractProduct,obj);
			template.update(sqlContract,obj);
		}
	}
	
	@Override
	public void intoFrom(String[] ids) {
		
		for(String id : ids){
			//向原始表表中插入数据
			String sqlContract = "insert into contract_c  (select * from contract_his_c where contract_id=?)";
			String sqlContractProduct = "insert into contract_product_c  (select * from contractproduct_his_c where contract_id=?)";
			String sqlExtCproduct = "insert into ext_cproduct_c (select * from ext_cproduct_his_c where contract_product_id in (select contract_product_id from contractproduct_his_c where contract_id=?))";

			String sqlHisExtCproduct = "delete from ext_cproduct_his_c where contract_product_id in (select contract_product_id from contractproduct_his_c where contract_id=?)";
			String sqlHisContractProduct = "delete from contractproduct_his_c  where contract_id=?";
			String sqlHisContract = "delete from contract_his_c  where contract_id=?";
			
			
			Object[] obj = {id};
			template.update(sqlContract,obj);
			template.update(sqlContractProduct,obj);
			template.update(sqlExtCproduct,obj);
			
			template.update(sqlHisExtCproduct,obj);
			template.update(sqlHisContractProduct,obj);
			template.update(sqlHisContract,obj);
		
		}
	}

	@Override
	public List<Contract> findHisContract() {

		String sql = "select * from contract_his_c";
		ContractRowMapper rowMapper = new ContractRowMapper();
		List<Contract> contractList = template.query(sql, rowMapper);
		return contractList;
	}
	
	
	
}
