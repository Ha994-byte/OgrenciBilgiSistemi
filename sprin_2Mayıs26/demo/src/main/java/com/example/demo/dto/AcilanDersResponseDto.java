package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AcilanDersResponseDto {

    private UUID id;

    private UUID dersId;


    private UUID akademisyenId;

    private UUID donemId;

    private UUID sinifId;
}