package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.Alternator;

public interface AlternatorDao extends JpaRepository<Alternator, Long> {

	public List<Alternator> findByProjId(Long projId);
}
