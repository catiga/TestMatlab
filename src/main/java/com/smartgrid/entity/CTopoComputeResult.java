package com.smartgrid.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ctopo_compute_result")
public class CTopoComputeResult implements Serializable {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "proj_id")
	private Long projId;
	
	@Column(name = "task_id")
	private Long taskId;
	
	@Column(name = "nodes_type")
	private String nodesType;
	
	@Column(name = "bus_maintance_sets_3d")
	private String busMaintanceSets3d;
	
	@Column(name = "branch_maintance_sets_3d")
	private String branchMaintanceSets3d;
	
	@Column(name = "gen_maintance_sets_3d")
	private String genMaintanceSets3d;
	
	@Column(name = "branch_type")
	private String branchType;
	
	@Column(name = "branch_numbers")
	private String branchNumbers;
	
	@Column(name = "num_topo_maintance")
	private Integer numTopoMaintance;
	
	@Column(name = "flag_connect")
	private Integer flagConnect;
	
	@Column(name = "case_output")
	private String caseOutput;
	
	@Column(name = "interrup_nodes_counterbusname")
	private String interrupNodes;

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

	public String getNodesType() {
		return nodesType;
	}

	public void setNodesType(String nodesType) {
		this.nodesType = nodesType;
	}

	public String getBusMaintanceSets3d() {
		return busMaintanceSets3d;
	}

	public void setBusMaintanceSets3d(String busMaintanceSets3d) {
		this.busMaintanceSets3d = busMaintanceSets3d;
	}

	public String getBranchMaintanceSets3d() {
		return branchMaintanceSets3d;
	}

	public void setBranchMaintanceSets3d(String branchMaintanceSets3d) {
		this.branchMaintanceSets3d = branchMaintanceSets3d;
	}

	public String getGenMaintanceSets3d() {
		return genMaintanceSets3d;
	}

	public void setGenMaintanceSets3d(String genMaintanceSets3d) {
		this.genMaintanceSets3d = genMaintanceSets3d;
	}

	public String getBranchType() {
		return branchType;
	}

	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}

	public String getBranchNumbers() {
		return branchNumbers;
	}

	public void setBranchNumbers(String branchNumbers) {
		this.branchNumbers = branchNumbers;
	}

	public Integer getNumTopoMaintance() {
		return numTopoMaintance;
	}

	public void setNumTopoMaintance(Integer numTopoMaintance) {
		this.numTopoMaintance = numTopoMaintance;
	}

	public Integer getFlagConnect() {
		return flagConnect;
	}

	public void setFlagConnect(Integer flagConnect) {
		this.flagConnect = flagConnect;
	}

	public String getCaseOutput() {
		return caseOutput;
	}

	public void setCaseOutput(String caseOutput) {
		this.caseOutput = caseOutput;
	}

	public String getInterrupNodes() {
		return interrupNodes;
	}

	public void setInterrupNodes(String interrupNodes) {
		this.interrupNodes = interrupNodes;
	}
	
}
