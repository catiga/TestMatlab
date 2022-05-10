package com.smartgrid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartgrid.entity.C1GeneratorLevel;

public interface C1GeneratorLevelDao extends JpaRepository<C1GeneratorLevel, Long> {

	@Modifying
	@Query(value = "delete from C1GeneratorLevel s where s.projId=:projId")
	public void deleteByProjId(@Param(value = "projId") Long projId);
}
