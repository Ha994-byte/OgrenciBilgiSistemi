package com.example.demo.dto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.UUID;



@Getter
@Setter
public class OgrenciRequestDto {

    @NotNull(message = "insanId bos olamaz")
    private UUID insanId;

    @NotBlank(message = "ogrenciNo bos olamaz")
    private String ogrenciNo;

    @NotNull(message = "kayitTarihi bos olamaz")
    private LocalDate kayitTarihi;
}