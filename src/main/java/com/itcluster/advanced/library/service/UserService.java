package com.itcluster.advanced.library.service;

import com.itcluster.advanced.library.model.User;
import com.itcluster.advanced.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<User> getByLastname(String lastname) {
        return repo.findByLastname(lastname);
    }

    public User create(User u) {
        return repo.save(u);
    }
}
