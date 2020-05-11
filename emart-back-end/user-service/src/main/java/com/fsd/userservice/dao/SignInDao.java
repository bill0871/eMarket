package com.fsd.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SignInDao<T> extends JpaRepository<T, Long> {

}
