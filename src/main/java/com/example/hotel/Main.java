package com.example.hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    // region city
    public static List<String> createCities() {
        List<String> cities = new ArrayList<>();
        cities.add("Cartagena");
        cities.add("Medellín");
        cities.add("Bogotá");
        cities.add("Santa Marta");
        cities.add("San Andrés");
        cities.add("Barichara");
        cities.add("Guatapé");
        cities.add("Cali");

        return cities;
    }

    public static String getCity() {
        List<String> cities = createCities();

        System.out.println("Ciudades disponibles:");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println((i + 1) + ". " + cities.get(i));
        }

        Scanner sc = new Scanner(System.in);
        int ciudad = -1;

        while (true) {
            try {
                System.out.print("\nEscribe el número de la ciudad que deseas seleccionar (1-" + cities.size() + "): ");
                ciudad = sc.nextInt();

                if (ciudad > 0 && ciudad <= cities.size()) {
                    return cities.get(ciudad - 1);
                } else {
                    System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Inténtalo de nuevo.");
                sc.next();
            }

        }
    }
    // endregion

    // region type of housing
    public static List<String> createHousing() {
        List<String> types = new ArrayList<>();
        types.add("Hotel");
        types.add("Apartamento");
        types.add("Finca");
        types.add("Dia de Sol");

        return types;
    }

    public static String getHousing() {
        List<String> types = createHousing();

        System.out.println("Tipos de alojamiento:");
        for (int i = 0; i < types.size(); i++) {
            System.out.println((i + 1) + ". " + types.get(i));
        }

        Scanner sc = new Scanner(System.in);
        int type = -1;

        while (true) {
            try {
                System.out.print("\nEscribe el número del alojamiento que deseas seleccionar (1-" + types.size() + "): ");
                type = sc.nextInt();

                if (type > 0 && type <= types.size()) {
                    return types.get(type - 1);
                } else {
                    System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Inténtalo de nuevo.");
                sc.next();
            }

        }
    }
    // endregion

    // region hotel
    public static List<String> createHotelsKeys() {
        List<String> hotelKeys = new ArrayList<>();
        hotelKeys.add("Nombre");
        hotelKeys.add("Calificacion");
        hotelKeys.add("Precio por noche");
        hotelKeys.add("Precio calculado por dias");

        return hotelKeys;
    }

    public static List<List<String>> createHotelsValues(int days) {
        List<String> hotelValue1 = Arrays.asList("Hotel 1", "4.5", "100", String.valueOf(days * 100));
        List<String> hotelValue2 = Arrays.asList("Hotel 2", "4.0", "150", String.valueOf(days * 150));
        List<String> hotelValue3 = Arrays.asList("Hotel 3", "4.0", "200", String.valueOf(days * 200));
        List<String> hotelValue4 = Arrays.asList("Hotel 4", "4.0", "250", String.valueOf(days * 250));
        List<String> hotelValue5 = Arrays.asList("Hotel 5", "4.0", "300", String.valueOf(days * 300));

        List<List<String>> hotels = new ArrayList<>();
        hotels.add(hotelValue1);
        hotels.add(hotelValue2);
        hotels.add(hotelValue3);
        hotels.add(hotelValue4);
        hotels.add(hotelValue5);

        return hotels;
    }


    public static void getHotel() {
        List<String> keys = createHotelsKeys();
        List<List<String>> hotels = createHotelsValues(6);

        System.out.println("Hoteles disponibles:");
        for (int i = 0; i < hotels.size(); i++) {
            System.out.println((i + 1) + ":");
            List<String> hotelValues = hotels.get(i);

            for (int j = 0; j < keys.size(); j++) {
                System.out.println("  " + keys.get(j) + ": " + hotelValues.get(j));
            }
            System.out.println();
        }

        Scanner sc = new Scanner(System.in);
        int hotel = -1;

        while (true) {
            try {
                System.out.print("\nEscribe el número del hotel que deseas seleccionar (1-" + hotels.size() + "): ");
                hotel = sc.nextInt();

                if (hotel > 0 && hotel <= hotels.size()) {
                    List<String> selectedHotel = hotels.get(hotel - 1);
                    System.out.println("\nDetalles del Hotel: " );
                    for (int i = 0; i < keys.size(); i++) {
                        System.out.println(keys.get(i) + ": " + selectedHotel.get(i));
                    }
                    break;
                } else {
                    System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Inténtalo de nuevo.");
                sc.next();
            }
        }
    }

    // endregion
}
