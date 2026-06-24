package com.example.demo.controller;

import com.example.demo.dto.DersRequestDto;
import com.example.demo.dto.DersResponseDto;
import com.example.demo.entities.Ders;
import com.example.demo.repository.DersRepository;
import com.example.demo.services.DersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ders")
@RequiredArgsConstructor
public class DersController {

    private final DersService dersService;
    private final DersRepository dersRepository;




    @GetMapping
    public List<Ders> getAll() {
        return dersService.getAll();
    }

    @GetMapping("/{id}")
    public Ders getById(@PathVariable UUID id) {
        return dersService.getById(id);
    }

    @PutMapping("/{id}")
    public DersResponseDto guncelle(
            @PathVariable UUID id,
            @Valid @RequestBody DersRequestDto dto
    ) {

        Ders ders = new Ders();

        ders.setDersAdi(dto.getDersAdi());

        ders.setKredi(dto.getKredi());

        Ders guncellenen =
                dersService.update(id, ders);

        DersResponseDto response =
                new DersResponseDto();

        response.setId(guncellenen.getId());
        response.setDersAdi(
                guncellenen.getDersAdi()
        );
        response.setDersKodu(
                guncellenen.getDersKodu()
        );
        response.setKredi(
                guncellenen.getKredi()
        );

        return response;
    }

    @PostMapping
    public Ders create(

            @Valid
            @RequestBody
            DersRequestDto dto

    ) {

        Ders ders = new Ders();

        ders.setDersAdi(
                dto.getDersAdi()
        );

        ders.setKredi(
                dto.getKredi()
        );

        ders.setDersKodu(
                dto.getDersKodu()
        );

        return dersService.kaydet(ders);
    }








    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {

        dersService.delete(id);

        return "Ders silindi";
    }
}