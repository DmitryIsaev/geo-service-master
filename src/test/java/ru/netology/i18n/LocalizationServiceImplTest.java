package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {
    @Test
    public void testLocalRussia() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String infoCountry = localizationService.locale(Country.RUSSIA);
        String textGreeting = "Добро пожаловать";
        Assertions.assertEquals(infoCountry, textGreeting);
    }

    @Test
    public void testLocalGermany() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String infoCountry = localizationService.locale(Country.GERMANY);
        String textGreeting = "Welcome";
        Assertions.assertEquals(infoCountry, textGreeting);
    }

    @Test
    public void testLocalUSA() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String infoCountry = localizationService.locale(Country.USA);
        String textGreeting = "Welcome";
        Assertions.assertEquals(infoCountry, textGreeting);
    }
}