package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DersRequestDto {

    @NotBlank
    private String dersAdi;

    @NotNull
    private Integer kredi;

    @NotBlank
    private String dersKodu;
}