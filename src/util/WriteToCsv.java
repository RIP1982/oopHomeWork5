package util;

import com.opencsv.CSVWriter;
import data.Contact;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteToCsv {
    public static void writeToCsv(ArrayList<Contact> contacts) throws IOException {
        List<String[]> contactsToString = new ArrayList<>();
        for (Contact contact: contacts) {
            String[] contactToString = new String[]{contact.getLastName() + " " + contact.getName() + " " +
                    String.valueOf(contact.getPersonNumbers())};
            contactsToString.add(contactToString);
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter("src/contacts.csv"))) {
            writer.writeAll(contactsToString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
