package com.example.hotel;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2025, 2, 23);
        LocalDate endDate = LocalDate.of(2025, 2, 28);

        List< String > hotel = createDesiredAccommodation("Bogotá", "Hotel", startDate, endDate, 2, 0, 2);

        confirmRooms(hotel.get(2), startDate, endDate, 2, 0, 2);
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
    public static List<List<String>> createHotelsValues(int price, int days) {
        List<String> cities = createCities();
        List<String> typeOfHousing = createHousing();
        List<List<String>> allHotels = new ArrayList<>();

        // Hoteles
        allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(0), "Marriott Hotel", "4.5", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(0), "Hilton Garden Inn", "4.4", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(0), "Ritz-Carlton", "5.0", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(3), typeOfHousing.get(0), "Holiday Inn", "4.2", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(4), typeOfHousing.get(0), "Sheraton", "4.3", String.valueOf(price), String.valueOf(days * price)));

        // Apartamentos
        allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(1), "Apartamento Luxury", "4.7", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(1), typeOfHousing.get(1), "Apartamento Vista Mar", "4.6", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(1), "Apartamento Moderno", "4.5", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(5), typeOfHousing.get(1), "Apartamento Familiar", "4.8", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(7), typeOfHousing.get(1), "Apartamento en el Centro", "4.4", String.valueOf(price), String.valueOf(days * price)));

        // Fincas
        allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(2), "Finca El Paraíso", "4.9", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(1), typeOfHousing.get(2), "Finca La Esperanza", "4.6", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(2), "Finca El Refugio", "4.8", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(4), typeOfHousing.get(2), "Finca Santa Isabel", "4.7", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(6), typeOfHousing.get(2), "Finca Las Palmas", "4.5", String.valueOf(price), String.valueOf(days * price)));

        // Día de Sol
        allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(3), "Día de Sol Aventura", "4.5", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(3), "Día de Sol Relax", "4.7", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(3), "Día de Sol Familiar", "4.6", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(3), typeOfHousing.get(3), "Día de Sol Deportivo", "4.8", String.valueOf(price), String.valueOf(days * price)));
        allHotels.add(Arrays.asList(cities.get(4), typeOfHousing.get(3), "Día de Sol con Spa", "4.9", String.valueOf(price), String.valueOf(days * price)));

        return allHotels;
    }


    public static void getHotels(List<List<String>> hotels) {
        System.out.println("Listado de hoteles:");
        for (List<String> hotel : hotels) {
            System.out.println("Ciudad: " + hotel.get(0));
            System.out.println("Alojamiento: " + hotel.get(1));
            System.out.println("Nombre: " + hotel.get(2));
            System.out.println("Calificacion: $" + hotel.get(3));
            System.out.println("Precio por noche: $" + hotel.get(4));
            System.out.println("Precio calculado por dias: $" + hotel.get(5));
            System.out.println("-----------------------------------");
        }
    }

    public static void getHotel(List<String> hotel) {
        System.out.println("  Nombre: " + hotel.get(2));
        System.out.println("  Calificación: " + hotel.get(3));
        System.out.println("  Precio por noche: $" + hotel.get(4));
        System.out.println("  Precio calculado por días: $" + hotel.get(5));
    }

    public static List<String> getHotelByCityAndHousing(List<List<String>> hotels, String city, String housing) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Listado de hoteles:");
        int index = 1;
        for (List<String> hotel : hotels) {
            if (hotel.get(0).equals(city) && hotel.get(1).equals(housing)) {
                System.out.println(index + ":");
                getHotel(hotel);
                System.out.println("-----------------------------------");
                index++;
            }
        }
        if (index == 1) {
            System.out.println("No se encontraron hoteles que coincidan con los criterios.");
        }

        int selection = -1;
        while (true) {
            try {
                System.out.print("\nEscribe el número del hotel que deseas seleccionar (1-" + (index - 1) + "): ");
                selection = sc.nextInt();

                if (selection > 0 && selection < index) {
                    int currentIndex = 1;
                    for (List<String> hotel : hotels) {
                        if (hotel.get(0).equals(city) && hotel.get(1).equals(housing)) {
                            if (currentIndex == selection) {
                                return hotel;
                            }
                            currentIndex++;
                        }
                    }
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
        types.add("Actividades de dia de sol");

        return types;
    }

    public static List<List<String>> createRooms(int days) {
        List<List<String>> hotels = createHotelsValues(100, days);
        List<String> roomTypes = createTypesOfRoom();
        List<List<String>> rooms = new ArrayList<>();

        // Hotel rooms
        rooms.add(Arrays.asList(hotels.get(0).get(2), roomTypes.get(0), "Habitación sencilla con 1 cama, aire acondicionado, TV, baño privado y Wi-Fi gratuito.", "100", "10"));
        rooms.add(Arrays.asList(hotels.get(0).get(2), roomTypes.get(1), "Habitación doble con 2 camas dobles, minibar, vista al mar, aire acondicionado y desayuno incluido.", "150", "7"));
        rooms.add(Arrays.asList(hotels.get(0).get(2), roomTypes.get(2), "Habitacion triple con 3 camas dobles, minibar, vista al mar, aire acondicionado y servicio a la habitación 24/7.", "250", "20"));
        rooms.add(Arrays.asList(hotels.get(0).get(2), roomTypes.get(3), "Suite con cama king size, sala de estar, bañera de hidromasaje, vista panorámica y servicio a la habitación 24/7.", "300", "10"));
        rooms.add(Arrays.asList(hotels.get(0).get(2), roomTypes.get(4), "Suite Deluxe con cama king size, terraza privada, piscina climatizada y acceso exclusivo al spa.", "500", "10"));

        rooms.add(Arrays.asList(hotels.get(1).get(2), roomTypes.get(0), "Habitación sencilla con 1 cama, aire acondicionado, TV, baño privado, Wi-Fi gratuito y escritorio de trabajo.", "110", "15"));
        rooms.add(Arrays.asList(hotels.get(1).get(2), roomTypes.get(1), "Habitación doble con 2 camas dobles, minibar, vista al mar, aire acondicionado, desayuno incluido y acceso a gimnasio.", "170", "6"));
        rooms.add(Arrays.asList(hotels.get(1).get(2), roomTypes.get(2), "Habitación triple con 3 camas dobles, minibar, vista al mar, aire acondicionado, servicio a la habitación 24/7 y acceso a actividades recreativas.", "270", "18"));
        rooms.add(Arrays.asList(hotels.get(1).get(2), roomTypes.get(3), "Suite con cama king size, sala de estar, bañera de hidromasaje, vista panorámica, servicio a la habitación 24/7 y acceso exclusivo a la piscina privada.", "350", "12"));
        rooms.add(Arrays.asList(hotels.get(1).get(2), roomTypes.get(4), "Suite Deluxe con cama king size, terraza privada, piscina climatizada, acceso exclusivo al spa y servicio personalizado de conserjería.", "600", "8"));

        rooms.add(Arrays.asList(hotels.get(2).get(2), roomTypes.get(0), "Habitación sencilla con 1 cama, aire acondicionado, TV, baño privado, Wi-Fi gratuito y vista a la ciudad.", "110", "12"));
        rooms.add(Arrays.asList(hotels.get(2).get(2), roomTypes.get(1), "Habitación doble con 2 camas dobles, minibar, vista al mar, aire acondicionado, desayuno incluido y balcón privado.", "160", "8"));
        rooms.add(Arrays.asList(hotels.get(2).get(2), roomTypes.get(2), "Habitación triple con 3 camas dobles, minibar, vista al mar, aire acondicionado, servicio a la habitación 24/7 y acceso a la piscina exterior.", "270", "15"));
        rooms.add(Arrays.asList(hotels.get(2).get(2), roomTypes.get(3), "Suite con cama king size, sala de estar, bañera de hidromasaje, vista panorámica, servicio a la habitación 24/7 y acceso al spa.", "350", "9"));
        rooms.add(Arrays.asList(hotels.get(2).get(2), roomTypes.get(4), "Suite Deluxe con cama king size, terraza privada, piscina climatizada, acceso exclusivo al spa y servicio de mayordomo.", "600", "6"));

        rooms.add(Arrays.asList(hotels.get(3).get(2), roomTypes.get(0), "Habitación sencilla con 1 cama, aire acondicionado, TV, baño privado, Wi-Fi gratuito y vistas al jardín.", "120", "12"));
        rooms.add(Arrays.asList(hotels.get(3).get(2), roomTypes.get(1), "Habitación doble con 2 camas dobles, minibar, vista al mar, aire acondicionado, desayuno incluido y balcón privado.", "170", "6"));
        rooms.add(Arrays.asList(hotels.get(3).get(2), roomTypes.get(2), "Habitación triple con 3 camas dobles, minibar, vista al mar, aire acondicionado, servicio a la habitación 24/7 y acceso al gimnasio.", "270", "18"));
        rooms.add(Arrays.asList(hotels.get(3).get(2), roomTypes.get(3), "Suite con cama king size, sala de estar, bañera de hidromasaje, vista panorámica, servicio a la habitación 24/7 y acceso exclusivo al lounge ejecutivo.", "350", "8"));
        rooms.add(Arrays.asList(hotels.get(3).get(2), roomTypes.get(4), "Suite Deluxe con cama king size, terraza privada, piscina climatizada, acceso exclusivo al spa y servicio de mayordomo las 24 horas.", "550", "5"));

        rooms.add(Arrays.asList(hotels.get(4).get(2), roomTypes.get(0), "Habitación sencilla con 1 cama, aire acondicionado, TV, baño privado, Wi-Fi gratuito y una vista al jardín.", "110", "15"));
        rooms.add(Arrays.asList(hotels.get(4).get(2), roomTypes.get(1), "Habitación doble con 2 camas dobles, minibar, vista al mar, aire acondicionado, desayuno incluido y terraza privada.", "170", "8"));
        rooms.add(Arrays.asList(hotels.get(4).get(2), roomTypes.get(2), "Habitación triple con 3 camas dobles, minibar, vista al mar, aire acondicionado, servicio a la habitación 24/7 y acceso a la piscina.", "270", "18"));
        rooms.add(Arrays.asList(hotels.get(4).get(2), roomTypes.get(3), "Suite con cama king size, sala de estar, bañera de hidromasaje, vista panorámica, servicio a la habitación 24/7 y acceso exclusivo al gimnasio.", "350", "12"));
        rooms.add(Arrays.asList(hotels.get(4).get(2), roomTypes.get(4), "Suite Deluxe con cama king size, terraza privada, piscina climatizada, acceso exclusivo al spa y una zona de trabajo privada.", "550", "6"));

        // Apartment rooms
        rooms.add(Arrays.asList(hotels.get(5).get(2), roomTypes.get(0), "Estudio moderno con cocina completamente equipada, cama individual, baño privado, balcón con vistas al jardín y Wi-Fi gratuito.", "170", "12"));
        rooms.add(Arrays.asList(hotels.get(5).get(2), roomTypes.get(2), "Apartamento de 2 habitaciones, cocina completamente equipada, sala de estar espaciosa, terraza con vista panorámica a la ciudad y acceso a la piscina.", "350", "6"));
        rooms.add(Arrays.asList(hotels.get(5).get(2), roomTypes.get(3), "Penthouse de lujo con 3 dormitorios, jacuzzi privado, sala de cine, terraza privada con barbacoa, ascensor exclusivo y servicio de mayordomo.", "750", "3"));

        rooms.add(Arrays.asList(hotels.get(6).get(2), roomTypes.get(0), "Estudio moderno con cocina equipada, cama individual, baño privado, balcón con vistas al jardín y acceso a gimnasio.", "160", "15"));
        rooms.add(Arrays.asList(hotels.get(6).get(2), roomTypes.get(2), "Apartamento de 2 habitaciones, cocina completa, sala de estar amplia, terraza con vista a la ciudad y zona de juegos para niños.", "320", "9"));
        rooms.add(Arrays.asList(hotels.get(6).get(2), roomTypes.get(3), "Penthouse con 3 dormitorios, jacuzzi, sala de cine, terraza privada, ascensor exclusivo, acceso a spa y servicio 24/7.", "700", "4"));

        rooms.add(Arrays.asList(hotels.get(7).get(2), roomTypes.get(0), "Estudio con cocina moderna, cama individual, baño privado, balcón con vistas al jardín, TV inteligente y Wi-Fi.", "180", "14"));
        rooms.add(Arrays.asList(hotels.get(7).get(2), roomTypes.get(2), "Apartamento de 2 habitaciones con cocina completa, sala de estar, terraza con vista a la ciudad y acceso al club privado de residentes.", "330", "7"));
        rooms.add(Arrays.asList(hotels.get(7).get(2), roomTypes.get(3), "Penthouse de lujo con 3 dormitorios, jacuzzi privado, cine en casa, terraza privada con vista al mar, ascensor privado y chef personal.", "800", "2"));

        rooms.add(Arrays.asList(hotels.get(8).get(2), roomTypes.get(0), "Estudio de diseño moderno con cocina equipada, cama individual, baño privado, balcón, aire acondicionado y acceso a la piscina exterior.", "160", "10"));
        rooms.add(Arrays.asList(hotels.get(8).get(2), roomTypes.get(2), "Apartamento de 2 habitaciones, cocina completamente equipada, sala de estar, terraza con vista panorámica y acceso al gimnasio.", "340", "8"));
        rooms.add(Arrays.asList(hotels.get(8).get(2), roomTypes.get(3), "Penthouse con 3 dormitorios, jacuzzi, cine privado, terraza exclusiva, ascensor privado, y acceso a la zona VIP del hotel.", "720", "5"));

        rooms.add(Arrays.asList(hotels.get(9).get(2), roomTypes.get(0), "Estudio moderno con cocina equipada, cama individual, baño privado, balcón y servicio de limpieza diario.", "165", "13"));
        rooms.add(Arrays.asList(hotels.get(9).get(2), roomTypes.get(2), "Apartamento de 2 habitaciones con cocina completa, sala de estar, terraza con vista a la ciudad, y servicio de desayuno incluido.", "325", "6"));
        rooms.add(Arrays.asList(hotels.get(9).get(2), roomTypes.get(3), "Penthouse de lujo con 3 dormitorios, jacuzzi privado, cine en casa, terraza privada, ascensor exclusivo, y acceso al spa y gimnasio.", "750", "4"));

        // Country house (Finca) rooms
        rooms.add(Arrays.asList(hotels.get(10).get(2), roomTypes.get(0), "Cabaña rústica con cama sencilla, baño privado, chimenea, terraza con hamacas y vista panorámica a las montañas.", "140", "30"));
        rooms.add(Arrays.asList(hotels.get(10).get(2), roomTypes.get(2), "Habitación triple en casa de campo, incluye desayuno con productos locales, acceso a una piscina natural y actividades al aire libre como senderismo.", "270", "6"));
        rooms.add(Arrays.asList(hotels.get(10).get(2), roomTypes.get(4), "Suite Deluxe en finca con jacuzzi al aire libre, terraza con hamacas, vista al valle y acceso exclusivo a un mirador privado.", "500", "35"));

        rooms.add(Arrays.asList(hotels.get(11).get(2), roomTypes.get(0), "Cabaña rústica con cama sencilla, baño privado, chimenea, terraza con vistas a la naturaleza y acceso a senderos ecológicos.", "130", "28"));
        rooms.add(Arrays.asList(hotels.get(11).get(2), roomTypes.get(2), "Habitación triple en casa de campo, incluye desayuno casero con productos locales, acceso a una piscina natural y actividades como pesca y paseos a caballo.", "260", "5"));
        rooms.add(Arrays.asList(hotels.get(11).get(2), roomTypes.get(4), "Suite Deluxe en finca con jacuzzi privado, terraza con hamacas, vistas al valle y acceso a una zona de bienestar con spa y sauna.", "480", "33"));

        rooms.add(Arrays.asList(hotels.get(12).get(2), roomTypes.get(0), "Cabaña rústica con cama sencilla, baño privado, chimenea, balcón con vista a las montañas y acceso a una zona de picnic al aire libre.", "135", "27"));
        rooms.add(Arrays.asList(hotels.get(12).get(2), roomTypes.get(2), "Habitación triple en casa de campo, incluye desayuno orgánico con productos locales y acceso a una piscina natural rodeada de naturaleza.", "280", "7"));
        rooms.add(Arrays.asList(hotels.get(12).get(2), roomTypes.get(4), "Suite Deluxe en finca con jacuzzi exterior, terraza con hamacas, vistas al valle y acceso a una zona privada para hacer fogatas.", "490", "32"));

        rooms.add(Arrays.asList(hotels.get(13).get(2), roomTypes.get(0), "Cabaña rústica con cama sencilla, baño privado, chimenea, vista a las montañas y acceso a una zona de observación de aves.", "125", "29"));
        rooms.add(Arrays.asList(hotels.get(13).get(2), roomTypes.get(2), "Habitación triple en casa de campo, incluye desayuno típico con productos orgánicos y acceso a piscina natural, ideal para relajarse.", "275", "6"));
        rooms.add(Arrays.asList(hotels.get(13).get(2), roomTypes.get(4), "Suite Deluxe en finca con jacuzzi privado al aire libre, terraza con hamacas, vistas panorámicas al valle y acceso a una sala de yoga y meditación.", "470", "31"));

        rooms.add(Arrays.asList(hotels.get(14).get(2), roomTypes.get(0), "Cabaña rústica con cama sencilla, baño privado, chimenea, balcón y acceso a rutas de senderismo en el bosque.", "125", "25"));
        rooms.add(Arrays.asList(hotels.get(14).get(2), roomTypes.get(2), "Habitación triple en casa de campo, incluye desayuno con productos orgánicos y acceso a una piscina natural rodeada de jardines y fauna local.", "265", "5"));
        rooms.add(Arrays.asList(hotels.get(14).get(2), roomTypes.get(4), "Suite Deluxe en finca con jacuzzi al aire libre, terraza con hamacas, vistas al valle y acceso a una zona privada con fogatas para las noches estrelladas.", "460", "34"));

        // Day-use (Día de Sol) rooms
        rooms.add(Arrays.asList(hotels.get(15).get(2), roomTypes.get(5), "Día de sol con acceso a piscina, zonas recreativas, almuerzo buffet y sesión de yoga al aire libre.", "90", "7"));
        rooms.add(Arrays.asList(hotels.get(15).get(2), roomTypes.get(5), "Día de sol con actividades deportivas, acceso a spa, transporte y refrigerio, además de un taller de cocina local.", "130", "18"));
        rooms.add(Arrays.asList(hotels.get(15).get(2), roomTypes.get(5), "Día de sol premium con piscina privada, actividades exclusivas, almuerzo gourmet, masajes y acceso a un tour privado de la ciudad.", "320", "10"));

        rooms.add(Arrays.asList(hotels.get(16).get(2), roomTypes.get(5), "Día de sol con acceso a piscina, zonas recreativas, almuerzo buffet y actividad de arte al aire libre.", "90", "7"));
        rooms.add(Arrays.asList(hotels.get(16).get(2), roomTypes.get(5), "Día de sol con actividades deportivas, acceso a spa, transporte y refrigerio, con un taller de danza local incluido.", "130", "18"));
        rooms.add(Arrays.asList(hotels.get(16).get(2), roomTypes.get(5), "Día de sol premium con piscina privada, actividades exclusivas, almuerzo gourmet, masajes y un paseo en bote por el río.", "320", "10"));

        rooms.add(Arrays.asList(hotels.get(17).get(2), roomTypes.get(5), "Día de sol con acceso a piscina, zonas recreativas, almuerzo buffet y sesión de meditación al atardecer.", "90", "7"));
        rooms.add(Arrays.asList(hotels.get(17).get(2), roomTypes.get(5), "Día de sol con actividades deportivas, acceso a spa, transporte y refrigerio, además de una clase de fotografía en la naturaleza.", "130", "18"));
        rooms.add(Arrays.asList(hotels.get(17).get(2), roomTypes.get(5), "Día de sol premium con piscina privada, actividades exclusivas, almuerzo gourmet, masajes y acceso a un recorrido privado por una reserva natural.", "320", "10"));

        rooms.add(Arrays.asList(hotels.get(18).get(2), roomTypes.get(5), "Día de sol con acceso a piscina, zonas recreativas, almuerzo buffet y clase de pilates en el jardín.", "90", "7"));
        rooms.add(Arrays.asList(hotels.get(18).get(2), roomTypes.get(5), "Día de sol con actividades deportivas, acceso a spa, transporte y refrigerio, además de una clase de cocina tradicional.", "130", "18"));
        rooms.add(Arrays.asList(hotels.get(18).get(2), roomTypes.get(5), "Día de sol premium con piscina privada, actividades exclusivas, almuerzo gourmet, masajes y una experiencia de cata de vinos.", "320", "10"));

        rooms.add(Arrays.asList(hotels.get(19).get(2), roomTypes.get(5), "Día de sol con acceso a piscina, zonas recreativas, almuerzo buffet y sesión de tai chi al aire libre.", "90", "7"));
        rooms.add(Arrays.asList(hotels.get(19).get(2), roomTypes.get(5), "Día de sol con actividades deportivas, acceso a spa, transporte y refrigerio, y un taller de arte para niños.", "130", "18"));
        rooms.add(Arrays.asList(hotels.get(19).get(2), roomTypes.get(5), "Día de sol premium con piscina privada, actividades exclusivas, almuerzo gourmet, masajes y una noche de música en vivo.", "320", "10"));

        return rooms;
    }
    // endregion

    // region rooms available
    public static List<List<String>> updatePriceHotel(List<List<String>> rooms, List<List<String>> hotels, int daysBetween) {
        for (List<String> hotel : hotels) {
            String hotelName = hotel.get(2);
            double minPrice = Double.MAX_VALUE;

            for (List<String> room : rooms) {
                String roomHotelName = room.get(0);
                if (roomHotelName.equals(hotelName)) {
                    double roomPrice = Double.parseDouble(room.get(3));
                    minPrice = Math.min(minPrice, roomPrice);
                }
            }

            hotel.set(4, String.valueOf(minPrice));
            hotel.set(5, String.valueOf(minPrice * daysBetween));
        }

        return hotels;
    }

    public static void getRoom(List<String> room) {
        System.out.println("Tipo de habitación: " + room.get(1));
        System.out.println("Descripción de la habitación: " + room.get(2));
        System.out.println("Precio de la habitación: $" + room.get(3));
        System.out.println("Habitaciones disponibles: " + room.get(4));
    }

    public static List<String> getRoomsForHousing(List<List<String>> rooms, String hotelName) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Listado de habitaciones disponibles:");
        int index = 1;

        System.out.println("Nombre del hotel: " + hotelName);

        for (List<String> room : rooms) {
            String roomHotelName = room.get(0);

            if (hotelName.equals(roomHotelName)) {
                System.out.println(index + ":");
                getRoom(room);
                System.out.println("-----------------------------------");
                index++;
            }
        }
        if (index == 1) {
            System.out.println("No se encontraron habitaciones que coincidan con los criterios.");
        }

        int selection = -1;
        while (true) {
            try {
                System.out.print("\nEscribe el número de la habitación que deseas seleccionar (1-" + (index - 1) + "): ");
                selection = sc.nextInt();

                if (selection > 0 && selection < index) {
                    int currentIndex = 1;
                    for (List<String> room : rooms) {
                        String roomHotelName = room.get(0);

                        if (hotelName.equals(roomHotelName)) {
                            if (currentIndex == selection) {
                                return room;
                            }
                            currentIndex++;
                        }
                    }
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

    // region desired accommodation
    public static List<String> createDesiredAccommodation(String city, String housingType, LocalDate startDate, LocalDate endDate,
                                                          int numberOfAdults, int numberOfChildren, int numberOfRooms) {
        long daysBetween = (endDate.toEpochDay() - startDate.toEpochDay());

        List<List<String>> rooms = createRooms((int) daysBetween);
        List<List<String>> hotels = updatePriceHotel(rooms, createHotelsValues(100, (int) daysBetween), (int) daysBetween);

        List<String> hotel = getHotelByCityAndHousing(hotels, city, housingType);
        System.out.println("\nHotel seleccionado: ");
        getHotel(hotel);

        double price = Double.parseDouble(hotel.get(5));
        double totalPrice = price * numberOfRooms;
        System.out.println("\nPrecio base con " + numberOfRooms + " habitaciones: $" + totalPrice);

        int startDay = startDate.getDayOfMonth();
        int endDay = endDate.getDayOfMonth();

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(java.sql.Date.valueOf(startDate));
        int lastDayOfStartMonth = startCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(java.sql.Date.valueOf(endDate));
        int lastDayOfEndMonth = endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        double percentageApplied = 0;
        double adjustmentAmount = 0;

        if ((startDay >= lastDayOfStartMonth - 4) && (endDay >= lastDayOfEndMonth - 4)) {
            percentageApplied = 0.15;
            adjustmentAmount = totalPrice * percentageApplied;
            totalPrice += adjustmentAmount;
            System.out.println("Se aplicó un aumento del 15%: +$" + adjustmentAmount);
        } else if ((startDay >= 10 && startDay <= 15) && (endDay >= 10 && endDay <= 15)) {
            percentageApplied = 0.10;
            adjustmentAmount = totalPrice * percentageApplied;
            totalPrice += adjustmentAmount;
            System.out.println("Se aplicó un aumento del 10%: +$" + adjustmentAmount);
        } else if ((startDay >= 5 && startDay <= 10) && (endDay >= 5 && endDay <= 10)) {
            percentageApplied = -0.08;
            adjustmentAmount = totalPrice * Math.abs(percentageApplied);
            totalPrice -= adjustmentAmount;
            System.out.println("Se aplicó un descuento del 8%: -$" + adjustmentAmount);
        } else {
            System.out.println("No se aplicó descuento ni aumento.");
        }

        System.out.println("Precio total del hotel después de ajustes: $" + totalPrice);
        hotel.set(5, String.valueOf(totalPrice));

        return hotel;
    }
    // endregion

    // region confirm rooms
    public static void confirmRooms(String hotelName, LocalDate startDate, LocalDate endDate, int numberOfAdults, int numberOfChildren, int numberOfRooms) {
        Scanner sc = new Scanner(System.in);

        long daysBetween = (endDate.toEpochDay() - startDate.toEpochDay());
        List<List<String>> rooms = createRooms((int) daysBetween);

        System.out.println("\n*** Confirmación de habitaciones para el hotel: " + hotelName + " ***\n");

        List<List<String>> selectedRooms = new ArrayList<>();
        int remainingRooms = numberOfRooms;

        while (remainingRooms > 0) {
            System.out.println("\nHabitaciones restantes por seleccionar: " + remainingRooms);

            List<String> selectedRoom = getRoomsForHousing(rooms, hotelName);

            int quantity = 0;
            while (true) {
                System.out.print("\n¿Cuántas habitaciones de este tipo deseas? ");
                try {
                    quantity = sc.nextInt();
                    if (quantity > remainingRooms) {
                        System.out.println("La cantidad ingresada supera el número de habitaciones restantes (" + remainingRooms + "). Por favor, ingresa una cantidad válida.");
                    } else if (quantity <= 0) {
                        System.out.println("Por favor, ingresa un número mayor a 0.");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Entrada no válida. Por favor, ingresa un número entero.");
                    sc.next();
                }
            }

            for (int i = 0; i < quantity; i++) {
                selectedRooms.add(selectedRoom);
            }

            remainingRooms -= quantity;
            System.out.println("\nHas seleccionado " + quantity + " habitación(es) correctamente.");

            if (remainingRooms > 0) {
                System.out.print("¿Deseas seleccionar más habitaciones? (S/N): ");
                String response = sc.next();
                if (!response.equalsIgnoreCase("S")) {
                    break;
                }
            }
        }

        System.out.println("\n*** Resumen de habitaciones seleccionadas ***\n");
        for (int i = 0; i < selectedRooms.size(); i++) {
            System.out.println("Habitación " + (i + 1) + ":");
            getRoom(selectedRooms.get(i));
            System.out.println("-----------------------------------");
        }

        if (remainingRooms > 0) {
            System.out.println("\nNo seleccionaste todas las habitaciones disponibles. ¡Asegúrate de confirmar tus opciones!");
        }

        System.out.println("\nGracias por confirmar tus habitaciones. ¡Que tengas una estancia agradable!");
    }

    // endregion
}