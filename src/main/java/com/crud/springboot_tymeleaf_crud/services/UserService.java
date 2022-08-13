package com.crud.springboot_tymeleaf_crud.services;


import com.crud.springboot_tymeleaf_crud.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

List<User> getAllUser();


void saveUser(User user);

User getUserById(long id);

void deleteUser(long id);




}
