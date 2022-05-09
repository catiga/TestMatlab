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
@Table(name = "p_alternator_result_info")
public class AlternatorResult implements Serializable {
	
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "proj_id")
	private Long projId;
	
	@Column(name = "alternator_name")
	private String alternator_name;
	
	@Column(name = "moline_name")
	private String moline_name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "active_power_generation")
	private BigDecimal active_power_generation;
	
	@Column(name = "reactive_power_generation")
	private BigDecimal reactive_power_generation;
	
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

	public String getAlternator_name() {
		return alternator_name;
	}

	public void setAlternator_name(String alternator_name) {
		this.alternator_name = alternator_name;
	}

	public String getMoline_name() {
		return moline_name;
	}

	public void setMoline_name(String moline_name) {
		this.moline_name = moline_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getActive_power_generation() {
		return active_power_generation;
	}

	public void setActive_power_generation(BigDecimal active_power_generation) {
		this.active_power_generation = active_power_generation;
	}

	public BigDecimal getReactive_power_generation() {
		return reactive_power_generation;
	}

	public void setReactive_power_generation(BigDecimal reactive_power_generation) {
		this.reactive_power_generation = reactive_power_generation;
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
