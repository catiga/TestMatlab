package com.smartgrid.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cpf_compute_result")
public class CpfComputeResult implements Serializable {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "proj_id")
	private Long projId;
	
	@Column(name = "task_id")
	private Long taskId;
	
	@Column(name = "base_mva")
	private BigDecimal baseMva;
	
	private String bus;
	
	private String branch;
	
	private String gen;
	
	private Integer success;
	
	private BigDecimal et;
	
	@Column(name = "bus_name")
	private String busName;
	
	@Column(name = "branch_fname")
	private String branchFname;
	
	@Column(name = "branch_tname")
	private String branchTname;
	
	@Column(name = "gen_name")
	private String genName;

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

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public BigDecimal getBaseMva() {
		return baseMva;
	}

	public void setBaseMva(BigDecimal baseMva) {
		this.baseMva = baseMva;
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public Integer getSuccess() {
		return success;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

	public BigDecimal getEt() {
		return et;
	}

	public void setEt(BigDecimal et) {
		this.et = et;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBranchFname() {
		return branchFname;
	}

	public void setBranchFname(String branchFname) {
		this.branchFname = branchFname;
	}

	public String getBranchTname() {
		return branchTname;
	}

	public void setBranchTname(String branchTname) {
		this.branchTname = branchTname;
	}

	public String getGenName() {
		return genName;
	}

	public void setGenName(String genName) {
		this.genName = genName;
	}
	
}
