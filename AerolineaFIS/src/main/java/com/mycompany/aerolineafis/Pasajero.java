package com.mycompany.aerolineafis;

public class Pasajero {
    private String numeroIdentificacion;
    private String nombresCompletos;
    private String correoElectronico;
    private String telefono;

    public Pasajero(String id, String nombre, String correo, String telefono) {
        this.numeroIdentificacion = id;
        this.nombresCompletos = nombre;
        this.correoElectronico = correo;
        this.telefono = telefono;
    }

    public String getIdentificacion() { return numeroIdentificacion; }
    public String getNombre() { return nombresCompletos; }

    @Override
    public String toString() {
        // Formato para el archivo .txt
        return numeroIdentificacion + "," + nombresCompletos + "," + correoElectronico + "," + telefono;
    }

}
