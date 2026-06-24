BEGIN;

WITH source_users AS (
    SELECT *
    FROM (
        VALUES
            ('Havva Kelekli', '31415926542'),
            ('Meltem Yilmaz', '27182818284'),
            ('Berra Yildirim', '16180339887')
    ) AS v(ad_soyad, tc_no)
),
generated_users AS (
    SELECT
        su.ad_soyad,
        su.tc_no,
        gen_random_uuid() AS user_id,
        gen_random_uuid() AS ogrenci_id
    FROM source_users su
),
inserted_ogrenci AS (
    INSERT INTO ogrenci (id, insan_id)
    SELECT gu.ogrenci_id, gu.user_id
    FROM generated_users gu
    RETURNING id, insan_id
)
SELECT
    gu.ad_soyad,
    gu.tc_no,
    gu.user_id AS "userId",
    gu.ogrenci_id AS "ogrenciId"
FROM generated_users gu
ORDER BY gu.ad_soyad;

COMMIT;

-- Ders parametresi icin mevcut bir dersi almak istersen:
-- SELECT id AS "dersId" FROM acilan_ders ORDER BY id LIMIT 1;
-- Not: Bu script her calistiginda yeni random UUID uretir.
