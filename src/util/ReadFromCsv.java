package util;

import data.Contact;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

public class ReadFromCsv {
    public static ArrayList<Contact> readToCsv() throws IOException {
        Logger logger = Logger.getAnonymousLogger();
        ArrayList<Contact> contacts = new ArrayList<>();
        String row = null;
        BufferedReader csvReader = new BufferedReader(new FileReader("src/contacts.csv"));
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(" ");
            String temp = new String();
            for (int i = 2; i < data.length; i++) {
                temp += data[i];
            }
            String newTemp = new String();
            for (int i = 1; i < temp.length()-2; i++) {
                newTemp += temp.charAt(i);
            }
            ArrayList<String> numbers = new ArrayList<>();
            Collections.addAll(numbers, newTemp.split(","));
            Contact contact = new Contact(Arrays.stream(data).toList().get(1), Arrays.stream(data).toList().get(0),
                     numbers);
            contacts.add(contact);
        }
        csvReader.close();
        return contacts;
    }
}

