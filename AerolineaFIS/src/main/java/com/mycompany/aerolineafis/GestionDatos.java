package com.mycompany.aerolineafis;

import java.io.*;
import java.util.*;

public class GestionDatos {
    private LectorArchivos lector;
    private File archivoAviones;
    private File archivoRutas;
    private File archivoReservas;

    public GestionDatos() {
        this.lector = new LectorArchivos();
        this.archivoAviones = new File("datos/aviones.txt");
        this.archivoRutas = new File("datos/rutas.txt");
        this.archivoReservas = new File("datos/reservas.txt");
        asegurarExistenciaArchivos();
    }

    private void asegurarExistenciaArchivos() {
        try {
            File carpeta = new File("datos");
            if (!carpeta.exists()) carpeta.mkdir();
            
            if (!archivoAviones.exists()) archivoAviones.createNewFile();
            if (!archivoRutas.exists()) archivoRutas.createNewFile();
            if (!archivoReservas.exists()) archivoReservas.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Métodos de Carga 
    public List<Avion> cargarAviones() throws IOException {
        return lector.leerAviones(archivoAviones.getPath());
    }

    public List<Ruta> cargarRutas() throws IOException {
        return lector.leerRutas(archivoRutas.getPath());
    }

    public boolean guardarReserva(Reserva r) {
        // Usamos el archivo 'datos/reservas.txt' definido en el constructor
        try (FileWriter fw = new FileWriter(archivoReservas, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(r.toString()); // Usa el toString, parecido al mapa donde para guardar la reserva
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validarAsientos(Vuelo vuelo, int cantidadSolicitada) {
        return cantidadSolicitada <= vuelo.getAvion().getCapacidad();
    }

}
