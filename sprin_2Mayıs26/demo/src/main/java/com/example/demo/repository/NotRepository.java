package com.example.demo.repository;

import com.example.demo.entities.Not;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface NotRepository
        extends JpaRepository<Not, UUID> {
    List<Not> findByOgrenci_Id(UUID ogrenciId);

    @Query("""

SELECT AVG(n.ortalama)

FROM Not n

WHERE n.ders.id = :dersId

""")
    Double dersOrtalamasi(UUID dersId);



}