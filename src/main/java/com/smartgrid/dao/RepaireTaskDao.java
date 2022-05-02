package com.smartgrid.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.RepaireTask;

public interface RepaireTaskDao extends JpaRepository<RepaireTask, Long>{

	Optional<RepaireTask> findById(Long id);
}
