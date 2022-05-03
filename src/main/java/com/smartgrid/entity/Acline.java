package com.smartgrid.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "p_acline_info")
public class Acline implements Serializable {
	
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "proj_id")
	private Long projId;
	
	@Column(name = "l_name")
	private String lname;
	
	@Column(name = "j_name")
	private String j_name;
	
	@Column(name = "id_no")
	private Long id_no;
	
	@Column(name = "r1")
	private BigDecimal r1;
	
	@Column(name = "x1")
	private BigDecimal x1;
	
	@Column(name = "b1_half")
	private BigDecimal b1_half;
	
	@Column(name = "rate_ka")
	private BigDecimal rate_ka;
	
	@Column(name = "up_limit")
	private BigDecimal up_limit;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "flag")
	private Integer flag;
	
	@Column(name = "a_time")
	private Date aTime;

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

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getJ_name() {
		return j_name;
	}

	public void setJ_name(String j_name) {
		this.j_name = j_name;
	}

	public Long getId_no() {
		return id_no;
	}

	public void setId_no(Long id_no) {
		this.id_no = id_no;
	}

	public BigDecimal getR1() {
		return r1;
	}

	public void setR1(BigDecimal r1) {
		this.r1 = r1;
	}

	public BigDecimal getX1() {
		return x1;
	}

	public void setX1(BigDecimal x1) {
		this.x1 = x1;
	}

	public BigDecimal getB1_half() {
		return b1_half;
	}

	public void setB1_half(BigDecimal b1_half) {
		this.b1_half = b1_half;
	}

	public BigDecimal getRate_ka() {
		return rate_ka;
	}

	public void setRate_ka(BigDecimal rate_ka) {
		this.rate_ka = rate_ka;
	}

	public BigDecimal getUp_limit() {
		return up_limit;
	}

	public void setUp_limit(BigDecimal up_limit) {
		this.up_limit = up_limit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Date getaTime() {
		return aTime;
	}

	public void setaTime(Date aTime) {
		this.aTime = aTime;
	}
	
}
