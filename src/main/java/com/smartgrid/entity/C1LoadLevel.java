package com.smartgrid.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c1_load_level_area")
public class C1LoadLevel implements Serializable {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "lla_1")
	private BigDecimal lla1;
	
	@Column(name = "lla_2")
	private BigDecimal lla2;
	
	@Column(name = "lla_3")
	private BigDecimal lla3;
	
	@Column(name = "proj_id")
	private Long projId;
	
	public C1LoadLevel(double[] _13data, Long projId) {
		if(_13data.length==3) {
			this.lla1 = new BigDecimal(_13data[0]);
			this.lla2 = new BigDecimal(_13data[1]);
			this.lla3 = new BigDecimal(_13data[2]);
		}
		this.projId = projId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getLla1() {
		return lla1;
	}

	public void setLla1(BigDecimal lla1) {
		this.lla1 = lla1;
	}

	public BigDecimal getLla2() {
		return lla2;
	}

	public void setLla2(BigDecimal lla2) {
		this.lla2 = lla2;
	}

	public BigDecimal getLla3() {
		return lla3;
	}

	public void setLla3(BigDecimal lla3) {
		this.lla3 = lla3;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}
	
}
