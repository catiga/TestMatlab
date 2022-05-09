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
@Table(name = "p_alternator_trend_info")
public class AlternatorTrend implements Serializable {
	
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "proj_id")
	private Long projId;
	
	@Column(name = "id_name")
	private String id_name;
	
	@Column(name = "valid")
	private Integer valid;
	
	@Column(name = "v0")
	private BigDecimal v0;
	
	@Column(name = "angle")
	private BigDecimal angle;
	
	@Column(name = "qmax")
	private BigDecimal qmax;
	
	@Column(name = "qmin")
	private BigDecimal qmin;
	
	@Column(name = "pmax")
	private BigDecimal pmax;
	
	@Column(name = "pmin")
	private BigDecimal pmin;
	
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

	public String getId_name() {
		return id_name;
	}

	public void setId_name(String id_name) {
		this.id_name = id_name;
	}

	public Integer getValid() {
		return valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public BigDecimal getV0() {
		return v0;
	}

	public void setV0(BigDecimal v0) {
		this.v0 = v0;
	}

	public BigDecimal getAngle() {
		return angle;
	}

	public void setAngle(BigDecimal angle) {
		this.angle = angle;
	}

	public BigDecimal getQmax() {
		return qmax;
	}

	public void setQmax(BigDecimal qmax) {
		this.qmax = qmax;
	}

	public BigDecimal getQmin() {
		return qmin;
	}

	public void setQmin(BigDecimal qmin) {
		this.qmin = qmin;
	}

	public BigDecimal getPmax() {
		return pmax;
	}

	public void setPmax(BigDecimal pmax) {
		this.pmax = pmax;
	}

	public BigDecimal getPmin() {
		return pmin;
	}

	public void setPmin(BigDecimal pmin) {
		this.pmin = pmin;
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
