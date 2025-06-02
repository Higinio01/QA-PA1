package org.example;

public class Empleado {
    private String nombre;
    private TipoEmpleado tipo;
    private double tarifaPorHora;
    private boolean autorizado;

    public Empleado(String nombre, TipoEmpleado tipo, double tarifaPorHora, boolean isAutorizado) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre inválido.");
        if (tarifaPorHora <= 0) throw new IllegalArgumentException("Tarifa debe ser mayor a cero.");
        this.nombre = nombre;
        this.tipo = tipo;
        this.tarifaPorHora = tarifaPorHora;
        this.autorizado = isAutorizado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoEmpleado getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmpleado tipo) {
        this.tipo = tipo;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    public boolean isAutorizado() {
        return autorizado;
    }
}