package com.smartgrid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartgrid.dao.ProjectDao;
import com.smartgrid.dao.ProjectParamDao;
import com.smartgrid.entity.ProjectParam;
import com.smartgrid.entity.SysProject;

@Service
public class SysService {

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private ProjectParamDao paramDao;
	
	public SysProject getSysProject(Long id) {
		return projectDao.getOne(id);
	}
	
	public List<ProjectParam> findProjectParams(Long projId) {
		return paramDao.findByProjId(projId);
	}
}
