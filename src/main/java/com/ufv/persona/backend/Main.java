package com.ufv.persona.backend;

public class Main {
    public static void main(String[] args) {
        PersonaList ppl = new PersonaList();
        
        ppl.readJSONFile("Personas");
        ppl.value.add(new Persona("Lorenzo", "Italiano", 20, "12345678A", Sexo.HOMBRE));

        ppl.createJSONFile("Personas");
    }
}