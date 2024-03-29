/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Jun 18, 2019
 */

package com.fse.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fse.projectmanager.model.Project;

/**
 * @author n0172808
 *
 */
public interface ProjectJpaRepository extends JpaRepository<Project, Long> {
	
}
