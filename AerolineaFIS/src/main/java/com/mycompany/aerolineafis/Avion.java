package com.mycompany.aerolineafis;

public class Avion {
    private String codigoAvion;
    private String modelo;
    private int filas;
    private int columnas;
    private String estado;
    private boolean[][] asientos; // true = ocupado, false = libre

    public Avion(String codigoAvion, String modelo, int filas, int columnas, String estado) {
        this.codigoAvion = codigoAvion;
        this.modelo = modelo;
        this.filas = filas;
        this.columnas = columnas;
        this.estado = estado;
        this.asientos = new boolean[filas][columnas];
    }

    public void setMapaAsientosDesdeString(String mapaStr) {
        if (mapaStr == null || mapaStr.length() != (filas * columnas)) {
            return; 
        }
        
        int k = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                asientos[i][j] = (mapaStr.charAt(k) == '1');
                k++;
            }
        }
    }

    public String getMapaAsientosComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sb.append(asientos[i][j] ? "1" : "0");
            }
        }
        return sb.toString();
    }
    
    public boolean ocuparAsiento(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            if (!asientos[fila][columna]) {
                asientos[fila][columna] = true;
                return true;
            }
        }
        return false;
    }

    public String getCodigoAvion() { return codigoAvion; }
    public String getModelo() { return modelo; } 
    public String getEstado() { return estado; } 
    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }
    public int getCapacidad() { return filas * columnas; }
    
    @Override
    public String toString() {
        // Formato para el archivo txt: COD,MODELO,FILAS,COLUMNAS,ESTADO,MAPA (donde mapa es un string en binario que muestra los asientos ocupados o vacios)
        return codigoAvion + "," + modelo + "," + filas + "," + columnas + "," + estado + "," + getMapaAsientosComoString();
    }

}
