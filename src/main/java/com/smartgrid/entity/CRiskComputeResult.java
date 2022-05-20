package com.smartgrid.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crisk_compute_result")
public class CRiskComputeResult implements Serializable {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "proj_id")
	private Long projId;
	
	@Column(name = "task_id")
	private Long taskId;
	
	private BigDecimal mfs;
	
	private BigDecimal eo;
	
	private BigDecimal mhvs;
	
	private BigDecimal mlvs;
	
	private BigDecimal ehvv;
	
	private BigDecimal elvv;

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

	public BigDecimal getMfs() {
		return mfs;
	}

	public void setMfs(BigDecimal mfs) {
		this.mfs = mfs;
	}

	public BigDecimal getEo() {
		return eo;
	}

	public void setEo(BigDecimal eo) {
		this.eo = eo;
	}

	public BigDecimal getMhvs() {
		return mhvs;
	}

	public void setMhvs(BigDecimal mhvs) {
		this.mhvs = mhvs;
	}

	public BigDecimal getMlvs() {
		return mlvs;
	}

	public void setMlvs(BigDecimal mlvs) {
		this.mlvs = mlvs;
	}

	public BigDecimal getEhvv() {
		return ehvv;
	}

	public void setEhvv(BigDecimal ehvv) {
		this.ehvv = ehvv;
	}

	public BigDecimal getElvv() {
		return elvv;
	}

	public void setElvv(BigDecimal elvv) {
		this.elvv = elvv;
	}
	
}
