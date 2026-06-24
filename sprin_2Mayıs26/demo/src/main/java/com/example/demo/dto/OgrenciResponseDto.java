package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class OgrenciResponseDto {

    private UUID id;

    private UUID insanId;

    private String ogrenciNo;

    private LocalDate kayitTarihi;
}