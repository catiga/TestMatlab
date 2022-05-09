package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.ThreewTransformerResult;

public interface ThreewTransformerResultDao extends JpaRepository<ThreewTransformerResult, Long> {

	public List<ThreewTransformerResult> findByProjId(Long projId);
}
