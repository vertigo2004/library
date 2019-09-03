package com.itcluster.advanced.library.service;

import com.itcluster.advanced.library.model.Publicity;
import com.itcluster.advanced.library.repository.PublicityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicityService {

    @Autowired
    private PublicityRepository repo;

    public List<Publicity> getAll() {
        return repo.findAll();
    }

    public Publicity getByName(String name) {
        return repo.getByName(name);
    }

    public Publicity create(Publicity publicity) {
        return repo.save(publicity);
    }
}
