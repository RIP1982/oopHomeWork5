package service;

import data.Contact;
import java.io.IOException;
import java.util.ArrayList;

public interface IContact {
    Contact createContact();
    ArrayList<Contact> addContact(ArrayList<Contact> phoneBook);
    void showAll(ArrayList<Contact> phoneBook);
    void removeContact(ArrayList<Contact> phoneBook);
    ArrayList<Contact> readFromCsv() throws IOException;
    void writeToCsv(ArrayList<Contact> phoneBook) throws IOException;


}
