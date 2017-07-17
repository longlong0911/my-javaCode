package com.sun.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Code implements Serializable {
    private String id;
    private String name;
    private String parentId;
    private String parentName;
    private BigDecimal layerNum;
    private BigDecimal isLeaf;
    private BigDecimal quoteNum;
    private String cnote;
    private String ico;
    private BigDecimal orderNo;
    private String state;
    private String createdBy;
    private Date createdTime;
    private String updateBy;
    private Date updatetime;

    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }

    public BigDecimal getLayerNum() {
        return layerNum;
    }

    public void setLayerNum(BigDecimal layerNum) {
        this.layerNum = layerNum;
    }

    public BigDecimal getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(BigDecimal isLeaf) {
        this.isLeaf = isLeaf;
    }

    public BigDecimal getQuoteNum() {
        return quoteNum;
    }

    public void setQuoteNum(BigDecimal quoteNum) {
        this.quoteNum = quoteNum;
    }

    public String getCnote() {
        return cnote;
    }

    public void setCnote(String cnote) {
        this.cnote = cnote == null ? null : cnote.trim();
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico == null ? null : ico.trim();
    }

    public BigDecimal getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(BigDecimal orderNo) {
        this.orderNo = orderNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}