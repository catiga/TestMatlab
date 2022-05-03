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
@Table(name = "p_tw_transformer_info")
public class Tw_transformer implements Serializable {
	
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
	
	@Column(name = "v0_tap1")
	private BigDecimal v0_tap1;
	
	@Column(name = "v0_tap2")
	private BigDecimal v0_tap2;

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

	public BigDecimal getV0_tap1() {
		return v0_tap1;
	}

	public void setV0_tap1(BigDecimal v0_tap1) {
		this.v0_tap1 = v0_tap1;
	}

	public BigDecimal getV0_tap2() {
		return v0_tap2;
	}

	public void setV0_tap2(BigDecimal v0_tap2) {
		this.v0_tap2 = v0_tap2;
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

