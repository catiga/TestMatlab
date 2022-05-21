package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartgrid.entity.CpfComputeResult;

public interface CpfComputeResultDao extends JpaRepository<CpfComputeResult, Long> {

	@Modifying
	@Query(value = "delete from CpfComputeResult s where s.taskId=:taskId")
	public void deleteByTaskId(@Param(value = "taskId") Long taskId);
	
	public List<CpfComputeResult> findByProjId(Long projId);
}
