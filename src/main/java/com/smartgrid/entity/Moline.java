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
@Table(name = "p_moline_info")
public class Moline implements Serializable {
	
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "bus_name")
	private String busName;
	
	@Column(name = "phy_pos")
	private String phyPos;
	
	@Column(name = "zone_no")
	private String zoneNo;
	
	@Column(name = "ps_name")
	private String psName;
	
	@Column(name = "base_kv")
	private BigDecimal baseKv;
	
	@Column(name = "vmax_kv")
	private BigDecimal vmaxKv;
	
	@Column(name = "vmin_kv")
	private BigDecimal vminKv;
	
	@Column(name = "sc1_mva")
	private BigDecimal sc1mva;
	
	@Column(name = "sc3_mva")
	private BigDecimal sc3mva;
	
	@Column(name = "hasnode")
	private Integer hashnode;
	
	@Column(name = "bustype")
	private Integer bustype;
	
	@Column(name = "dispname")
	private String dispname;
	
	@Column(name = "proj_id")
	private Long projId;
	
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getPhyPos() {
		return phyPos;
	}

	public void setPhyPos(String phyPos) {
		this.phyPos = phyPos;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getPsName() {
		return psName;
	}

	public void setPsName(String psName) {
		this.psName = psName;
	}

	public BigDecimal getBaseKv() {
		return baseKv;
	}

	public void setBaseKv(BigDecimal baseKv) {
		this.baseKv = baseKv;
	}

	public BigDecimal getVmaxKv() {
		return vmaxKv;
	}

	public void setVmaxKv(BigDecimal vmaxKv) {
		this.vmaxKv = vmaxKv;
	}

	public BigDecimal getVminKv() {
		return vminKv;
	}

	public void setVminKv(BigDecimal vminKv) {
		this.vminKv = vminKv;
	}

	public BigDecimal getSc1mva() {
		return sc1mva;
	}

	public void setSc1mva(BigDecimal sc1mva) {
		this.sc1mva = sc1mva;
	}

	public BigDecimal getSc3mva() {
		return sc3mva;
	}

	public void setSc3mva(BigDecimal sc3mva) {
		this.sc3mva = sc3mva;
	}

	public Integer getHashnode() {
		return hashnode;
	}

	public void setHashnode(Integer hashnode) {
		this.hashnode = hashnode;
	}

	public Integer getBustype() {
		return bustype;
	}

	public void setBustype(Integer bustype) {
		this.bustype = bustype;
	}

	public String getDispname() {
		return dispname;
	}

	public void setDispname(String dispname) {
		this.dispname = dispname;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
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
