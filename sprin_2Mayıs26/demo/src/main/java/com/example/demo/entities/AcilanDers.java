package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import com.example.demo.entities.Sinif;
import java.util.UUID;

@Entity
@Table(name = "acilan_ders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcilanDers {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "ders_id")
    private UUID dersId;

    @Column(name = "akademisyen_id")
    private UUID akademisyenId;

    @Column(name = "donem_id")
    private UUID donemId;

    @ManyToOne
    @JoinColumn(name = "sinif_id")
    private Sinif sinif;
}