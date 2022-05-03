package com.smartgrid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.Moline;
import com.smartgrid.entity.Tw_transformer;

public interface Tw_transformerDao extends JpaRepository<Tw_transformer, Long> {

	public List<Tw_transformer> findByProjId(Long projId);
}
