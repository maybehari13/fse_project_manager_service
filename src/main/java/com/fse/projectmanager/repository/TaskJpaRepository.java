/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Apr 2, 2019
 */

package com.fse.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fse.projectmanager.model.Task;

/**
 * @author n0172808
 *
 */
@Repository
public interface TaskJpaRepository extends JpaRepository<Task, Long>{
	
	int countByProjectProjectId(Long id);
	int countByProjectProjectIdAndStatus(Long id, boolean status);
	
}