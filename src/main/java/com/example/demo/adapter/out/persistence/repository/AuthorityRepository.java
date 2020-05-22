package com.example.demo.adapter.out.persistence.repository;

import com.example.demo.adapter.out.persistence.model.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    @Query(value = "select authority.id,authority.name from authority inner join  users_authorities on  users_authorities.authority_id=authority.id and users_authorities.user_id= :idUser", nativeQuery = true)
    Collection<Authority> findAuthorityByIdUser(@Param("idUser") Long id);

    @Query(value="select * from authority where name = :nameAuthority", nativeQuery = true)
    Authority findByNameAuthority(String nameAuthority);
}
