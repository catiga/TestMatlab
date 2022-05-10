package com.smartgrid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartgrid.entity.C1ComponentRelibility;

public interface C1ComponentRelibilityDao extends JpaRepository<C1ComponentRelibility, Long> {

	@Modifying
	@Query(value = "delete from C1ComponentRelibility s where s.projId=:projId")
	public void deleteByProjId(@Param(value = "projId") Long projId);
	
}
