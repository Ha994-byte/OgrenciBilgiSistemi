package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "notlar")
public class Not {

    @Id
    @GeneratedValue(strategy =
            GenerationType.UUID)

    private UUID id;



    @ManyToOne
    @JoinColumn(name = "ders_kaydi_id")
    private DersKaydi dersKaydi;






    @JsonIgnore
    @ManyToOne
    private Ogrenci ogrenci;



    @ManyToOne
    private Ders ders;

    private Integer vize;

    private Integer finalNotu;

    private Double ortalama;
}