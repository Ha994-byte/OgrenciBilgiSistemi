package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "ogrenci")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ogrenci {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "insan_id")
    private UUID insanId;

    @Column(name = "ogrenci_no")
    private String ogrenciNo;

    @Column(name = "kayit_tarihi")
    private LocalDate kayitTarihi;
}