# Aplicación Booking Hoteles 🏢

## Tabla de Contenidos 📑
1. [Descripción del Proyecto](#descripción-del-proyecto)
2. [Funcionalidades](#funcionalidades)
3. [Cómo Usar la Aplicación](#cómo-usar-la-aplicación)
4. [Estructura del Proyecto](#estructura-del-proyecto)
5. [Contribuir](#contribuir)
6. [Licencia](#licencia)
7. [Contacto](#contacto)

---

## Descripción del Proyecto 💡

**Booking Hoteles** es una aplicación que permite realizar reservas en varios tipos de alojamientos como **Hoteles**, **Apartamentos**, **Fincas** y **Días de Sol**. La aplicación está diseñada para facilitar la elección de hospedaje en ciudades turísticas, con funcionalidades como:

- Buscar alojamientos según parámetros de fecha, tipo de alojamiento, número de habitaciones y más.
- Calcular el precio total de la estadía con descuentos y aumentos basados en las fechas seleccionadas.
- Confirmar disponibilidad y realizar reservas de habitaciones.
- Modificar o cancelar reservas de manera sencilla.

---

## Funcionalidades 🛠️

### 1. **Buscar Hoteles**
   El método de búsqueda recibe los siguientes parámetros:
   - Ciudad
   - Tipo de alojamiento (Hotel, Apartamento, Finca, Día de Sol)
   - Día de inicio y finalización del hospedaje
   - Cantidad de adultos, niños y habitaciones

   **Resultados**: Devuelve los hoteles disponibles junto con detalles como nombre, calificación, precio por noche, y precio total considerando descuentos o aumentos.

   - Si la estadía abarca los últimos 5 días del mes → **+15%**
   - Si la estadía abarca los días 10-15 del mes → **+10%**
   - Si la estadía abarca los días 5-10 del mes → **-8%**

### 2. **Confirmación de Habitaciones**
   Método que verifica la disponibilidad de habitaciones. Recibe parámetros como:
   - Nombre del hotel
   - Fechas de inicio y finalización
   - Cantidad de personas y habitaciones.

   **Resultados**: Devuelve los tipos de habitaciones disponibles con sus características y precios.

### 3. **Realizar una Reserva**
   Método para confirmar una reserva. El cliente debe proporcionar:
   - Nombre
   - Apellido
   - Email
   - Nacionalidad
   - Número de teléfono
   - Hora aproximada de llegada

   **Resultados**: Se confirma la reserva y se reduce la cantidad de habitaciones disponibles.

### 4. **Actualizar una Reserva**
   Si un cliente desea actualizar su reserva, se requiere autenticación mediante:
   - Correo electrónico

   **Opciones de actualización**:
   - Cambiar habitación (ver opciones disponibles).
   - Cambiar alojamiento (eliminación y nueva reserva).

---

## Cómo Usar la Aplicación 🚀

### 1. Clonar el repositorio

Para comenzar a trabajar con el proyecto, clona el repositorio en tu máquina local:

```bash
git clone https://github.com/bymarium/hotel-booking.git

