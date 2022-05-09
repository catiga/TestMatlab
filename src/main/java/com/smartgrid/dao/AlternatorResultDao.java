package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.AlternatorResult;

public interface AlternatorResultDao extends JpaRepository<AlternatorResult, Long> {

	public List<AlternatorResult> findByProjId(Long projId);
}
