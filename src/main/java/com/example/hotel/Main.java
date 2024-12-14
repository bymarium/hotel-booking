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
    public static List<List<String>> createHotelsValues(int days) {
        List<String> cities = createCities();
        List<String> typeOfHousing = createHousing();
        List<List<String>> allHotels = new ArrayList<>();

        // Hoteles
        allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(0), "Marriott Hotel", "4.5", "150", String.valueOf(days * 150)));
        allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(0), "Hilton Garden Inn", "4.4", "120", String.valueOf(days * 120)));
        allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(0), "Ritz-Carlton", "5.0", "500", String.valueOf(days * 500)));
        allHotels.add(Arrays.asList(cities.get(3), typeOfHousing.get(0), "Holiday Inn", "4.2", "110", String.valueOf(days * 110)));
        allHotels.add(Arrays.asList(cities.get(4), typeOfHousing.get(0), "Sheraton", "4.3", "140", String.valueOf(days * 140)));

        // Apartamentos
        allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(1), "Apartamento Luxury", "4.7", "80", String.valueOf(days * 80)));
        allHotels.add(Arrays.asList(cities.get(1), typeOfHousing.get(1), "Apartamento Vista Mar", "4.6", "90", String.valueOf(days * 90)));
        allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(1), "Apartamento Moderno", "4.5", "75", String.valueOf(days * 75)));
        allHotels.add(Arrays.asList(cities.get(5), typeOfHousing.get(1), "Apartamento Familiar", "4.8", "100", String.valueOf(days * 100)));
        allHotels.add(Arrays.asList(cities.get(7), typeOfHousing.get(1), "Apartamento en el Centro", "4.4", "85", String.valueOf(days * 85)));

        // Fincas
        allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(2), "Finca El Paraíso", "4.9", "200", String.valueOf(days * 200)));
        allHotels.add(Arrays.asList(cities.get(1), typeOfHousing.get(2), "Finca La Esperanza", "4.6", "250", String.valueOf(days * 250)));
        allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(2), "Finca El Refugio", "4.8", "220", String.valueOf(days * 220)));
        allHotels.add(Arrays.asList(cities.get(4), typeOfHousing.get(2), "Finca Santa Isabel", "4.7", "180", String.valueOf(days * 180)));
        allHotels.add(Arrays.asList(cities.get(6), typeOfHousing.get(2), "Finca Las Palmas", "4.5", "170", String.valueOf(days * 170)));

        // Día de Sol
        allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(3), "Día de Sol Aventura", "4.5", "60", String.valueOf(days * 60)));
        allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(3), "Día de Sol Relax", "4.7", "50", String.valueOf(days * 50)));
        allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(3), "Día de Sol Familiar", "4.6", "70", String.valueOf(days * 70)));
        allHotels.add(Arrays.asList(cities.get(3), typeOfHousing.get(3), "Día de Sol Deportivo", "4.8", "80", String.valueOf(days * 80)));
        allHotels.add(Arrays.asList(cities.get(4), typeOfHousing.get(3), "Día de Sol con Spa", "4.9", "100", String.valueOf(days * 100)));

        return allHotels;
    }


    public static void getHotels(List<List<String>> hotels) {
        System.out.println("Listado de hoteles:");
        for (List<String> hotel : hotels) {
            System.out.println("Ciudad: " + hotel.get(0));
            System.out.println("Alojamiento: " + hotel.get(1));
            System.out.println("Nombre: " + hotel.get(2));
            System.out.println("Calificacion: $" + hotel.get(3));
            System.out.println("Precio por dia: $" + hotel.get(4));
            System.out.println("Precio calculado por dias: $" + hotel.get(5));
            System.out.println("-----------------------------------");
        }
    }

    public static void getHotelByCityAndHousing(List<List<String>> hotels, String city, String housing) {
        System.out.println("Listado de hoteles:");
        for (List<String> hotel : hotels) {
            if ( hotel.get(0).equals(city) && hotel.get(1).equals(housing)) {
                System.out.println("Nombre: " + hotel.get(2));
                System.out.println("Calificacion: $" + hotel.get(3));
                System.out.println("Precio por dia: $" + hotel.get(4));
                System.out.println("Precio calculado por dias: $" + hotel.get(5));
                System.out.println("-----------------------------------");
            }
        }

    }
    // endregion

    // region type of room
    public static List<String> createTypesOfRoom() {
        List<String> types = new ArrayList<>();
        types.add("Habitacion Sencilla");
        types.add("Habitacion Doble");
        types.add("Habitacion Triple");
        types.add("Habitacion Suite");
        types.add("Habitacion Suite Deluxe");

        return types;
    }

    public static List<List<String>> createRooms() {
        List<String> housings = createHousing();
        List<String> roomTypes = createTypesOfRoom();
        List<List<String>> rooms = new ArrayList<>();

        // Hotel rooms
        rooms.add(Arrays.asList(housings.get(0), roomTypes.get(0), "Habitación sencilla con 1 cama, aire acondicionado, TV, baño privado y Wi-Fi gratuito.", "100"));
        rooms.add(Arrays.asList(housings.get(0), roomTypes.get(1), "Habitación doble con 2 camas dobles, minibar, vista al mar, aire acondicionado y desayuno incluido.", "150"));
        rooms.add(Arrays.asList(housings.get(0), roomTypes.get(3), "Suite con cama king size, sala de estar, bañera de hidromasaje, vista panorámica y servicio a la habitación 24/7.", "300"));
        rooms.add(Arrays.asList(housings.get(0), roomTypes.get(4), "Suite Deluxe con cama king size, terraza privada, piscina climatizada y acceso exclusivo al spa.", "500"));

        // Apartment rooms
        rooms.add(Arrays.asList(housings.get(1), roomTypes.get(0), "Estudio moderno con cocina equipada, cama individual, baño privado y balcón.", "150"));
        rooms.add(Arrays.asList(housings.get(1), roomTypes.get(2), "Apartamento de 2 habitaciones, cocina completa, sala de estar y terraza con vista a la ciudad.", "300"));
        rooms.add(Arrays.asList(housings.get(1), roomTypes.get(3), "Penthouse con 3 dormitorios, jacuzzi, sala de cine, terraza privada y ascensor exclusivo.", "600"));

        // Country house (Finca) rooms
        rooms.add(Arrays.asList(housings.get(2), roomTypes.get(0), "Cabaña rústica con cama sencilla, baño compartido, chimenea y vista a las montañas.", "120"));
        rooms.add(Arrays.asList(housings.get(2), roomTypes.get(2), "Habitación triple en casa de campo, incluye desayuno con productos locales y acceso a piscina natural.", "250"));
        rooms.add(Arrays.asList(housings.get(2), roomTypes.get(4), "Suite Deluxe en finca, con jacuzzi al aire libre, terraza con hamacas y vistas al valle.", "450"));

        // Day-use (Día de Sol) rooms
        rooms.add(Arrays.asList(housings.get(3), roomTypes.get(1), "Habitación doble para uso diurno, incluye acceso a piscina, almuerzo buffet y bebidas.", "80"));
        rooms.add(Arrays.asList(housings.get(3), roomTypes.get(2), "Habitación triple con acceso a zonas recreativas, spa y transporte incluido.", "120"));
        rooms.add(Arrays.asList(housings.get(3), roomTypes.get(4), "Suite Deluxe para uso diurno, incluye piscina privada, almuerzo gourmet y servicio de masajes.", "300"));

        return rooms;
    }

    public static void displayRooms(List<List<String>> rooms) {
        System.out.println("Listado de habitaciones:");
        for (List<String> room : rooms) {
            System.out.println("Alojamiento: " + room.get(0));
            System.out.println("Tipo de Habitación: " + room.get(1));
            System.out.println("Descripción: " + room.get(2));
            System.out.println("Precio: $" + room.get(3));
            System.out.println("-----------------------------------");
        }
    }
    // endregion


}
