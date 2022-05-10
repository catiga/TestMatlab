package com.smartgrid.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c1_ table_nodes_level_province_area")
public class C1TableProvinceArea {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private BigDecimal v1;
	
	private String v2;
	
	private BigDecimal v3;
	
	@Column(name = "proj_id")
	private Long projId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getV1() {
		return v1;
	}

	public void setV1(BigDecimal v1) {
		this.v1 = v1;
	}

	public String getV2() {
		return v2;
	}

	public void setV2(String v2) {
		this.v2 = v2;
	}

	public BigDecimal getV3() {
		return v3;
	}

	public void setV3(BigDecimal v3) {
		this.v3 = v3;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}
	
}
