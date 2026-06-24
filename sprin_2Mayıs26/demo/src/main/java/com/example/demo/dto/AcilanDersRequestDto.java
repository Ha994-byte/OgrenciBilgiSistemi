package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AcilanDersRequestDto {

    @NotNull(message = "dersId bos olamaz")
    private UUID dersId;

    @NotNull(message = "akademisyenId bos olamaz")
    private UUID akademisyenId;

    @NotNull(message = "donemId bos olamaz")
    private UUID donemId;

    @NotNull(message = "sinifId bos olamaz")
    private UUID sinifId;
}