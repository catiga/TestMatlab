package com.smartgrid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartgrid.entity.TaskLoadFlow;

public interface TaskLoadFlowDao extends JpaRepository<TaskLoadFlow, Long> {

}
