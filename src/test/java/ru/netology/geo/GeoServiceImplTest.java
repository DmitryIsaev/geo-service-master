package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

class GeoServiceImplTest {

    @Test
    public void testIpCountryRussia() {
        GeoService geoService = new GeoServiceImpl();
        Country infoIp = geoService.byIp("172.").getCountry();
        Country locationIp = new Location(null, Country.RUSSIA, null, 0).getCountry();
        Assertions.assertEquals(locationIp, infoIp);
    }

    @Test
    public void testIpCityUSA() {
        GeoService geoService = new GeoServiceImpl();
        String infoIp = geoService.byIp("96.").getCity();
        String locationIp = new Location("New York", null, null, 0).getCity();
        Assertions.assertEquals(locationIp, infoIp);
    }
}