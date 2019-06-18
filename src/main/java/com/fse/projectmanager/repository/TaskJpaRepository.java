/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Apr 2, 2019
 */

package com.fse.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fse.projectmanager.model.Task;

/**
 * @author n0172808
 *
 */
@Repository
public interface TaskJpaRepository extends JpaRepository<Task, Long>{
//	Always use object variable names for queries
//	@Query("Select t.taskId, t.task, t.startDate, t.endDate,"
//			+ " t.priority, p.parentTask from Task t join t.parent p")
	
//	@Query("Select t, p from Task t join t.parent p")
//	List<Task> queryAllTasks();
	
	List<Task> findByTaskIgnoreCaseContaining(String task);
	
}