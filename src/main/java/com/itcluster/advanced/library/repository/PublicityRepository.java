package com.itcluster.advanced.library.repository;

import com.itcluster.advanced.library.model.Publicity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicityRepository extends JpaRepository <Publicity, Long> {
    Publicity getByName(String name);
}
