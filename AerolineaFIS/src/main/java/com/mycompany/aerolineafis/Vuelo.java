package com.mycompany.aerolineafis;

public class Vuelo {
    private String codigoVuelo;
    private String fechaSalida;
    private String horaSalida;
    private String estado;
    private Avion avion;
    private Ruta ruta;

    public Vuelo(String codigoVuelo, String fechaSalida, String horaSalida, String estado, Avion avion, Ruta ruta) {
        this.codigoVuelo = codigoVuelo;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.estado = estado;
        this.avion = avion;
        this.ruta = ruta;
    }

    public String getCodigoVuelo() { return codigoVuelo; }
    public Avion getAvion() { return avion; }
    public Ruta getRuta() { return ruta; }
    
    public boolean estaLleno(int pasajerosActuales) {
        return pasajerosActuales >= avion.getCapacidad();
    }
}