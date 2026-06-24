package com.example.demo.services;

import com.example.demo.entities.Ogrenci;
import com.example.demo.exceptions.KayitBulunamadiException;
import com.example.demo.repository.OgrenciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OgrenciService {

    private final OgrenciRepository repo;

    public List<Ogrenci> tumOgrencileriGetir() {
        return repo.findAll();
    }

    public Ogrenci ogrenciGetir(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ogrenci bulunamadi"));
    }

    public void ogrenciSil(UUID id) {

        if (!repo.existsById(id)) {

            throw new KayitBulunamadiException(
                    "Ogrenci bulunamadi"
            );


        }
        try {

            repo.deleteById(id);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Bu ogrencinin ders kayitlari oldugu icin silinemez"
            );
        }


    }

    public Ogrenci ogrenciKaydet(Ogrenci ogrenci) {

        return repo.save(ogrenci);
    }

    public Ogrenci idIleBul(UUID id) {

        return repo.findById(id)
                .orElseThrow(() ->
                        new KayitBulunamadiException(
                                "Ogrenci bulunamadi"
                        ));
    }

    public Ogrenci ogrenciGuncelle(UUID id, Ogrenci yeniOgrenci) {

        Ogrenci ogrenci = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ogrenci bulunamadi"));

        ogrenci.setOgrenciNo(yeniOgrenci.getOgrenciNo());
        ogrenci.setKayitTarihi(yeniOgrenci.getKayitTarihi());

        return repo.save(ogrenci);
    }
}