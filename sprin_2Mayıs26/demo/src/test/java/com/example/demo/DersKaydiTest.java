package com.example.demo;

import com.example.demo.services.DersKaydiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class DersKaydiTest {

    @Autowired
    DersKaydiService service;

    @Test
    @Transactional
    void ogrenciDersKaydiYapabilir() {

        // 🔥 BURAYA GERÇEK UUID KOYACAKSIN
        UUID userId = UUID.fromString("b951bf36-3d07-4d66-a94b-e64d2dd03ffd");
        UUID dersId = UUID.fromString("999bbcb0-b82a-48b4-b42f-0689c5ccbbbc");
        UUID ogrenciId = UUID.fromString("e5c0d3ab-d46f-468a-a4fb-ca6757ecc5a1");


         service.kayitYap(userId, dersId, ogrenciId);


    }
}