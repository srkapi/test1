package com.example.demo.adapter.out.persistence.repository;

import com.example.demo.adapter.out.persistence.model.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
