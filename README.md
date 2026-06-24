# Havva KELEKLİ tarafından ogrenci bilgi sistemi otomasyonu geliştirilmiştir

# Öğrenci Bilgi Sistemi (OBS) Projesi


Bu proje, bir üniversite Öğrenci Bilgi Sistemi (OBS) uygulamasıdır. Proje, modern web teknolojileri kullanılarak geliştirilmiş bir frontend (ön uç) ve güvenli bir REST API sunan Spring Boot backend (arka uç) olmak üzere iki ana kısımdan oluşmaktadır.

## Proje Yapısı

* **`gözlem-ön uç` (obs-frontend):** React ve Vite ile geliştirilmiş kullanıcı arayüzü.
* **`sprin_2Mayıs26` (backend):** Spring Boot (Java 21) ve PostgreSQL ile geliştirilmiş REST API servisleri.

---

## Kurulum ve Çalıştırma

### 1. Veritabanı Yapılandırması (Önemli - Güvenlik Adımı)

Projenin veritabanı şifreleri ve JWT anahtarları güvenlik nedeniyle GitHub'a yüklenmemektedir. Yerelde çalıştırmak için şu adımları izleyin:

1. `sprin_2Mayıs26/demo/src/main/resources/` dizinine gidin.
2. `application-local.yaml.example` dosyasının bir kopyasını oluşturun ve adını `application-local.yaml` yapın.
3. `application-local.yaml` dosyasını açıp kendi yerel PostgreSQL bağlantı bilgilerinizi ve şifrenizi girin:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/veritabani_adiniz
    username: postgres
    password: veritabani_sifreniz

app:
  jwt:
    secret: en_az_256_bit_uzunlugunda_guvenli_bir_jwt_anahtari
```

### 2. Backend (Arka Uç) Çalıştırma

1. `sprin_2Mayıs26/demo` dizinine girin.
2. Maven ile projeyi derleyin ve çalıştırın:
   ```bash
   ./mvnw spring-boot:run
   ```

### 3. Frontend (Ön Uç) Çalıştırma

1. `gözlem-ön uç` dizinine girin.
2. Bağımlılıkları yükleyin:
   ```bash
   npm install
   ```
3. Uygulamayı geliştirme modunda çalıştırın:
   ```bash
   npm run dev
   ```

---

## Güvenlik ve Gizlilik Hakkında

Bu projenin GitHub geçmişi ve güncel dosyaları, hassas veri sızıntılarını önlemek amacıyla temizlenmiştir. Yerel veritabanı şifrelerini barındıran `application-local.yaml` dosyası Git takibine takılmaması için `.gitignore` dosyasına eklenmiştir.
