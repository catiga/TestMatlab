package com.smartgrid.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c1_name_show_level_area")
public class C1NameShowLevel implements Serializable {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "nsla_k")
	private String nslaK;
	
	@Column(name = "nsla_v")
	private String nslaV;
	
	@Column(name = "nsla_index")
	private Integer nslaIndex;
	
	@Column(name = "proj_id")
	private Long projId;
	
	public C1NameShowLevel() {}
	
	public C1NameShowLevel(String k, String v, Integer index, Long projId) {
		this.nslaK = k;
		this.nslaV = v;
		this.nslaIndex = index;
		this.projId = projId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNslaK() {
		return nslaK;
	}

	public void setNslaK(String nslaK) {
		this.nslaK = nslaK;
	}

	public String getNslaV() {
		return nslaV;
	}

	public void setNslaV(String nslaV) {
		this.nslaV = nslaV;
	}

	public Integer getNslaIndex() {
		return nslaIndex;
	}

	public void setNslaIndex(Integer nslaIndex) {
		this.nslaIndex = nslaIndex;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}
	
}
