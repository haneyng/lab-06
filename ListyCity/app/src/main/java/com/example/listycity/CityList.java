package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects.
 * @author CMPUT 301 - Lab 6 Tutorial, Han Nguyen
 * @version 1.2
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
     * @return the sorted list
     * @see <a href="https://howtodoinjava.com/java/collections/java-comparable-interface/">Java Comparable Interface</a>
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This method checks if the given city is already on the list.
     * @param city - the city to check
     * @return true if the city is on the list, false if not
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * If the given city is already on the list, this method deletes the city.
     * @param city - the city to delete
     * @throws RuntimeException when trying to delete a city not on the list
     */
    public void deleteCity(City city) {
        if (hasCity(city)) {
            cities.remove(city);
        }
        else {
            throw new RuntimeException("Cannot delete a city that doesn't exist.");
        }
    }

    /**
     * This method counts how many cities are there in the list.
     * @return the amount of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}
