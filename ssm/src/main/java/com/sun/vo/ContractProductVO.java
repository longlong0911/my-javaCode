package com.sun.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.sun.entity.Contract;
import com.sun.entity.ExtCproduct;
import com.sun.entity.Factory;

public class ContractProductVO implements Serializable {
    private String id;
    private String contractId;
    private String factoryId;
    private String factoryName;
    private String productNo;
    private String productImage;
    private String productDesc;
    private BigDecimal cnumber;
    private BigDecimal outNumber;
    private String loadingRate;
    private BigDecimal boxNum;
    private String packingUnit;
    private BigDecimal price;
    private BigDecimal amount;
    private BigDecimal finished;
    private String exts;
    private BigDecimal orderNo;
    
    private Contract contract;
    private Factory factory;
    private List<ExtCproduct> extCproducts;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public BigDecimal getCnumber() {
		return cnumber;
	}
	public void setCnumber(BigDecimal cnumber) {
		this.cnumber = cnumber;
	}
	public BigDecimal getOutNumber() {
		return outNumber;
	}
	public void setOutNumber(BigDecimal outNumber) {
		this.outNumber = outNumber;
	}
	public String getLoadingRate() {
		return loadingRate;
	}
	public void setLoadingRate(String loadingRate) {
		this.loadingRate = loadingRate;
	}
	public BigDecimal getBoxNum() {
		return boxNum;
	}
	public void setBoxNum(BigDecimal boxNum) {
		this.boxNum = boxNum;
	}
	public String getPackingUnit() {
		return packingUnit;
	}
	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getFinished() {
		return finished;
	}
	public void setFinished(BigDecimal finished) {
		this.finished = finished;
	}
	public String getExts() {
		return exts;
	}
	public void setExts(String exts) {
		this.exts = exts;
	}
	public BigDecimal getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(BigDecimal orderNo) {
		this.orderNo = orderNo;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public Factory getFactory() {
		return factory;
	}
	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	public List<ExtCproduct> getExtCproducts() {
		return extCproducts;
	}
	public void setExtCproducts(List<ExtCproduct> extCproducts) {
		this.extCproducts = extCproducts;
	}
    
    

}