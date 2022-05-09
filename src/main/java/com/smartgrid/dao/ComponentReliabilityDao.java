package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.ComponentReliability;

public interface ComponentReliabilityDao extends JpaRepository<ComponentReliability, Long> {

	public List<ComponentReliability> findByProjId(Long projId);
	
}
