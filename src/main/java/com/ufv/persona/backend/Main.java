package com.ufv.persona.backend;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Persona> ppl = Arrays.asList(
            new Persona("José", "Berlanga", 12, "G271234", Sexo.HOMBRE),
            new Persona("María", "García", 23, "G271234", Sexo.OTRO),
            new Persona("Juan", "García", 23, "G271234", Sexo.HOMBRE),
            new Persona("María", "García", 23, "G271234", Sexo.PREFIERO_NO_DECIRLO),
            new Persona("María", "García", 23, "G271234", Sexo.MUJER),
            new Persona("María", "García", 23, "G271234", Sexo.MUJER)
        );

        for(Persona p : ppl) System.out.println(p + ",");
    }
}