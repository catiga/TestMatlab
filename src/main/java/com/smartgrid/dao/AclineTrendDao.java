package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.AclineTrend;

public interface AclineTrendDao extends JpaRepository<AclineTrend, Long> {

	public List<AclineTrend> findByProjId(Long projId);
	
}
