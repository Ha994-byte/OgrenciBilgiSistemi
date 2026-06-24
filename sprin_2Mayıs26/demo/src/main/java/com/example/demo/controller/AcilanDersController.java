package com.example.demo.controller;

import com.example.demo.dto.AcilanDersRequestDto;
import com.example.demo.dto.AcilanDersResponseDto;
import com.example.demo.entities.AcilanDers;

import com.example.demo.entities.Sinif;
import com.example.demo.services.AcilanDersService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/acilan-ders")
public class AcilanDersController {

    private final AcilanDersService acilanDersService;

    public AcilanDersController(AcilanDersService acilanDersService) {
        this.acilanDersService = acilanDersService;
    }

    @GetMapping
    public List<AcilanDers> getAll() {
        return acilanDersService.getAll();
    }

    @GetMapping("/{id}")
    public AcilanDers getById(@PathVariable UUID id) {
        return acilanDersService.getById(id);
    }






    @PostMapping
    public AcilanDersResponseDto kaydet(
            @Valid @RequestBody AcilanDersRequestDto dto
    ) {

        AcilanDers acilanDers = new AcilanDers();

        acilanDers.setDersId(dto.getDersId());

        acilanDers.setAkademisyenId(
                dto.getAkademisyenId()
        );

        acilanDers.setDonemId(
                dto.getDonemId()
        );

        Sinif sinif = new Sinif();
        sinif.setId(dto.getSinifId());

        acilanDers.setSinif(sinif);

        AcilanDers kaydedilen =
                acilanDersService.kaydet(acilanDers);

        AcilanDersResponseDto response =
                new AcilanDersResponseDto();

        response.setId(kaydedilen.getId());

        response.setDersId(
                kaydedilen.getDersId()
        );

        response.setAkademisyenId(
                kaydedilen.getAkademisyenId()
        );

        response.setDonemId(
                kaydedilen.getDonemId()
        );

        response.setSinifId(
                kaydedilen.getSinif().getId()
        );

        return response;
    }

    @DeleteMapping("/{id}")
    public String sil(
            @PathVariable UUID id
    ) {

        acilanDersService.sil(id);

        return "Açılan ders silindi";
    }
    @PutMapping("/{id}")
    public AcilanDers guncelle(
            @PathVariable UUID id,
            @RequestBody AcilanDers dto
    ) {

        return acilanDersService.guncelle(id, dto);
    }



}