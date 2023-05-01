package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile;
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(file));) {
            profile = getValueFromLine(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return profile;
    }
    public Profile getValueFromLine(BufferedReader reader) throws IOException {
        Profile profile = new Profile();
        String line;
        while ((line =  reader.readLine()) != null){
            String [] values = line.split(":");
            String key = values[0].trim();
            String value = values[1].trim();
            switch (key){
                case ("Name"):
                    profile.setName(value);
                    break;
                case ("Age"):
                    profile.setAge(Integer.parseInt(value));
                    break;
                case ("Email"):
                    profile.setEmail(value);
                    break;
                case ("Phone"):
                    profile.setPhone(Long.parseLong(value));
                    break;
                default:
                    System.out.println("Line is not valid!");
            }
        }
        return profile;
    }

}
