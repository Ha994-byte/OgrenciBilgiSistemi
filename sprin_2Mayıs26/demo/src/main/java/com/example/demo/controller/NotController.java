package com.example.demo.controller;


import com.example.demo.dto.NotRequestDto;
import com.example.demo.dto.NotResponseDto;
import com.example.demo.entities.Ders;
import com.example.demo.entities.DersKaydi;
import com.example.demo.entities.Not;

import com.example.demo.repository.DersKaydiRepository;
import com.example.demo.repository.DersRepository;
import com.example.demo.repository.NotRepository;

import com.example.demo.services.NotService;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/not")
@RequiredArgsConstructor
public class NotController {

    private final NotService notService;

    private final NotRepository notRepository;
    private final DersRepository dersRepository;
    private final DersKaydiRepository dersKaydiRepository;

    @PostMapping
    public NotResponseDto notVer(@RequestBody NotRequestDto dto) {

        DersKaydi dersKaydi = dersKaydiRepository.findById(dto.getDersKaydiId()).orElseThrow();

        Not not = new Not();

        not.setDersKaydi(dersKaydi);

        not.setOgrenci(dersKaydi.getOgrenci());

        Ders ders = dersRepository.findById(dersKaydi.getAcilanDers().getDersId()).orElseThrow();

        not.setDers(ders);

        not.setVize(dto.getVize());

        not.setFinalNotu(dto.getFinalNotu());

        double ortalama = (dto.getVize() * 0.4) + (dto.getFinalNotu() * 0.6);

        not.setOrtalama(ortalama);

        Not saved = notRepository.save(not);

        NotResponseDto response = new NotResponseDto();

        response.setId(saved.getId());

        response.setOgrenciId(saved.getOgrenci().getId());

        response.setDersId(saved.getDers().getId());

        response.setVize(saved.getVize());

        response.setFinalNotu(saved.getFinalNotu());

        response.setOrtalama(saved.getOrtalama());

        return response;
    }

    @GetMapping("/ogrenci/{ogrenciId}")
    public List<NotResponseDto> ogrencininNotlari(@PathVariable UUID ogrenciId) {

        List<NotResponseDto> notlar = notService.ogrencininNotlari(ogrenciId);

        return notlar;


    }

    @GetMapping("/ders-ortalamasi/{dersId}")

    public Double dersOrtalamasi(
            @PathVariable UUID dersId
    ) {

        return notService
                .dersOrtalamasi(dersId);
    }

    @GetMapping("/okul-gano-ortalamasi")
    public Double okulGanoOrtalamasi() {

        return notService
                .okulGanoOrtalamasi();
    }

    @PutMapping("/{id}")

    public Not notGuncelle(
            @PathVariable UUID id,
            @RequestBody Not yeniNot
    ) {

        return notService
                .notGuncelle(
                        id,
                        yeniNot
                );
    }
}