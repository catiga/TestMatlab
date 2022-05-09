package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.ProjectParam;

public interface ProjectParamDao extends JpaRepository<ProjectParam, Long> {

	public List<ProjectParam> findByProjId(Long projId);
	
}
