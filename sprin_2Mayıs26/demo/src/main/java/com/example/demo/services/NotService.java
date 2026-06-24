package com.example.demo.services;

import com.example.demo.dto.NotResponseDto;
import com.example.demo.entities.Not;
import com.example.demo.entities.Ogrenci;
import com.example.demo.repository.NotRepository;

import com.example.demo.repository.OgrenciRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotService {

    private final NotRepository notRepository;
    private final OgrenciRepository ogrenciRepository;

    public List<NotResponseDto>
    ogrencininNotlari(UUID ogrenciId) {

        List<Not> notlar =
                notRepository
                        .findByOgrenci_Id(
                                ogrenciId
                        );

        return notlar.stream().map(not -> {

            NotResponseDto dto =
                    new NotResponseDto();

            dto.setId(not.getId());

            dto.setVize(not.getVize());

            dto.setFinalNotu(
                    not.getFinalNotu()
            );

            dto.setOrtalama(
                    not.getOrtalama()
            );

            if (not.getDers() != null) {

                dto.setDersAdi(
                        not.getDers()
                                .getDersAdi()
                );

                dto.setDersId(
                        not.getDers().getId()
                );
            }

            return dto;

        }).toList();
    }

    public Double dersOrtalamasi(
            UUID dersId
    ) {

        return notRepository
                .dersOrtalamasi(dersId);
    }

    public Double okulGanoOrtalamasi() {

        List<Ogrenci> ogrenciler =
                ogrenciRepository.findAll();

        double toplamGano = 0;

        int ogrenciSayisi = 0;

        for (Ogrenci ogrenci : ogrenciler) {

            List<Not> notlar =
                    notRepository
                            .findByOgrenci_Id(
                                    ogrenci.getId()
                            );

            if (notlar.isEmpty()) {
                continue;
            }

            double toplamPuan = 0;

            double toplamKredi = 0;

            for (Not not : notlar) {

                double katsayi = 0;

                double ortalama =
                        not.getOrtalama();

                if (ortalama >= 87)
                    katsayi = 4;

                else if (ortalama >= 81)
                    katsayi = 3.5;

                else if (ortalama >= 74)
                    katsayi = 3;

                else if (ortalama >= 67)
                    katsayi = 2.5;

                else if (ortalama >= 60)
                    katsayi = 2;

                else if (ortalama >= 53)
                    katsayi = 1.5;

                else if (ortalama >= 46)
                    katsayi = 1;

                else if (ortalama >= 39)
                    katsayi = 0.5;

                int kredi = 3;

                if (
                        not.getDers() != null
                                &&
                                not.getDers()
                                        .getKredi() != null
                ) {

                    kredi =
                            not.getDers()
                                    .getKredi();
                }

                toplamPuan +=
                        kredi * katsayi;

                toplamKredi += kredi;
            }

            double gano =
                    toplamPuan / toplamKredi;

            toplamGano += gano;

            ogrenciSayisi++;
        }

        return Math.round(
                (toplamGano /
                        ogrenciSayisi) * 100.0
        ) / 100.0;
    }


    public Not notGuncelle(
            UUID id,
            Not yeniNot
    ) {

        Not not =
                notRepository
                        .findById(id)
                        .orElseThrow();

        not.setVize(
                yeniNot.getVize()
        );

        not.setFinalNotu(
                yeniNot.getFinalNotu()
        );

        double ortalama =
                (
                        yeniNot.getVize() * 0.4
                ) +
                        (
                                yeniNot.getFinalNotu() * 0.6
                        );

        not.setOrtalama(
                ortalama
        );

        return notRepository.save(not);
    }


}