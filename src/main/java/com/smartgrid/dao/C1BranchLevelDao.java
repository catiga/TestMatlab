package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartgrid.entity.C1BranchLevel;

public interface C1BranchLevelDao extends JpaRepository<C1BranchLevel, Long> {

	@Modifying
	@Query(value = "delete from C1BranchLevel s where s.projId=:projId")
	public void deleteByProjId(@Param(value = "projId") Long projId);
	
	public List<C1BranchLevel> findByProjId(Long projId);
	
}
