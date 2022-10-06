package com.ufv.persona.backend;

public class Main {
    public static void main(String[] args) {
        PersonaList ppl = new PersonaList();
        
        // TYPES OF READ
        // ppl.readJSONFile("Personas", false);
        // ppl.readCSVFile("Personas", false);
        ppl.readCSVFile("Personas", true);

        // ppl.value.add(new Persona("Lorenzo", "Italiano", 20, "12345678A", Sexo.HOMBRE));

        // CREATE JSON
        // ppl.createJSONFile("Personas");
        ppl.createJSONFile("PersonasDesdeCSV");
    }
}