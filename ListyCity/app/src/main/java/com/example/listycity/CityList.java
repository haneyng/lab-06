package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects.
 * @author CMPUT 301 - Lab 6 Tutorial
 * @version 1.0
 * @see City
 * @since ListyCity 1.0 (commit #1)
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This method adds a city to the list if the city does not exist.
     * @param city - This is a candidate city to add
     * @throws IllegalArgumentException - Occur when city already existed
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This method returns a sorted list of cities.
     * @return - the sorted list
     * @see <a href="https://howtodoinjava.com/java/collections/java-comparable-interface/">Java Comparable Interface</a>
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
}
