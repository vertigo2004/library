package com.itcluster.advanced.library.service;

import com.itcluster.advanced.library.model.Role;
import com.itcluster.advanced.library.model.User;
import com.itcluster.advanced.library.repository.RoleRepository;
import com.itcluster.advanced.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getByLastname(String lastname) {
        return userRepository.findByLastname(lastname);
    }

    public User create(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("user"));
        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
