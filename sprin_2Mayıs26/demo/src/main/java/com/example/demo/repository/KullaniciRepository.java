package com.example.demo.repository;

import com.example.demo.entities.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface KullaniciRepository
        extends JpaRepository<Kullanici, UUID> {



    Optional<Kullanici>
    findByUsername(String username);
}