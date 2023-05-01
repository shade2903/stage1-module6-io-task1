package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(file));) {
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
               }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return profile;
    }

}
