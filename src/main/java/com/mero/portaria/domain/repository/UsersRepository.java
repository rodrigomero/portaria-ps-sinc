package com.mero.portaria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
