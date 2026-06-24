package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DersKaydi {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "ogrenci_id")
    private Ogrenci ogrenci;



    @ManyToOne
    @JoinColumn(name = "acilan_ders_id")
    private AcilanDers acilanDers;

    private String durum;

    private LocalDateTime kayitTarihi;
}

