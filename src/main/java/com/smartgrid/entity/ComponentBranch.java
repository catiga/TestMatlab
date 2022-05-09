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
@Table(name = "p_component_branch_info")
public class ComponentBranch implements Serializable {
	
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "proj_id")
	private Long projId;
	
	@Column(name = "serial_number")
	private Integer serial_number;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "first_node")
	private Integer first_node;
	
	@Column(name = "last_node")
	private Integer last_node;
	
	@Column(name = "type")
	private Integer type;
	
	@Column(name = "run_state")
	private Integer run_state;
	
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

	public Integer getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(Integer serial_number) {
		this.serial_number = serial_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFirst_node() {
		return first_node;
	}

	public void setFirst_node(Integer first_node) {
		this.first_node = first_node;
	}

	public Integer getLast_node() {
		return last_node;
	}

	public void setLast_node(Integer last_node) {
		this.last_node = last_node;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getRun_state() {
		return run_state;
	}

	public void setRun_state(Integer run_state) {
		this.run_state = run_state;
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
