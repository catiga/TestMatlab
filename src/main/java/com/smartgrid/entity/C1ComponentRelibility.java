package com.smartgrid.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c1_component_relibility")
public class C1ComponentRelibility implements Serializable {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "cr_1")
	private BigDecimal cr1;
	
	@Column(name = "cr_2")
	private BigDecimal cr2;
	
	@Column(name = "proj_id")
	private Long projId;
	
	public C1ComponentRelibility(double[] _13data, Long projId) {
		if(_13data.length==2) {
			this.cr1 = new BigDecimal(_13data[0]);
			this.cr2 = new BigDecimal(_13data[1]);
		}
		this.projId = projId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCr1() {
		return cr1;
	}

	public void setCr1(BigDecimal cr1) {
		this.cr1 = cr1;
	}

	public BigDecimal getCr2() {
		return cr2;
	}

	public void setCr2(BigDecimal cr2) {
		this.cr2 = cr2;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}
	
}
