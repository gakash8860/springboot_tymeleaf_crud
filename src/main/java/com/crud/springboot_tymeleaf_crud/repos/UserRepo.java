package com.crud.springboot_tymeleaf_crud.repos;

import com.crud.springboot_tymeleaf_crud.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {


}
