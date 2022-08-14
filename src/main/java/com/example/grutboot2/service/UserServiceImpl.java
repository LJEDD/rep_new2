package com.example.grutboot2.service;

import com.example.grutboot2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.grutboot2.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService  {



    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }



    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    public void deleteById(Long id)
    {
        userRepository.deleteById(id);
    }





    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public Object getUserById(long id) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }



    @Override
    public void removeUser(long id) {

    }

    @Override
    public void updateUser(User user) {

    }
}