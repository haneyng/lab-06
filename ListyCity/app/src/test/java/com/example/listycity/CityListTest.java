package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        // add mock data
        CityList cityList = mockCityList();
        City city1 = new City("Yellowknife", "Northwest Territories");
        cityList.add(city1);
        City city2 = new City("Regina", "Saskatchewan");

        // city in list
        assertTrue(cityList.hasCity(city1));
        // city not in list
        assertFalse(cityList.hasCity(city2));
    }

    @Test
    void testDeleteCity() {
        // add mock data
        CityList cityList = mockCityList();
        City city1 = new City("Canmore", "Alberta");
        cityList.add(city1);

        // make sure there's 1 city + mockCity in cityList
        assertEquals(2, cityList.getCities().size());

        // delete city1
        cityList.deleteCity(city1);

        // if city1 is deleted, size should be 0 + mockCity
        assertEquals(1, cityList.getCities().size());
        // if city1 is deleted, it shouldn't be there anymore
        assertFalse(cityList.hasCity(city1));
    }

    @Test
    void testDeleteException() {
        // add mock data
        CityList cityList = mockCityList();

        // attempt an illegal deletion
        City city = new City("Yellowknife", "Northwest Territories");

        assertThrows(RuntimeException.class, () -> {
            cityList.deleteCity(city);
        });

        // if deleting fails, it should still have 1 city (mockCity)
        assertEquals(1, cityList.getCities().size());
    }

    @Test
    void testCountCity() {
        // add mock data
        CityList cityList = mockCityList();
        City city2 = new City("Canmore", "Alberta");
        cityList.add(city2);

        // must count to 1 city + mockCity in cityList
        assertEquals(2, cityList.countCities());

        // must count to 0 city + mockCity after deletion
        cityList.deleteCity(city2);
        assertEquals(1, cityList.countCities());

        // must count to 2 city + mockCity in cityList
        cityList.add(city2);
        City city3 = new City("Regina", "Saskatchewan");
        cityList.add(city3);
        assertEquals(3, cityList.countCities());

        // must count empty cityList
        CityList cityListEmpty = new CityList();
        assertEquals(0, cityListEmpty.countCities());
    }
}