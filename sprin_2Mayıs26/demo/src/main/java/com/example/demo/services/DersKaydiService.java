package com.example.demo.services;

import com.example.demo.entities.AcilanDers;
import com.example.demo.entities.DersKaydi;
import com.example.demo.entities.Ogrenci;
import com.example.demo.exceptions.KontenjanDoluException;
import com.example.demo.exceptions.ZatenKayitliException;
import com.example.demo.repository.AcilanDersRepository;
import com.example.demo.repository.DersKaydiRepository;
import com.example.demo.repository.OgrenciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.entities.AcilanDers;
import com.example.demo.entities.Sinif;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DersKaydiService {

    private final DersKaydiRepository repo;
    private final OgrenciRepository ogrenciRepository;
    private final AcilanDersRepository acilanDersRepository;

    public DersKaydi kaydet(DersKaydi dersKaydi) {



        Ogrenci ogrenci = ogrenciRepository.findById(
                dersKaydi.getOgrenci().getId()
        ).orElseThrow();

        AcilanDers acilanDers = acilanDersRepository.findById(
                dersKaydi.getAcilanDers().getId()
        ).orElseThrow();

        boolean varMi =
                repo
                        .existsByOgrenciIdAndAcilanDersId(
                                ogrenci.getId(),
                                acilanDers.getId()
                        );

        if (varMi) {

            throw new ZatenKayitliException(
                    "Ogrenci bu derse zaten kayitli"
            );
        }



        Sinif sinif = acilanDers.getSinif();

        long kayitSayisi =
                repo.countByAcilanDers_Id(acilanDers.getId());

        if (kayitSayisi >= sinif.getKapasite()) {
            throw new KontenjanDoluException(
                    "Kontenjan dolu"
            );
        }

        dersKaydi.setOgrenci(ogrenci);
        dersKaydi.setAcilanDers(acilanDers);
        dersKaydi.setKayitTarihi(LocalDateTime.now());

        return repo.save(dersKaydi);
    }

    public List<DersKaydi> tumunuGetir() {
        return repo.findAll();
    }

    public List<DersKaydi> ogrencininDersleri(UUID ogrenciId) {

        Ogrenci ogrenci = ogrenciRepository
                .findById(ogrenciId)
                .orElseThrow();

        return repo.findByOgrenci(ogrenci);
    }

    public void sil(UUID id) {
        repo.deleteById(id);
    }

    public void kayitYap(

            UUID ogrenciId,
            UUID acilanDersId,
            UUID notId
    ) {
        Ogrenci ogrenci =
                ogrenciRepository
                        .findById(ogrenciId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Ogrenci bulunamadi"
                                )
                        );
        AcilanDers acilanDers =
                acilanDersRepository
                        .findById(acilanDersId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Acilan ders bulunamadi"
                                )
                        );

    }


}