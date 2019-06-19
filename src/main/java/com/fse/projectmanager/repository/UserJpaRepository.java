/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on Jun 18, 2019
 */

package com.fse.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fse.projectmanager.model.User;

/**
 * @author n0172808
 *
 */
public interface UserJpaRepository extends JpaRepository<User, Long> {
	List<User> findByManager(boolean manager);
}
