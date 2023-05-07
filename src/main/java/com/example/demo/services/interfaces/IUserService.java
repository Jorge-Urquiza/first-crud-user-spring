package com.example.demo.services.interfaces;

import com.example.demo.models.User;

import java.util.List;

public interface IUserService {
    public List<User> getAll();
    public User getById( Long id );
    public User save( User user );
    public User update( Long id, User user );
    public void destroy( Long id );
}
