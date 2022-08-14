package com.example.grutboot2.service;

import com.example.grutboot2.model.User;
import javax.validation.Valid;
import java.util.List;

public interface UserService {

    List<User> getAllUsers ();
    Object getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(@Valid User user);
}