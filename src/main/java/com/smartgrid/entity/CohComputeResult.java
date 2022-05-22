package com.smartgrid.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coh_compute_result")
public class CohComputeResult implements Serializable {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "task_id")
	private Long taskId;
	
	@Column(name = "proj_id")
	private Long projId;
	
	@Column(name = "best_case")
	private String bestCase;
	
	@Column(name = "input_data_best")
	private String inputDataBest;
	
	@Column(name = "case_output_best")
	private String caseOutputBest;

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

	public String getBestCase() {
		return bestCase;
	}

	public void setBestCase(String bestCase) {
		this.bestCase = bestCase;
	}

	public String getInputDataBest() {
		return inputDataBest;
	}

	public void setInputDataBest(String inputDataBest) {
		this.inputDataBest = inputDataBest;
	}

	public String getCaseOutputBest() {
		return caseOutputBest;
	}

	public void setCaseOutputBest(String caseOutputBest) {
		this.caseOutputBest = caseOutputBest;
	}
	
}
