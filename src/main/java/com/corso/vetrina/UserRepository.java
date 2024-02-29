package com.corso.vetrina;

import com.corso.vetrina.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,String>{

}
