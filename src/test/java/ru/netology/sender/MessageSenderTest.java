package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MessageSenderTest {
    private GeoService geoService;
    private LocalizationService localizationService;
    private MessageSender messageSender;
    private Map<String, String> headers;

    @BeforeEach
    void setUp () {
        geoService = mock(GeoService.class);
        localizationService = mock(LocalizationService.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
        headers = new HashMap<>();
    }

    @Test
    public void testSendMessageRussia() {
        Mockito.when(geoService.byIp("172.")).thenReturn(new Location(null, Country.RUSSIA, null,0));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать\n");
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");
        String infoIp = messageSender.send(headers);
        String locationIp = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(infoIp, locationIp);
    }

    @Test
    public void testSendMessageUSA() {
        Mockito.when(geoService.byIp("96.")).thenReturn(new Location(null, Country.RUSSIA, null,0));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Welcome\n");
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");
        String infoIp = messageSender.send(headers);
        String locationIp = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(infoIp, locationIp);
    }
}