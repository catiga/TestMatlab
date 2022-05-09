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
@Table(name = "p_threew_transformer_result_info")
public class ThreewTransformerResult implements Serializable {
	
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "proj_id")
	private Long projId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "side_bus1")
	private String side_bus1;
	
	@Column(name = "side_bus2")
	private String side_bus2;
	
	@Column(name = "side_bus3")
	private String side_bus3;
	
	@Column(name = "active_power_generation1")
	private BigDecimal active_power_generation1;
	
	@Column(name = "reactive_power_generation1")
	private BigDecimal reactive_power_generation1;
	
	@Column(name = "active_power_generation2")
	private BigDecimal active_power_generation2;
	
	@Column(name = "reactive_power_generation2")
	private BigDecimal reactive_power_generation2;
	
	@Column(name = "active_power_generation3")
	private BigDecimal active_power_generation3;
	
	@Column(name = "reactive_power_generation3")
	private BigDecimal reactive_power_generation3;
	
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

	public String getSide_bus1() {
		return side_bus1;
	}

	public void setSide_bus1(String side_bus1) {
		this.side_bus1 = side_bus1;
	}

	public String getSide_bus2() {
		return side_bus2;
	}

	public void setSide_bus2(String side_bus2) {
		this.side_bus2 = side_bus2;
	}

	public String getSide_bus3() {
		return side_bus3;
	}

	public void setSide_bus3(String side_bus3) {
		this.side_bus3 = side_bus3;
	}

	public BigDecimal getActive_power_generation1() {
		return active_power_generation1;
	}

	public void setActive_power_generation1(BigDecimal active_power_generation1) {
		this.active_power_generation1 = active_power_generation1;
	}

	public BigDecimal getReactive_power_generation1() {
		return reactive_power_generation1;
	}

	public void setReactive_power_generation1(BigDecimal reactive_power_generation1) {
		this.reactive_power_generation1 = reactive_power_generation1;
	}

	public BigDecimal getActive_power_generation2() {
		return active_power_generation2;
	}

	public void setActive_power_generation2(BigDecimal active_power_generation2) {
		this.active_power_generation2 = active_power_generation2;
	}

	public BigDecimal getReactive_power_generation2() {
		return reactive_power_generation2;
	}

	public void setReactive_power_generation2(BigDecimal reactive_power_generation2) {
		this.reactive_power_generation2 = reactive_power_generation2;
	}

	public BigDecimal getActive_power_generation3() {
		return active_power_generation3;
	}

	public void setActive_power_generation3(BigDecimal active_power_generation3) {
		this.active_power_generation3 = active_power_generation3;
	}

	public BigDecimal getReactive_power_generation3() {
		return reactive_power_generation3;
	}

	public void setReactive_power_generation3(BigDecimal reactive_power_generation3) {
		this.reactive_power_generation3 = reactive_power_generation3;
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
