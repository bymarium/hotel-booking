package com.example.hotel;

import java.util.ArrayList;
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
}
