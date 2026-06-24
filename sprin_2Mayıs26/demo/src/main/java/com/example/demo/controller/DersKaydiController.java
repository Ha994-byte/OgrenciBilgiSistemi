package com.example.demo.controller;

import com.example.demo.dto.DersKaydiRequestDto;
import com.example.demo.dto.DersKaydiResponseDto;
import com.example.demo.entities.AcilanDers;
import com.example.demo.entities.DersKaydi;
import com.example.demo.entities.Ogrenci;
import com.example.demo.services.DersKaydiService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ders-kaydi")
public class DersKaydiController {

    private final DersKaydiService dersKaydiService;

    public DersKaydiController(DersKaydiService dersKaydiService) {
        this.dersKaydiService = dersKaydiService;
    }

    @PostMapping
    public DersKaydiResponseDto kaydet(
            @RequestBody DersKaydiRequestDto dto
    ) {

        DersKaydi dersKaydi = new DersKaydi();

        Ogrenci ogrenci = new Ogrenci();
        ogrenci.setId(dto.getOgrenciId());

        AcilanDers acilanDers = new AcilanDers();
        acilanDers.setId(dto.getAcilanDersId());

        dersKaydi.setOgrenci(ogrenci);
        dersKaydi.setAcilanDers(acilanDers);
        dersKaydi.setDurum(dto.getDurum());

        DersKaydi kaydedilen =
                dersKaydiService.kaydet(dersKaydi);

        DersKaydiResponseDto response =
                new DersKaydiResponseDto();

        response.setId(kaydedilen.getId());
        response.setOgrenciId(
                kaydedilen.getOgrenci().getId()
        );
        response.setAcilanDersId(
                kaydedilen.getAcilanDers().getId()
        );
        response.setDurum(
                kaydedilen.getDurum()
        );

        response.setKayitTarihi(
                kaydedilen.getKayitTarihi()
        );

        return response;
    }

    @GetMapping
    public List<DersKaydi> tumunuGetir() {
        return dersKaydiService.tumunuGetir();
    }


    @GetMapping("/ogrenci/{ogrenciId}")
    public List<DersKaydiResponseDto> ogrencininDersleri(
            @PathVariable UUID ogrenciId
    ) {

        List<DersKaydi> dersKayitlari =
                dersKaydiService.ogrencininDersleri(ogrenciId);

        return dersKayitlari.stream().map(kayit -> {

            DersKaydiResponseDto dto =
                    new DersKaydiResponseDto();

            dto.setId(kayit.getId());

            dto.setOgrenciId(
                    kayit.getOgrenci().getId()
            );

            dto.setAcilanDersId(
                    kayit.getAcilanDers().getId()
            );

            dto.setDurum(
                    kayit.getDurum()
            );

            dto.setKayitTarihi(
                    kayit.getKayitTarihi()
            );

            return dto;

        }).toList();
    }

    @DeleteMapping("/{id}")
    public String sil(@PathVariable UUID id) {

        dersKaydiService.sil(id);

        return "Ders kaydi silindi";
    }
}