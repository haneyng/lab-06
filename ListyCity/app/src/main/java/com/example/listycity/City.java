package com.example.listycity;

/**
 * This is a class that defines a city.
 * @author CMPUT 301 - Lab 6 Tutorial; Javadocs by Han Nguyen
 * @version 1.1
 * @see CityList
 * @since ListyCity 1.0 (commit #1)
 */
public class City implements Comparable<City> {
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * This method returns the city name.
     * @return - name of city
     */
    String getCityName(){
        return this.city;
    }

    /**
     * This method returns the province name.
     * @return - name of province
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * This method compares the current city to the provided city.
     * @param o - the city to compare to
     * @return
     * <p>
     * 0 if both cities are equal;
     * less than 0 if this city is alphabetically before the provided city;
     * greater than 0 if this city is alphabetically after the provided city.
     * </p>
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
}

