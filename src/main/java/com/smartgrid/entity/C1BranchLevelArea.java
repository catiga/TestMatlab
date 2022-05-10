package com.smartgrid.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c1_branch_level_area")
public class C1BranchLevelArea implements Serializable {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "bla_1")
	private BigDecimal bla1;
	
	@Column(name = "bla_2")
	private BigDecimal bla2;
	
	@Column(name = "bla_3")
	private BigDecimal bla3;
	
	@Column(name = "bla_4")
	private BigDecimal bla4;
	
	@Column(name = "bla_5")
	private BigDecimal bla5;
	
	@Column(name = "bla_6")
	private BigDecimal bla6;
	
	@Column(name = "bla_7")
	private BigDecimal bla7;
	
	@Column(name = "bla_8")
	private BigDecimal bla8;
	
	@Column(name = "bla_9")
	private BigDecimal bla9;
	
	@Column(name = "bla_10")
	private BigDecimal bla10;
	
	@Column(name = "bla_11")
	private BigDecimal bla11;
	
	@Column(name = "bla_12")
	private BigDecimal bla12;
	
	@Column(name = "bla_13")
	private BigDecimal bla13;
	
	@Column(name = "proj_id")
	private Long projId;
	
	public C1BranchLevelArea() {}
	
	public C1BranchLevelArea(double[] _13data, Long projId) {
		if(_13data.length==13) {
			this.bla1 = new BigDecimal(_13data[0]);
			this.bla2 = new BigDecimal(_13data[1]);
			this.bla3 = new BigDecimal(_13data[2]);
			this.bla4 = new BigDecimal(_13data[3]);
			this.bla5 = new BigDecimal(_13data[4]);
			this.bla6 = new BigDecimal(_13data[5]);
			this.bla7 = new BigDecimal(_13data[6]);
			this.bla8 = new BigDecimal(_13data[7]);
			this.bla9 = new BigDecimal(_13data[8]);
			this.bla10 = new BigDecimal(_13data[9]);
			this.bla11 = new BigDecimal(_13data[10]);
			this.bla12 = new BigDecimal(_13data[11]);
			this.bla13 = new BigDecimal(_13data[12]);
		}
		this.projId = projId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBla1() {
		return bla1;
	}

	public void setBla1(BigDecimal bla1) {
		this.bla1 = bla1;
	}

	public BigDecimal getBla2() {
		return bla2;
	}

	public void setBla2(BigDecimal bla2) {
		this.bla2 = bla2;
	}

	public BigDecimal getBla3() {
		return bla3;
	}

	public void setBla3(BigDecimal bla3) {
		this.bla3 = bla3;
	}

	public BigDecimal getBla4() {
		return bla4;
	}

	public void setBla4(BigDecimal bla4) {
		this.bla4 = bla4;
	}

	public BigDecimal getBla5() {
		return bla5;
	}

	public void setBla5(BigDecimal bla5) {
		this.bla5 = bla5;
	}

	public BigDecimal getBla6() {
		return bla6;
	}

	public void setBla6(BigDecimal bla6) {
		this.bla6 = bla6;
	}

	public BigDecimal getBla7() {
		return bla7;
	}

	public void setBla7(BigDecimal bla7) {
		this.bla7 = bla7;
	}

	public BigDecimal getBla8() {
		return bla8;
	}

	public void setBla8(BigDecimal bla8) {
		this.bla8 = bla8;
	}

	public BigDecimal getBla9() {
		return bla9;
	}

	public void setBla9(BigDecimal bla9) {
		this.bla9 = bla9;
	}

	public BigDecimal getBla10() {
		return bla10;
	}

	public void setBla10(BigDecimal bla10) {
		this.bla10 = bla10;
	}

	public BigDecimal getBla11() {
		return bla11;
	}

	public void setBla11(BigDecimal bla11) {
		this.bla11 = bla11;
	}

	public BigDecimal getBla12() {
		return bla12;
	}

	public void setBla12(BigDecimal bla12) {
		this.bla12 = bla12;
	}

	public BigDecimal getBla13() {
		return bla13;
	}

	public void setBla13(BigDecimal bla13) {
		this.bla13 = bla13;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}
	
}
