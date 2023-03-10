package com.example.lab8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.testng.annotations.Test;
import com.example.lab8.City;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CustomListTest {
    private CustomList mockCityList() {
        CustomList cityList = new CustomList();
        CustomList.addCity(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    //test add method using unit test
//    @Test
//    void testAdd(){
//        CityList cityList = mockCityList();
//        assertEquals(1, cityList.getCities().size());
//        City city = new City("Regina", "Saskatchewan");
//        cityList.add(city);
//        assertEquals(2, cityList.getCities().size());
//        assertTrue(cityList.getCities().contains(city));
//    }
//    @Test
//    void testAddException() {
//        CityList cityList = mockCityList();
//        City city = new City("Yellowknife", "Northwest Territories");
//        cityList.add(city);
//        assertThrows( IllegalArgumentException.class, () -> {
//            cityList.add(city); });
//    }
//    @Test
//    void testGetCities() {
//        CityList cityList = mockCityList();
//        assertEquals(0,
//                mockCity().compareTo(cityList.getCities().get(0)));
//        City city = new City("Charlottetown", "Prince Edward Island");
//        cityList.add(city);
//        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
//        assertEquals(0,
//                mockCity().compareTo(cityList.getCities().get(1)));
//    }

    @Test
    void testHasCities() {
        CustomList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Seoul", "Gyeonggi");
        cityList.add(city); //add the new city value to the citylist
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.hasCity(city)); //check if the citylist contains the new added value
        assertEquals(cityList.hasCity(city), cityList.getCities().contains(city));
        //lastly check if it equals to the value of contains() method
    }

    @Test
    void testDelete(){
        CustomList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Seoul", "Gyeonggi");
        cityList.add(city); //add the new city value to the citylist
        assertEquals(2, cityList.getCities().size()); //check if new city is successfully added
        cityList.delete(city); //delete the new element
        assertEquals(1, cityList.getCities().size()); //check if theres only 1 value left
        assertFalse(cityList.hasCity(city)); //check if the citylist doesnt contain the new city anymore
        assertEquals(cityList.hasCity(city), cityList.getCities().contains(city));
        //lastly check if it equals to the value of contains() method
    }

    @Test
    void testDeleteException() {
        CustomList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city); //add the new value inside the citylist
        cityList.delete(city); //remove the citylist
        assertThrows( IllegalArgumentException.class, () -> {
            cityList.delete(city); }); //remove it agian so that it throws an exception
    }

    @Test
    void countCities() {
        CustomList cityList = mockCityList();
        City city = new City("Seoul", "Gyeonggi");
        cityList.add(city); //add the new city value to the citylist
        assertEquals(2, cityList.getCount()); //check if the countCities return the correct value
        assertEquals(cityList.getCount(), cityList.getCities().size());
        //check if the countCities has the same value with getCities().size()
        //which also counts the elements inside the cityList
    }
}

