package com.ufv.persona.backend;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

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

        for(Persona p : value) json += p + ",";
        json = json.substring(0, json.length() - 1);

        return "[" + json + "]";
    }

    public void createJSONFile(String fileName) {
        String path = System.getProperty("user.dir") + "/src";
        path += "/" + fileName + ".json";

        File file = new File(path);
        if(file.exists()) file.delete();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = gson.fromJson(makeJSON(), JsonElement.class);
        String prettyJsonString = gson.toJson(je);

        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(prettyJsonString);
            writer.close();

            System.out.println("\nJSON file created successfully at " + path + "\n");
        } catch (Exception e) {
            System.out.println("\nError creating JSON file\n");
        }
    }

    @Override
    public String toString() {
        return makeJSON();
    }
}
