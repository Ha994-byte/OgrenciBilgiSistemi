package com.example.demo.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter

public class NotResponseDto {






    private UUID id;

    private UUID ogrenciId;

    private UUID dersId;
    private String dersAdi;

    private Integer vize;

    private Integer finalNotu;

    private Double ortalama;
}
