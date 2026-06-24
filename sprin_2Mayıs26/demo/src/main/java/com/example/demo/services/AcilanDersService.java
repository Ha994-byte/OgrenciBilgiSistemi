package com.example.demo.services;

import com.example.demo.entities.AcilanDers;
import com.example.demo.repository.AcilanDersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AcilanDersService {

    private final AcilanDersRepository acilanDersRepository;

    public AcilanDersService(AcilanDersRepository acilanDersRepository) {
        this.acilanDersRepository = acilanDersRepository;
    }

    public List<AcilanDers> getAll() {
        return acilanDersRepository.findAll();
    }

    public AcilanDers getById(UUID id) {
        return acilanDersRepository.findById(id).orElse(null);
    }


    public AcilanDers guncelle(
            UUID id,
            AcilanDers dto
    ) {

        AcilanDers acilanDers =
                acilanDersRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Açılan ders bulunamadı")
                        );

        acilanDers.setDersId(dto.getDersId());

        acilanDers.setAkademisyenId(
                dto.getAkademisyenId()
        );

        acilanDers.setDonemId(
                dto.getDonemId()
        );

        acilanDers.setSinif(
                dto.getSinif()
        );

        return acilanDersRepository.save(acilanDers);
    }

    public AcilanDers kaydet(
            AcilanDers acilanDers
    ) {

        return acilanDersRepository.save(acilanDers);
    }

    public void sil(UUID id) {

        AcilanDers acilanDers =
                acilanDersRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Açılan ders bulunamadı"
                                )
                        );

        acilanDersRepository.delete(acilanDers);
    }


}