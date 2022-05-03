package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.Alternator;
import com.smartgrid.entity.Moline;

public interface AlternatorDao extends JpaRepository<Alternator, Long> {

	public List<AlternatorDao> findByProjId(Long projId);
}
