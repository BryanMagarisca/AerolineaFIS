package com.mycompany.aerolineafis;

public class Ruta {
    private String codigoRuta;
    private String ciudadOrigen;
    private String ciudadDestino;
    private double precioBase;
    private int duracionEstimadaMinutos;

    public Ruta(String codigoRuta, String ciudadOrigen, String ciudadDestino, double precioBase, int duracion) {
        this.codigoRuta = codigoRuta;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precioBase = precioBase;
        this.duracionEstimadaMinutos = duracion;
    }

    public String getCodigoRuta() { return codigoRuta; }
    public String getCiudadOrigen() { return ciudadOrigen; }
    public String getCiudadDestino() { return ciudadDestino; }
    public double getPrecioBase() { return precioBase; }

    @Override
    public String toString() {
        return codigoRuta + "," + ciudadOrigen + "," + ciudadDestino + "," + precioBase + "," + duracionEstimadaMinutos;
    }
}