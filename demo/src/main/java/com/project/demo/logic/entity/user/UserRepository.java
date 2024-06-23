package com.project.demo.logic.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>  { //Operaciones de bases de datos
    @Query("SELECT u FROM User u WHERE LOWER(u.name) LIKE %?1%")
    List<User> findUsersWithCharacterInName(String character); //Busca usuarios por nombre

    @Query("SELECT u FROM User u WHERE u.name = ?1")
    Optional<User> findByName(String name); //Busca usuario por nombre

    Optional<User> findByEmail(String email);
}
