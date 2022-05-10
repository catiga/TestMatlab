package com.smartgrid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartgrid.entity.C1NameShowLevel;

public interface C1NameShowLevelDao extends JpaRepository<C1NameShowLevel, Long> {

	@Modifying
	@Query(value = "delete from C1NameShowLevel s where s.projId=:projId")
	public void deleteByProjId(@Param(value = "projId") Long projId);
	
}
