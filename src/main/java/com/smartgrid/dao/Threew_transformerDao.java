package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.Moline;
import com.smartgrid.entity.Threew_transformer;

public interface Threew_transformerDao extends JpaRepository<Threew_transformer, Long> {

	public List<Threew_transformerDao> findByProjId(Long projId);
}
