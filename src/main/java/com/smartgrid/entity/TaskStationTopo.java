package com.smartgrid.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_station_topo")
public class TaskStationTopo implements Serializable {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "proj_id")
	private Long projId;
	
	private String title;
	
	@Column(name = "fix_type")
	private String fixType;
	
	@Column(name = "a_time")
	private Date aTime;
	
	private Integer flag;
	
	private Integer computing;
	
	@Column(name = "topo_list")
	private String topoList;
	
	@Column(name = "node_list")
	private String nodeList;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFixType() {
		return fixType;
	}

	public void setFixType(String fixType) {
		this.fixType = fixType;
	}

	public Date getaTime() {
		return aTime;
	}

	public void setaTime(Date aTime) {
		this.aTime = aTime;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getComputing() {
		return computing;
	}

	public void setComputing(Integer computing) {
		this.computing = computing;
	}

	public String getTopoList() {
		return topoList;
	}

	public void setTopoList(String topoList) {
		this.topoList = topoList;
	}

	public String getNodeList() {
		return nodeList;
	}

	public void setNodeList(String nodeList) {
		this.nodeList = nodeList;
	}
	
}
