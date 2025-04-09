package io.github.sseregit.springawsmailer.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.sseregit.springawsmailer.domain.repository.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
