package com.smartgrid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.SysProject;

public interface ProjectDao extends JpaRepository<SysProject, Long>{

}
