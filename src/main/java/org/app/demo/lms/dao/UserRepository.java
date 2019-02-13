package org.app.demo.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.app.demo.lms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
