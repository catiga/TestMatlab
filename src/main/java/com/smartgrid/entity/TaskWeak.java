package com.smartgrid.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_weak_info")
public class TaskWeak implements Serializable {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "proj_id")
	private Long projId;
	
	private String title;
	
	@Column(name = "a_time")
	private Date aTIme;
	
	private Integer flag;
	
	private Integer computing;
	
	@Column(name = "topo_id")
	private Long topoId;
	
	@Column(name = "topo_method")
	private String topoMethod;

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

	public Date getaTIme() {
		return aTIme;
	}

	public void setaTIme(Date aTIme) {
		this.aTIme = aTIme;
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

	public Long getTopoId() {
		return topoId;
	}

	public void setTopoId(Long topoId) {
		this.topoId = topoId;
	}

	public String getTopoMethod() {
		return topoMethod;
	}

	public void setTopoMethod(String topoMethod) {
		this.topoMethod = topoMethod;
	}
	
}
