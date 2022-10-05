package com.ufv.persona.backend;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonaList {
    List<Persona> value;

    public PersonaList() {
        this.value = new ArrayList<>();
    }

    public PersonaList(ArrayList<Persona> value) {
        this.value = value;
    }

    private String makeJSON() {
        String json = "";

        for(Persona p : this.value) json += p + ",";
        json = json.substring(0, json.length() - 1);

        return "[" + json + "]";
    }

    public void createJSONFile(String fileName) {
        String path = System.getProperty("user.dir") + "/src/" + fileName + ".json";

        File file = new File(path);
        if(file.exists()) file.delete();

        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(makeJSON());
            writer.close();

            System.out.println("\nJSON file created successfully at " + path + "\n");
        } catch (Exception e) {
            System.out.println("\nError creating JSON file\n");
        }
    }

    public void readJSONFile(String fileName) {
        Path path = Path.of(System.getProperty("user.dir") + "/src/" + fileName + ".json");

        String content = null;
        try {
            content = Files.readString(path);
        } catch (IOException e) {
            System.out.println("\nError reading JSON file\n");
        }

        if(content == null) return;

        Persona[] payload = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            payload = mapper.readValue(content, Persona[].class);
        } catch (IOException e) {
            System.out.println("\nError parsing JSON file\n");
        }

        this.value = new ArrayList<Persona>(Arrays.asList(payload));
    }

    @Override
    public String toString() {
        return makeJSON();
    }
}
