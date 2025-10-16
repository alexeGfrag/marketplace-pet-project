package com.gfrag.auth.db.repository;

import com.gfrag.auth.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
