package com.example.grutboot2.repository;

import com.example.grutboot2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    static void addUser(User user) {

    }
}
