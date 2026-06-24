package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "kullanici")
@Getter
@Setter


public class Kullanici {

    @Column(name = "rol")
    private String role;


    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "kullanici_adi", unique = true)
    private String username;

    @Column(name = "sifre")
    private String password;
}