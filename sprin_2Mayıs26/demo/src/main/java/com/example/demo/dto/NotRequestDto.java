package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data

public class NotRequestDto {

    @NotNull
    private UUID dersKaydiId;

    @NotNull
    private Integer vize;

    @NotNull
    private Integer finalNotu;
}
