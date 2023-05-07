package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(Long id, User userRequest) {
        User user = getById(id);
        user.setName(userRequest.getName());
        user.setPhone(userRequest.getPhone());
        return this.userRepository.save(user);
    }

    @Override
    public void destroy(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User save(User user) {
       return this.userRepository.save(user);
    }

    public List<User> getUserByName(String name) {
        return this.userRepository.getUserByName(name);
    }

}
