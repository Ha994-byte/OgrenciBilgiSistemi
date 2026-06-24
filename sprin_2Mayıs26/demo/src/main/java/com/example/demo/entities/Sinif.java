package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "sinif")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sinif {

    @Id
    @GeneratedValue
    private UUID id;

    private String ad;

    private Integer kapasite;
}