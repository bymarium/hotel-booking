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
