package pl.akademiaqa.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
//ogranicza możliwośc wrzocenia obiektów klasy utils z zewnątrz, będziemy mogli dostawać się do tej klasy jedynie za pomocą statycznych metod
public class StringUtils {
    public static String removeRoundBrackets(String text) {
        return text.replaceAll("[()]", "");
    }

    public static String toUTF8(String str) {
        return new String(str.getBytes(), StandardCharsets.UTF_8);
    }
}
