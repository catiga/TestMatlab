package com.smartgrid.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c1_generator_level")
public class C1GeneratorLevel implements Serializable {

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "gl_1")
	private BigDecimal gl1;
	
	@Column(name = "gl_2")
	private BigDecimal gl2;
	
	@Column(name = "gl_3")
	private BigDecimal gl3;
	
	@Column(name = "gl_4")
	private BigDecimal gl4;
	
	@Column(name = "gl_5")
	private BigDecimal gl5;
	
	@Column(name = "gl_6")
	private BigDecimal gl6;
	
	@Column(name = "gl_7")
	private BigDecimal gl7;
	
	@Column(name = "gl_8")
	private BigDecimal gl8;
	
	@Column(name = "gl_9")
	private BigDecimal gl9;
	
	@Column(name = "gl_10")
	private BigDecimal gl10;
	
	@Column(name = "gl_11")
	private BigDecimal gl11;
	
	@Column(name = "gl_12")
	private BigDecimal gl12;
	
	@Column(name = "gl_13")
	private BigDecimal gl13;
	
	@Column(name = "gl_14")
	private BigDecimal gl14;
	
	@Column(name = "gl_15")
	private BigDecimal gl15;
	
	@Column(name = "gl_16")
	private BigDecimal gl16;
	
	@Column(name = "gl_17")
	private BigDecimal gl17;
	
	@Column(name = "gl_18")
	private BigDecimal gl18;
	
	@Column(name = "gl_19")
	private BigDecimal gl19;
	
	@Column(name = "gl_20")
	private BigDecimal gl20;
	
	@Column(name = "gl_21")
	private BigDecimal gl21;
	
	@Column(name = "proj_id")
	private Long projId;
	
	public C1GeneratorLevel() {}
	
	public C1GeneratorLevel(double[] _13data, Long projId) {
		if(_13data.length==13) {
			this.gl1 = new BigDecimal(_13data[0]);
			this.gl2 = new BigDecimal(_13data[1]);
			this.gl3 = new BigDecimal(_13data[2]);
			this.gl4 = new BigDecimal(_13data[3]);
			this.gl5 = new BigDecimal(_13data[4]);
			this.gl6 = new BigDecimal(_13data[5]);
			this.gl7 = new BigDecimal(_13data[6]);
			this.gl8 = new BigDecimal(_13data[7]);
			this.gl9 = new BigDecimal(_13data[8]);
			this.gl10 = new BigDecimal(_13data[9]);
			this.gl11 = new BigDecimal(_13data[10]);
			this.gl12 = new BigDecimal(_13data[11]);
			this.gl13 = new BigDecimal(_13data[12]);
			
			this.gl14 = new BigDecimal(_13data[13]);
			this.gl15 = new BigDecimal(_13data[14]);
			this.gl16 = new BigDecimal(_13data[15]);
			this.gl17 = new BigDecimal(_13data[16]);
			this.gl18 = new BigDecimal(_13data[17]);
			this.gl19 = new BigDecimal(_13data[18]);
			this.gl20 = new BigDecimal(_13data[19]);
			this.gl21 = new BigDecimal(_13data[20]);
		}
		this.projId = projId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getGl1() {
		return gl1;
	}

	public void setGl1(BigDecimal gl1) {
		this.gl1 = gl1;
	}

	public BigDecimal getGl2() {
		return gl2;
	}

	public void setGl2(BigDecimal gl2) {
		this.gl2 = gl2;
	}

	public BigDecimal getGl3() {
		return gl3;
	}

	public void setGl3(BigDecimal gl3) {
		this.gl3 = gl3;
	}

	public BigDecimal getGl4() {
		return gl4;
	}

	public void setGl4(BigDecimal gl4) {
		this.gl4 = gl4;
	}

	public BigDecimal getGl5() {
		return gl5;
	}

	public void setGl5(BigDecimal gl5) {
		this.gl5 = gl5;
	}

	public BigDecimal getGl6() {
		return gl6;
	}

	public void setGl6(BigDecimal gl6) {
		this.gl6 = gl6;
	}

	public BigDecimal getGl7() {
		return gl7;
	}

	public void setGl7(BigDecimal gl7) {
		this.gl7 = gl7;
	}

	public BigDecimal getGl8() {
		return gl8;
	}

	public void setGl8(BigDecimal gl8) {
		this.gl8 = gl8;
	}

	public BigDecimal getGl9() {
		return gl9;
	}

	public void setGl9(BigDecimal gl9) {
		this.gl9 = gl9;
	}

	public BigDecimal getGl10() {
		return gl10;
	}

	public void setGl10(BigDecimal gl10) {
		this.gl10 = gl10;
	}

	public BigDecimal getGl11() {
		return gl11;
	}

	public void setGl11(BigDecimal gl11) {
		this.gl11 = gl11;
	}

	public BigDecimal getGl12() {
		return gl12;
	}

	public void setGl12(BigDecimal gl12) {
		this.gl12 = gl12;
	}

	public BigDecimal getGl13() {
		return gl13;
	}

	public void setGl13(BigDecimal gl13) {
		this.gl13 = gl13;
	}

	public BigDecimal getGl14() {
		return gl14;
	}

	public void setGl14(BigDecimal gl14) {
		this.gl14 = gl14;
	}

	public BigDecimal getGl15() {
		return gl15;
	}

	public void setGl15(BigDecimal gl15) {
		this.gl15 = gl15;
	}

	public BigDecimal getGl16() {
		return gl16;
	}

	public void setGl16(BigDecimal gl16) {
		this.gl16 = gl16;
	}

	public BigDecimal getGl17() {
		return gl17;
	}

	public void setGl17(BigDecimal gl17) {
		this.gl17 = gl17;
	}

	public BigDecimal getGl18() {
		return gl18;
	}

	public void setGl18(BigDecimal gl18) {
		this.gl18 = gl18;
	}

	public BigDecimal getGl19() {
		return gl19;
	}

	public void setGl19(BigDecimal gl19) {
		this.gl19 = gl19;
	}

	public BigDecimal getGl20() {
		return gl20;
	}

	public void setGl20(BigDecimal gl20) {
		this.gl20 = gl20;
	}

	public BigDecimal getGl21() {
		return gl21;
	}

	public void setGl21(BigDecimal gl21) {
		this.gl21 = gl21;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}

}
