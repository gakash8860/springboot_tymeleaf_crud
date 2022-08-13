package com.crud.springboot_tymeleaf_crud.services;

import com.crud.springboot_tymeleaf_crud.models.User;
import com.crud.springboot_tymeleaf_crud.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
   private UserRepo userRepo;


    @Override
    public List<User> getAllUser() {
        List<User> users= this.userRepo.findAll();
        return users;
    }

    @Override
    public void saveUser(User user) {
        this.userRepo.save(user);
    }

    @Override
    public User getUserById(long id) {
        Optional<User> optional = userRepo.findById(id);
        User user=null;
        if (optional.isPresent()){
            user = optional.get();
        }else{
            throw new RuntimeException("User Not Found");
        }
        return user;

    }

    @Override
    public void deleteUser(long id) {
        this.userRepo.deleteById(id);
    }
}
