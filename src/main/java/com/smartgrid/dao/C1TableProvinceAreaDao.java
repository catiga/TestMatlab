package com.smartgrid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartgrid.entity.C1TableProvinceArea;

public interface C1TableProvinceAreaDao extends JpaRepository<C1TableProvinceArea, Long> {

	@Modifying
	@Query(value = "delete from C1TableProvinceArea s where s.projId=:projId")
	public void deleteByProjId(@Param(value = "projId") Long projId);
}
