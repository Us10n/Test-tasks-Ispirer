package by.stas.app.entity;

import java.util.Arrays;

public enum LanguageEnum {
    ENGLISH("English (EN)"),
    RUSSIAN("Русский (RU)");

    String value;

    LanguageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static LanguageEnum getComboItemByValue(String value) {
        return Arrays.stream(LanguageEnum.values())
                .filter(comboItem ->
                        comboItem.value.equals(value))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("No enum constant with value " + value)
                );
    }
}
