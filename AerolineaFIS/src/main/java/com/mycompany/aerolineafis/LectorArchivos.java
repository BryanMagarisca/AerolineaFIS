package com.mycompany.aerolineafis;

import java.io.*;
import java.util.*;

public class LectorArchivos {

    // Método para leer Aviones incluyendo su mapa de asientos
    public List<Avion> leerAviones(String rutaArchivo) throws IOException {
        List<Avion> lista = new ArrayList<>();
        File archivo = new File(rutaArchivo);
        
        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");
                // Formato esperado: COD, MODELO, FILAS, COLUMNAS, ESTADO, MAPA_ASIENTOS
                
                int filas = Integer.parseInt(d[2]);
                int columnas = Integer.parseInt(d[3]);
                
                Avion av = new Avion(d[0], d[1], filas, columnas, d[4]);
                
                // Si existe la cadena de mapa de asientos (d[5]), la cargamos
                if (d.length > 5) {
                    av.setMapaAsientosDesdeString(d[5]);
                }
                
                lista.add(av);
            }
        }
        return lista;
    }

    // Método para leer Rutas
    public List<Ruta> leerRutas(String rutaArchivo) throws IOException {
        List<Ruta> lista = new ArrayList<>();
        File archivo = new File(rutaArchivo);
        
        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");
                // Formato: COD, ORIGEN, DESTINO, PRECIO, DURACION
                lista.add(new Ruta(d[0], d[1], d[2], Double.parseDouble(d[3]), Integer.parseInt(d[4])));
            }
        }
        return lista;
    }

    // Método para leer Reservas (Usa IDs de Pasajero y Vuelo para vincular)
    public List<String> leerReservasRaw(String rutaArchivo) throws IOException {
        List<String> lineas = new ArrayList<>();
        File archivo = new File(rutaArchivo);
        
        if (!archivo.exists()) return lineas;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }

}
