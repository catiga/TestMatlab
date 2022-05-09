package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.AlternatorTrend;

public interface AlternatorTrendDao extends JpaRepository<AlternatorTrend, Long> {

	public List<AlternatorTrend> findByProjId(Long projId);
}
