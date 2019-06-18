/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Apr 2, 2019
 */

package com.fse.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fse.projectmanager.model.Parent;

/**
 * @author n0172808
 *
 */
@Repository
public interface ParentTaskJpaRepository extends JpaRepository<Parent, Long> {
	
	List<Parent> findByParentTaskIgnoreCaseContaining(String parentTask);
	
	Parent findByParentTask(String parentTask);

}
