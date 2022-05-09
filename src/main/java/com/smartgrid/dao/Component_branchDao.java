package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.ComponentBranch;

public interface Component_branchDao extends JpaRepository<ComponentBranch, Long> {

	public List<ComponentBranch> findByProjId(Long projId);
}
