package com.mo.admin.service;

import com.mo.admin.entity.User;
import com.mo.admin.mapper.UserMapper;
import com.mo.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


   public List<User> listUsers() {
       return (List<User>)userRepository.findAll();
   }

   public User saveUser(User user) {
       return userRepository.save(user);
   }

   public void deleteUser(String id){
       userRepository.deleteById(id);
   }

   public User findUser(String id){
       return userRepository.findById(id).orElse(null);
   }

   public List<User> searchUser(String name){
       return userMapper.findByName(name);
   }
}
