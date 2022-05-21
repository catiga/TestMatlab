package com.smartgrid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartgrid.entity.CWeakComputeResult;

public interface CWeakComputeResultDao extends JpaRepository<CWeakComputeResult, Long> {

	@Modifying
	@Query(value = "delete from CWeakComputeResult s where s.taskId=:taskId")
	public void deleteByTaskId(@Param(value = "taskId") Long taskId);
}
