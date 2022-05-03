package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.Acline;

public interface AclineDao extends JpaRepository<Acline, Long> {

	public List<Acline> findByProjId(Long projId);
	
}
