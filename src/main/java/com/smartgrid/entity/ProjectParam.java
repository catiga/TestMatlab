package com.smartgrid.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project_params")
public class ProjectParam implements Serializable {
	
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "proj_id")
	private Long projId;
	
	@Column(name = "param_v")
	private BigDecimal paramV;
	
	@Column(name = "param_k")
	private String paramK;
	
	@Column(name = "flag")
	private Integer flag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}

	public BigDecimal getParamV() {
		return paramV;
	}

	public void setParamV(BigDecimal paramV) {
		this.paramV = paramV;
	}

	public String getParamK() {
		return paramK;
	}

	public void setParamK(String paramK) {
		this.paramK = paramK;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
}
