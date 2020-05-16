package com.fsd.userservice.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SignInDao<T> extends JpaRepository<T, Long> {

    Optional<T> findByUsername(String username);
}
