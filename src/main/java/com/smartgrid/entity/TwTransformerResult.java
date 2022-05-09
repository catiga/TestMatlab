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
@Table(name = "p_tw_transformer_result_info")
public class TwTransformerResult implements Serializable {
	
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "proj_id")
	private Long projId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "j_cmx")
	private String j_cmx;
	
	@Column(name = "c_active_power_generation")
	private BigDecimal c_active_power_generation;
	
	@Column(name = "c_reactive_power_generation")
	private BigDecimal c_reactive_power_generation;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJ_cmx() {
		return j_cmx;
	}

	public void setJ_cmx(String j_cmx) {
		this.j_cmx = j_cmx;
	}

	public BigDecimal getC_active_power_generation() {
		return c_active_power_generation;
	}

	public void setC_active_power_generation(BigDecimal c_active_power_generation) {
		this.c_active_power_generation = c_active_power_generation;
	}

	public BigDecimal getC_reactive_power_generation() {
		return c_reactive_power_generation;
	}

	public void setC_reactive_power_generation(BigDecimal c_reactive_power_generation) {
		this.c_reactive_power_generation = c_reactive_power_generation;
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
