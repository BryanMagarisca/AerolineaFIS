package com.mycompany.aerolineafis;

import java.util.List;

public class Aerolinea {
    private GestionDatos gestor;
    private List<Avion> aviones;
    private List<Ruta> rutas;

    public Aerolinea() {
        this.gestor = new GestionDatos();
        cargarSistema();
    }

    public void cargarSistema() {
        try {
            this.aviones = gestor.cargarAviones();
            this.rutas = gestor.cargarRutas();
        } catch (Exception e) {
            System.err.println("Error al inicializar sistema: " + e.getMessage());
        }
    }

    public List<Avion> getAvionesDisponibles() {
        return aviones;
    }
}