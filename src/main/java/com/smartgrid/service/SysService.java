package com.smartgrid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartgrid.dao.ProjectDao;
import com.smartgrid.entity.SysProject;

@Service
public class SysService {

	@Autowired
	private ProjectDao projectDao;
	
	public SysProject getSysProject(Long id) {
		return projectDao.getOne(id);
	}
}
