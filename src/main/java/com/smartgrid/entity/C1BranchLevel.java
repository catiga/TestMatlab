package com.smartgrid.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c1_branch_level")
public class C1BranchLevel implements Serializable {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "bl_1")
	private BigDecimal bl1;
	
	@Column(name = "bl_2")
	private BigDecimal bl2;
	
	@Column(name = "bl_3")
	private BigDecimal bl3;
	
	@Column(name = "bl_4")
	private BigDecimal bl4;
	
	@Column(name = "bl_5")
	private BigDecimal bl5;
	
	@Column(name = "bl_6")
	private BigDecimal bl6;
	
	@Column(name = "bl_7")
	private BigDecimal bl7;
	
	@Column(name = "bl_8")
	private BigDecimal bl8;
	
	@Column(name = "bl_9")
	private BigDecimal bl9;
	
	@Column(name = "bl_10")
	private BigDecimal bl10;
	
	@Column(name = "bl_11")
	private BigDecimal bl11;
	
	@Column(name = "bl_12")
	private BigDecimal bl12;
	
	@Column(name = "bl_13")
	private BigDecimal bl13;
	
	@Column(name = "proj_id")
	private Long projId;
	
	public C1BranchLevel() {}
	
	public C1BranchLevel(double[] _13data, Long projId) {
		if(_13data.length==13) {
			this.bl1 = new BigDecimal(_13data[0]);
			this.bl2 = new BigDecimal(_13data[1]);
			this.bl3 = new BigDecimal(_13data[2]);
			this.bl4 = new BigDecimal(_13data[3]);
			this.bl5 = new BigDecimal(_13data[4]);
			this.bl6 = new BigDecimal(_13data[5]);
			this.bl7 = new BigDecimal(_13data[6]);
			this.bl8 = new BigDecimal(_13data[7]);
			this.bl9 = new BigDecimal(_13data[8]);
			this.bl10 = new BigDecimal(_13data[9]);
			this.bl11 = new BigDecimal(_13data[10]);
			this.bl12 = new BigDecimal(_13data[11]);
			this.bl13 = new BigDecimal(_13data[12]);
		}
		this.projId = projId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBl1() {
		return bl1;
	}

	public void setBl1(BigDecimal bl1) {
		this.bl1 = bl1;
	}

	public BigDecimal getBl2() {
		return bl2;
	}

	public void setBl2(BigDecimal bl2) {
		this.bl2 = bl2;
	}

	public BigDecimal getBl3() {
		return bl3;
	}

	public void setBl3(BigDecimal bl3) {
		this.bl3 = bl3;
	}

	public BigDecimal getBl4() {
		return bl4;
	}

	public void setBl4(BigDecimal bl4) {
		this.bl4 = bl4;
	}

	public BigDecimal getBl5() {
		return bl5;
	}

	public void setBl5(BigDecimal bl5) {
		this.bl5 = bl5;
	}

	public BigDecimal getBl6() {
		return bl6;
	}

	public void setBl6(BigDecimal bl6) {
		this.bl6 = bl6;
	}

	public BigDecimal getBl7() {
		return bl7;
	}

	public void setBl7(BigDecimal bl7) {
		this.bl7 = bl7;
	}

	public BigDecimal getBl8() {
		return bl8;
	}

	public void setBl8(BigDecimal bl8) {
		this.bl8 = bl8;
	}

	public BigDecimal getBl9() {
		return bl9;
	}

	public void setBl9(BigDecimal bl9) {
		this.bl9 = bl9;
	}

	public BigDecimal getBl10() {
		return bl10;
	}

	public void setBl10(BigDecimal bl10) {
		this.bl10 = bl10;
	}

	public BigDecimal getBl11() {
		return bl11;
	}

	public void setBl11(BigDecimal bl11) {
		this.bl11 = bl11;
	}

	public BigDecimal getBl12() {
		return bl12;
	}

	public void setBl12(BigDecimal bl12) {
		this.bl12 = bl12;
	}

	public BigDecimal getBl13() {
		return bl13;
	}

	public void setBl13(BigDecimal bl13) {
		this.bl13 = bl13;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}
	
}
