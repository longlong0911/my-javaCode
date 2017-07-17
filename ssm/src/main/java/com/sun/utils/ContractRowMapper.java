package com.sun.utils;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.sun.entity.Contract;

public class ContractRowMapper implements RowMapper<Contract>{

	public Contract mapRow(ResultSet rs, int index) throws SQLException {
	  Contract contract = new Contract();
	  
	  contract.setId(rs.getString("contract_id"));
	  contract.setOfferor(rs.getString("offeror"));
	  contract.setContractNo(rs.getString("contract_no"));
	  contract.setInputBy(rs.getString("input_by"));
	  contract.setCheckBy(rs.getString("check_by"));
	  contract.setInspector(rs.getString("inspector"));
	  contract.setCustomName(rs.getString("custom_name"));
	  contract.setCrequest(rs.getString("crequest"));
	  contract.setTradeTerns(rs.getString("trade_terns"));
	  contract.setRemark(rs.getString("remark"));
	  contract.setPrintStyle(rs.getString("print_style"));
	  contract.setCreateBy(rs.getString("create_by"));
	  contract.setCreateDept(rs.getString("create_dept"));
	 
	  contract.setTotalAmount(rs.getBigDecimal("total_amount"));
	  contract.setImportNum(rs.getBigDecimal("import_num"));
	  contract.setOldState(rs.getBigDecimal("old_state"));
	  contract.setOutState(rs.getBigDecimal("out_state"));
	  contract.setSigningDate(rs.getDate("signing_date"));
	  contract.setDeliveryPeriod(rs.getDate("delivery_period"));
	  contract.setShipTime(rs.getDate("ship_time"));
	  contract.setCreateTime(rs.getDate("create_time"));
	  contract.setState(rs.getInt("state")); //0草稿 1上报

		
		return contract;
	}
	
}
