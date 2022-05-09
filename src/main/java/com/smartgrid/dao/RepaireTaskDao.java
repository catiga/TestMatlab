package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.RepaireTask;

public interface RepaireTaskDao extends JpaRepository<RepaireTask, Long>{

	public List<RepaireTask> findByProjId(Long projId);
}
