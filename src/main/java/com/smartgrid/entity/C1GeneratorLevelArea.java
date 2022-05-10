package com.smartgrid.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c1_generator_level_area")
public class C1GeneratorLevelArea implements Serializable {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "gla_1")
	private BigDecimal gla1;
	
	@Column(name = "gla_2")
	private BigDecimal gla2;
	
	@Column(name = "gla_3")
	private BigDecimal gla3;
	
	@Column(name = "gla_4")
	private BigDecimal gla4;
	
	@Column(name = "gla_5")
	private BigDecimal gla5;
	
	@Column(name = "gla_6")
	private BigDecimal gla6;
	
	@Column(name = "gla_7")
	private BigDecimal gla7;
	
	@Column(name = "gla_8")
	private BigDecimal gla8;
	
	@Column(name = "gla_9")
	private BigDecimal gla9;
	
	@Column(name = "gla_10")
	private BigDecimal gla10;
	
	@Column(name = "gla_11")
	private BigDecimal gla11;
	
	@Column(name = "gla_12")
	private BigDecimal gla12;
	
	@Column(name = "gla_13")
	private BigDecimal gla13;
	
	@Column(name = "gla_14")
	private BigDecimal gla14;
	
	@Column(name = "gla_15")
	private BigDecimal gla15;
	
	@Column(name = "gla_16")
	private BigDecimal gla16;
	
	@Column(name = "gla_17")
	private BigDecimal gla17;
	
	@Column(name = "gla_18")
	private BigDecimal gla18;
	
	@Column(name = "gla_19")
	private BigDecimal gla19;
	
	@Column(name = "gla_20")
	private BigDecimal gla20;
	
	@Column(name = "gla_21")
	private BigDecimal gla21;
	
	@Column(name = "proj_id")
	private Long projId;
	
	public C1GeneratorLevelArea() {}
	
	public C1GeneratorLevelArea(double[] _13data, Long projId) {
		if(_13data.length==21) {
			this.gla1 = new BigDecimal(_13data[0]);
			this.gla2 = new BigDecimal(_13data[1]);
			this.gla3 = new BigDecimal(_13data[2]);
			this.gla4 = new BigDecimal(_13data[3]);
			this.gla5 = new BigDecimal(_13data[4]);
			this.gla6 = new BigDecimal(_13data[5]);
			this.gla7 = new BigDecimal(_13data[6]);
			this.gla8 = new BigDecimal(_13data[7]);
			this.gla9 = new BigDecimal(_13data[8]);
			this.gla10 = new BigDecimal(_13data[9]);
			this.gla11 = new BigDecimal(_13data[10]);
			this.gla12 = new BigDecimal(_13data[11]);
			this.gla13 = new BigDecimal(_13data[12]);
			
			this.gla14 = new BigDecimal(_13data[13]);
			this.gla15 = new BigDecimal(_13data[14]);
			this.gla16 = new BigDecimal(_13data[15]);
			this.gla17 = new BigDecimal(_13data[16]);
			this.gla18 = new BigDecimal(_13data[17]);
			this.gla19 = new BigDecimal(_13data[18]);
			this.gla20 = new BigDecimal(_13data[19]);
			this.gla21 = new BigDecimal(_13data[20]);
		}
		this.projId = projId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getGla1() {
		return gla1;
	}

	public void setGla1(BigDecimal gla1) {
		this.gla1 = gla1;
	}

	public BigDecimal getGla2() {
		return gla2;
	}

	public void setGla2(BigDecimal gla2) {
		this.gla2 = gla2;
	}

	public BigDecimal getGla3() {
		return gla3;
	}

	public void setGla3(BigDecimal gla3) {
		this.gla3 = gla3;
	}

	public BigDecimal getGla4() {
		return gla4;
	}

	public void setGla4(BigDecimal gla4) {
		this.gla4 = gla4;
	}

	public BigDecimal getGla5() {
		return gla5;
	}

	public void setGla5(BigDecimal gla5) {
		this.gla5 = gla5;
	}

	public BigDecimal getGla6() {
		return gla6;
	}

	public void setGla6(BigDecimal gla6) {
		this.gla6 = gla6;
	}

	public BigDecimal getGla7() {
		return gla7;
	}

	public void setGla7(BigDecimal gla7) {
		this.gla7 = gla7;
	}

	public BigDecimal getGla8() {
		return gla8;
	}

	public void setGla8(BigDecimal gla8) {
		this.gla8 = gla8;
	}

	public BigDecimal getGla9() {
		return gla9;
	}

	public void setGla9(BigDecimal gla9) {
		this.gla9 = gla9;
	}

	public BigDecimal getGla10() {
		return gla10;
	}

	public void setGla10(BigDecimal gla10) {
		this.gla10 = gla10;
	}

	public BigDecimal getGla11() {
		return gla11;
	}

	public void setGla11(BigDecimal gla11) {
		this.gla11 = gla11;
	}

	public BigDecimal getGla12() {
		return gla12;
	}

	public void setGla12(BigDecimal gla12) {
		this.gla12 = gla12;
	}

	public BigDecimal getGla13() {
		return gla13;
	}

	public void setGla13(BigDecimal gla13) {
		this.gla13 = gla13;
	}

	public BigDecimal getGla14() {
		return gla14;
	}

	public void setGla14(BigDecimal gla14) {
		this.gla14 = gla14;
	}

	public BigDecimal getGla15() {
		return gla15;
	}

	public void setGla15(BigDecimal gla15) {
		this.gla15 = gla15;
	}

	public BigDecimal getGla16() {
		return gla16;
	}

	public void setGla16(BigDecimal gla16) {
		this.gla16 = gla16;
	}

	public BigDecimal getGla17() {
		return gla17;
	}

	public void setGla17(BigDecimal gla17) {
		this.gla17 = gla17;
	}

	public BigDecimal getGla18() {
		return gla18;
	}

	public void setGla18(BigDecimal gla18) {
		this.gla18 = gla18;
	}

	public BigDecimal getGla19() {
		return gla19;
	}

	public void setGla19(BigDecimal gla19) {
		this.gla19 = gla19;
	}

	public BigDecimal getGla20() {
		return gla20;
	}

	public void setGla20(BigDecimal gla20) {
		this.gla20 = gla20;
	}

	public BigDecimal getGla21() {
		return gla21;
	}

	public void setGla21(BigDecimal gla21) {
		this.gla21 = gla21;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}

}
