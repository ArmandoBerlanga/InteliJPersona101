package com.ufv.persona.backend;

public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private String dni;
    private Sexo sexo;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, String dni, Sexo sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
    }

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "{" +
            "\"nombre\":\"" + nombre + '\"' +
            ", \"apellido\":\"" + apellido + '\"' +
            ", \"edad\":" + edad +
            ", \"dni\":\"" + dni + '\"' +
            ", \"sexo\":\"" + sexo + '\"' +
        '}';
    }
    
}
