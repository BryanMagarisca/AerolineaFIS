package com.mycompany.aerolineafis;

public class Reserva {
    private String codigoReserva;
    private String fechaReserva;
    private String estadoPago;
    private Pasajero pasajero;
    private Vuelo vuelo;

    public Reserva(String codigo, String fecha, String estado, Pasajero pasajero, Vuelo vuelo) {
        this.codigoReserva = codigo;
        this.fechaReserva = fecha;
        this.estadoPago = estado;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
    }

    public String getCodigoReserva() { return codigoReserva; }
    public Pasajero getPasajero() { return pasajero; }
    public Vuelo getVuelo() { return vuelo; }

    @Override
    public String toString() {
        // Formato: COD_RESERVA, FECHA, ESTADO, ID_PASAJERO, COD_VUELO
        return codigoReserva + "," + fechaReserva + "," + estadoPago + "," + pasajero.getIdentificacion() + "," + vuelo.getCodigoVuelo();
    }

}
