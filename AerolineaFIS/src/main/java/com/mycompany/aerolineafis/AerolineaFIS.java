package com.mycompany.aerolineafis;

import java.util.List;

public class AerolineaFIS {

    public static void main(String[] args) {
        // 1. Inicializamos el modelo central
        // Al crearse, Aerolinea llama a GestionDatos y este a LectorArchivos automáticamente
        Aerolinea miAerolinea = new Aerolinea();

        System.out.println("=== DATOS CARGADOS DESDE LOS ARCHIVOS .TXT ===\n");

        // 2. Leer y mostrar los AVIONES
        System.out.println("--- LISTA DE AVIONES ---");
        if (miAerolinea.getAvionesDisponibles().isEmpty()) {
            System.out.println("No hay aviones en el archivo o la carpeta 'datos' no existe.");
        } else {
            for (Avion av : miAerolinea.getAvionesDisponibles()) {
                System.out.println("ID: " + av.getCodigoAvion() + 
                                   " | Modelo: " + av.getModelo() + 
                                   " | Capacidad: " + av.getCapacidad() + 
                                   " | Estado: " + av.getEstado());
                // Mostramos el mapa de asientos para verificar tu matriz (Persona 2)
                System.out.println("   Mapa de asientos: " + av.getMapaAsientosComoString());
            }
        }

        // 3. Leer y mostrar las RUTAS
        // (Asegúrate de tener el getter 'getRutas' en tu clase Aerolinea)
        System.out.println("\n--- LISTA DE RUTAS ---");
        // Si aún no tienes el getter en Aerolinea, puedes usar GestionDatos directamente:
        GestionDatos gestor = new GestionDatos();
        try {
            List<Ruta> listaRutas = gestor.cargarRutas();
            for (Ruta r : listaRutas) {
                System.out.println("Ruta: " + r.getCodigoRuta() + 
                                   " | " + r.getCiudadOrigen() + " -> " + r.getCiudadDestino() + 
                                   " | Precio: $" + r.getPrecioBase());
            }
        } catch (Exception e) {
            System.err.println("Error al leer rutas: " + e.getMessage());
        }

        System.out.println("\n=== FIN DE LA LECTURA DE DATOS ===");
    }
}
