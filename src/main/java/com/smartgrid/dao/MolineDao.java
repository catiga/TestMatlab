package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.Moline;

public interface MolineDao extends JpaRepository<Moline, Long> {

	public List<Moline> findByProjId(Long projId);
}
