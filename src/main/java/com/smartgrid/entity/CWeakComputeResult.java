package com.smartgrid.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cweak_compute_result")
public class CWeakComputeResult implements Serializable {
	
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "task_id")
	private Long taskId;
	
	@Column(name = "proj_id")
	private Long projId;
	
	@Column(name = "weak_load")
	private String weakLoad;
	
	@Column(name = "weak_voltage")
	private String weakVoltage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}

	public String getWeakLoad() {
		return weakLoad;
	}

	public void setWeakLoad(String weakLoad) {
		this.weakLoad = weakLoad;
	}

	public String getWeakVoltage() {
		return weakVoltage;
	}

	public void setWeakVoltage(String weakVoltage) {
		this.weakVoltage = weakVoltage;
	}
	
}
