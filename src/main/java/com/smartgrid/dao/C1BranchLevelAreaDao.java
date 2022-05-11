package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartgrid.entity.C1BranchLevelArea;

public interface C1BranchLevelAreaDao extends JpaRepository<C1BranchLevelArea, Long> {

	@Modifying
	@Query(value = "delete from C1BranchLevelArea s where s.projId=:projId")
	public void deleteByProjId(@Param(value = "projId") Long projId);
	
	public List<C1BranchLevelArea> findByProjId(Long projId);
	
}
