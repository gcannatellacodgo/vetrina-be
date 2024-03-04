package com.corso.vetrina.repository;

import com.corso.vetrina.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User,String>{

    Optional<User> findByMail(String mail);
}
