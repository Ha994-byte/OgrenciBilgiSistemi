package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "ders")
@Getter
@Setter
public class Ders {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ders_kodu")
    private String dersKodu;


    @Column(name = "ders_adi")
    private String dersAdi;

    private Integer kredi;
}