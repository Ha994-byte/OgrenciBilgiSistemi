package com.example.demo.repository;

import com.example.demo.entities.AcilanDers;
import com.example.demo.entities.DersKaydi;
import com.example.demo.entities.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DersKaydiRepository extends JpaRepository<DersKaydi, UUID> {

    List<DersKaydi> findByOgrenci_Id(UUID ogrenciId);

    boolean existsByOgrenciAndAcilanDers(
            Ogrenci ogrenci,
            AcilanDers acilanDers
    );

    boolean existsByOgrenciIdAndAcilanDersId(
            UUID ogrenciId,
            UUID acilanDersId
    );

    long countByAcilanDers_Id(UUID acilanDersId);
    List<DersKaydi> findByOgrenci(Ogrenci ogrenci);
}