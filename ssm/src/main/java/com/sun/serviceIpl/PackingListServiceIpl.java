package com.sun.serviceIpl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.dao.ExportMapper;
import com.sun.dao.PackingListMapper;
import com.sun.entity.Export;
import com.sun.entity.PackingList;
import com.sun.serviceI.PackingListServiceI;


@Service
@Transactional
public class PackingListServiceIpl implements PackingListServiceI{
	
	@Resource
	private PackingListMapper packingListMapper;
	@Resource
	private ExportMapper exportMapper;
	
	
	@Override
	public PackingList findById(String id) {
		return packingListMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PackingList> findAll() {
		return packingListMapper.find();
	}

	@Override
	public void addPackingList(PackingList packingList) {
		packingList.setId(UUID.randomUUID().toString());
		//处理状态流转
		//1.查出装箱关联多个报运，2.将它们的状态都修改为2-装箱
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state", 2);			//2-装箱
		map.put("ids",packingList.getExportIds().split("\\|"));	//报运ids
		
		exportMapper.updateState(map);

		packingListMapper.insert(packingList);
	}

	@Override
	public void deleteById(String id) {
		packingListMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByIds(String[] ids) {
		for(String id : ids){
			packingListMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public void updatePackingList(PackingList packingList) {
		packingListMapper.updateByPrimaryKey(packingList);
	}
	
	public String findCustomerContract(String[] ids){
		StringBuffer buf = new StringBuffer();
		for(int i=0;i<ids.length;i++){
			Export export = exportMapper.selectByPrimaryKey(ids[i]);
			buf.append("<input type=\"checkbox\" name=\"exportIds\" value=\"")
				.append(ids[i]).append("|")
				.append(export.getCustomerContract())
				.append("\" checked class=\"input\"/>");
			buf.append(export.getCustomerContract()).append("&nbsp&nbsp;");
		}
		
		return buf.toString();
	}
	
	
}
