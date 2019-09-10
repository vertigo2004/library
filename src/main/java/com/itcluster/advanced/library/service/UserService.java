package com.itcluster.advanced.library.service;

import com.itcluster.advanced.library.model.Role;
import com.itcluster.advanced.library.model.User;
import com.itcluster.advanced.library.repository.RoleRepository;
import com.itcluster.advanced.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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

    public User createUpdate(User user) {
        User toSave = user.getId() == null ? createUser(user) : updateUser(user);
        return userRepository.save(toSave);
    }

    private User createUser(User user) {

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("user"));
        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return user;
    }

    private User updateUser(User user) {
        User origin = userRepository.findById(user.getId()).get();
        if (!StringUtils.isEmpty(user.getFirstname())) {
            origin.setFirstname(user.getFirstname());
        }
        if (!StringUtils.isEmpty(user.getLastname())) {
            origin.setLastname(user.getLastname());
        }
        if (!StringUtils.isEmpty(user.getEmail())) {
            origin.setEmail(user.getEmail());
        }
        if (!StringUtils.isEmpty(user.getPassword())) {
            origin.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        if (!StringUtils.isEmpty(user.getDob())) {
            origin.setDob(user.getDob());
        }
        if (!StringUtils.isEmpty(user.getPhoto())) {
            origin.setPhoto(user.getPhoto());
        }
        if (!CollectionUtils.isEmpty(user.getRoles())) {
            origin.setRoles(user.getRoles());
        }
        return origin;
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
