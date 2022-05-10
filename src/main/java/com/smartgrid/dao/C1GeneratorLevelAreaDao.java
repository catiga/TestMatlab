package com.smartgrid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartgrid.entity.C1GeneratorLevelArea;

public interface C1GeneratorLevelAreaDao extends JpaRepository<C1GeneratorLevelArea, Long> {

	@Modifying
	@Query(value = "delete from C1GeneratorLevelArea s where s.projId=:projId")
	public void deleteByProjId(@Param(value = "projId") Long projId);
	
}
