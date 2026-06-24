package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DersResponseDto {

    private UUID id;

    private String dersAdi;
    private Integer kredi;
    private String dersKodu;
}