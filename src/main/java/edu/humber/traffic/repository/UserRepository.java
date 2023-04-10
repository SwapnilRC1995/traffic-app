package edu.humber.traffic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.humber.traffic.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}
