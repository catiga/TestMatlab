package com.smartgrid.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_loadflow_info")
public class TaskLoadFlow implements Serializable {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String info;
	
	private String method;
	
	@Column(name = "allow_err")
	private String allowErr;
	
	@Column(name = "iterate_limit")
	private Integer iterateLimit;
	
	@Column(name = "a_time")
	private Date aTIme;
	
	private Integer flag = 0;
	
	@Column(name = "proj_id")
	private Long projId;
	
	private Integer computing;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getAllowErr() {
		return allowErr;
	}

	public void setAllowErr(String allowErr) {
		this.allowErr = allowErr;
	}

	public Integer getIterateLimit() {
		return iterateLimit;
	}

	public void setIterateLimit(Integer iterateLimit) {
		this.iterateLimit = iterateLimit;
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

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}

	public Integer getComputing() {
		return computing;
	}

	public void setComputing(Integer computing) {
		this.computing = computing;
	}
	
}
