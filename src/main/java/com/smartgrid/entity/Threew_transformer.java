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
@Table(name = "p_threew_transformer_info_info")
public class Threew_transformer implements Serializable {
	
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "proj_id")
	private Long projId;
	
	@Column(name = "name_1")
	private String name_1;
	
	@Column(name = "name_2")
	private String name_2;
	
	@Column(name = "name_3")
	private String name_3;
	
	@Column(name = "tap1")
	private BigDecimal tap1;

	@Column(name = "tap2")
	private BigDecimal tap2;
	
	@Column(name = "tap3")
	private BigDecimal tap3;	
	
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

	public String getName_1() {
		return name_1;
	}

	public void setName_1(String name_1) {
		this.name_1 = name_1;
	}

	public String getName_2() {
		return name_2;
	}

	public void setName_2(String name_2) {
		this.name_2 = name_2;
	}

	public String getName_3() {
		return name_3;
	}

	public void setName_3(String name_3) {
		this.name_3 = name_3;
	}

	public BigDecimal getTap1() {
		return tap1;
	}

	public void setTap1(BigDecimal tap1) {
		this.tap1 = tap1;
	}

	public BigDecimal getTap2() {
		return tap2;
	}

	public void setTap2(BigDecimal tap2) {
		this.tap2 = tap2;
	}

	public BigDecimal getTap3() {
		return tap3;
	}

	public void setTap3(BigDecimal tap3) {
		this.tap3 = tap3;
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

