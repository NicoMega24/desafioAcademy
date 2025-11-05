package com.laboratoriochad.dominio;

public abstract class Experimento {
    private String nombre;
    private int duracion; // en minutos
    private boolean exitoso;

    public Experimento(String nombre, int duracion, boolean exitoso) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.exitoso = exitoso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public boolean isExitoso() {
        return exitoso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setExitoso(boolean exitoso) {
        this.exitoso = exitoso;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return String.format("%s [nombre=%s, duracion=%d, exitoso=%s]", 
                getTipo(), nombre, duracion, exitoso ? "Sí" : "No");
    }
}
