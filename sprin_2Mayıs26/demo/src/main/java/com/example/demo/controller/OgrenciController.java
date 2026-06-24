package com.example.demo.controller;

import com.example.demo.entities.Ogrenci;
import com.example.demo.services.OgrenciService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.OgrenciRequestDto;
import com.example.demo.dto.OgrenciResponseDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ogrenci")
@RequiredArgsConstructor
public class OgrenciController {

    private final OgrenciService service;

    @GetMapping
    public List<Ogrenci> tumOgrenciler() {
        return service.tumOgrencileriGetir();
    }

    @GetMapping("/{id}")
    public Ogrenci ogrenciGetir(@PathVariable UUID id) {
        return service.ogrenciGetir(id);
    }

    @DeleteMapping("/{id}")
    public String ogrenciSil(@PathVariable UUID id) {

        service.ogrenciSil(id);

        return "Ogrenci silindi";
    }

    @PostMapping
    public OgrenciResponseDto kaydet(
            @Valid @RequestBody OgrenciRequestDto dto
    ) {

        Ogrenci ogrenci = new Ogrenci();

        ogrenci.setInsanId(dto.getInsanId());
        ogrenci.setOgrenciNo(dto.getOgrenciNo());
        ogrenci.setKayitTarihi(dto.getKayitTarihi());

        Ogrenci kaydedilen =
                service.ogrenciKaydet(ogrenci);

        OgrenciResponseDto response =
                new OgrenciResponseDto();

        response.setId(kaydedilen.getId());
        response.setInsanId(kaydedilen.getInsanId());
        response.setOgrenciNo(kaydedilen.getOgrenciNo());
        response.setKayitTarihi(kaydedilen.getKayitTarihi());

        return response;
    }


    @PutMapping("/{id}")
    public OgrenciResponseDto guncelle(
            @PathVariable UUID id,
            @Valid @RequestBody OgrenciRequestDto dto
    ) {
        Ogrenci ogrenci =
                service.idIleBul(id);

        ogrenci.setInsanId(dto.getInsanId());
        ogrenci.setOgrenciNo(dto.getOgrenciNo());
        ogrenci.setKayitTarihi(dto.getKayitTarihi());

        Ogrenci guncellenen =
                service.ogrenciKaydet(ogrenci);

        OgrenciResponseDto response =
                new OgrenciResponseDto();

        response.setId(guncellenen.getId());
        response.setInsanId(guncellenen.getInsanId());
        response.setOgrenciNo(guncellenen.getOgrenciNo());
        response.setKayitTarihi(
                guncellenen.getKayitTarihi()
        );

        return response;

    }
}