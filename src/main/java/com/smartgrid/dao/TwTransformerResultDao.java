package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.TwTransformerResult;

public interface TwTransformerResultDao extends JpaRepository<TwTransformerResult, Long> {

	public List<TwTransformerResult> findByProjId(Long projId);
}



