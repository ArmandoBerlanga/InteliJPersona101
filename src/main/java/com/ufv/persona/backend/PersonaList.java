package com.ufv.persona.backend;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
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

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonObj = gson.fromJson(makeJSON(), JsonElement.class);
        String json = gson.toJson(jsonObj);

        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(json);
            writer.close();

            System.out.println("\nJSON file created successfully at " + path + "\n");
        } catch (Exception e) {
            System.out.println("\nError creating JSON file\n");
        }
    }

    public void readJSONFile(String fileName, boolean replace) {
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

        if(replace)
            this.value = new ArrayList<Persona>(Arrays.asList(payload));
        else
            this.value.addAll(Arrays.asList(payload));
    }

    public void readCSVFile(String fileName, boolean replace) {
        String path = System.getProperty("user.dir") + "/src/" + fileName + ".csv";

        File file = new File(path);
        if(!file.exists()) return;

        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (Exception e) {
            System.out.println("\nError reading CSV file\n");
        }

        if(replace) this.value = new ArrayList<Persona>();

        while(sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            if(line[0].equals("Nombre")) continue;

            Persona p = new Persona(line[0], line[1], Integer.parseInt(line[2]), line[3], Sexo.valueOf(line[4]));
            this.value.add(p);
        }        
    }

    @Override
    public String toString() {
        return makeJSON();
    }
}
