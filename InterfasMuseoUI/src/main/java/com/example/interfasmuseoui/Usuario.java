package com.example.interfasmuseoui;

import java.time.LocalDate;

// Creacion de usuario
public class Usuario {
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private LocalDate fechaCumpleanos;
    private String categoria;
    private int edad;
    private boolean afiliado;
    private double costoPorPersona;




    public Usuario() {
    }

    // Métodos setters y getters para los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDate getFechaCumpleanos() {
        return fechaCumpleanos;
    }

    public void setFechaCumpleanos(LocalDate fechaCumpleanos) {
        this.fechaCumpleanos = fechaCumpleanos;
    }

    public int getEdad() {return edad;}

    public void setEdad(int edad) {this.edad = edad;}

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getCostoPorPersona() {return costoPorPersona;}

    public void setCostoPorPersona(double costoPorPersona) {this.costoPorPersona = costoPorPersona;}

    // Otros métodos setters y getters

    public boolean isAfiliado() {
        return afiliado;
    }
    public void setAfiliado(boolean afiliado) {
        this.afiliado = afiliado;
    }

}
