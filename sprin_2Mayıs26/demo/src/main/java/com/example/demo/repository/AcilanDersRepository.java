package com.example.demo.repository;

import com.example.demo.entities.AcilanDers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AcilanDersRepository extends JpaRepository<AcilanDers, UUID> {
}