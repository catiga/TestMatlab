package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.LoadTrend;

public interface LoadTrendDao extends JpaRepository<LoadTrend, Long> {

	public List<LoadTrend> findByProjId(Long projId);
}
