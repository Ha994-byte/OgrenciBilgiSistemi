package com.example.demo.services;

import com.example.demo.entities.Ders;
import com.example.demo.repository.DersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DersService {

    private final DersRepository dersRepository;

    public DersService(DersRepository dersRepository) {
        this.dersRepository = dersRepository;
    }

    public List<Ders> getAll() {
        return dersRepository.findAll();
    }

    public Ders getById(UUID id) {
        return dersRepository.findById(id).orElse(null);
    }



    public Ders update(UUID id, Ders yeniDers) {

        Ders ders = dersRepository.findById(id).orElse(null);

        if (ders == null) {
            return null;
        }

        ders.setDersKodu(yeniDers.getDersKodu());
        ders.setDersAdi(yeniDers.getDersAdi());
        ders.setKredi(yeniDers.getKredi());

        return dersRepository.save(ders);
    }

    public Ders kaydet(Ders ders) {

        return dersRepository.save(ders);
    }

    public void delete(UUID id) {
        dersRepository.deleteById(id);
    }
}