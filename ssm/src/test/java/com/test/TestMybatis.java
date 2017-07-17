package com.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.entity.Factory;
import com.sun.serviceI.FactoryServiceI;

public class TestMybatis {
	
	@Test
	public void Test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		FactoryServiceI factoryService = (FactoryServiceI) ac.getBean("factoryServiceIpl");
		List<Factory> factoryList = factoryService.findAll();
		
		for(Factory factory : factoryList){
			System.out.println(factory.getFullName());
		}
	}
	
}
