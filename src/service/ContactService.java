package service;

import com.opencsv.exceptions.CsvException;
import data.Contact;
import data.PhoneBook;
import util.ReadFromConsole;
import util.ReadFromCsv;
import util.WriteToCsv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ContactService implements IContact{
    Logger logger = Logger.getAnonymousLogger();
    @Override
    public Contact createContact() {
        return new ReadFromConsole().readFromConsole();
    }

    @Override
    public ArrayList<Contact> addContact(ArrayList<Contact> phoneBook) {
        phoneBook.add(createContact());
        return phoneBook;
    }

    @Override
    public void showAll(ArrayList<Contact> phoneBook) {
        logger.info((new PhoneBook(phoneBook)).toString());
    }

    @Override
    public void removeContact(ArrayList<Contact> phoneBook) {
        System.out.printf("Enter the name or lastName or number: ");
        String request = (new Scanner(System.in).nextLine());
        int counter = phoneBook.size();
        for (Contact contact: phoneBook) {
            if (contact.getName().equals(request)) {
                logger.info(contact.toString());
                System.out.println();
                System.out.printf("Are you sure?(y/n)");
                String choice = (new Scanner(System.in).nextLine());
                if (choice.equals("y")) {
                    phoneBook.remove(contact);
                    break;
                } else {
                    logger.info("Your contact has not been deleted!");
                }
            }
            else if (contact.getLastName().equals(request)) {
                logger.info(contact.toString());
                System.out.printf("Are you sure?(y/n)");
                String choice = (new Scanner(System.in).nextLine());
                if (choice.equals("y")) {
                    phoneBook.remove(contact);
                    break;
                } else {
                    logger.info("Your contact has not been deleted!");
                }
            } else {
                for (String number : contact.getPersonNumbers()) {
                    if (number.equals(request)) {
                        logger.info(contact.toString());
                        System.out.printf("Are you sure?(y/n)");
                        String choice = (new Scanner(System.in).nextLine());
                        if (choice.equals("y")) {
                            phoneBook.remove(contact);
                            break;
                        } else {
                            logger.info("Your contact has not been deleted!");
                        }
                    }
                }
            }
        }
        if (counter == phoneBook.size()) {
            logger.info("Wrong request!");
        }
    }

    @Override
    public ArrayList<Contact> readFromCsv() throws IOException {
        return ReadFromCsv.readToCsv();
    }

    @Override
    public void writeToCsv(ArrayList<Contact> phoneBook) throws IOException {
        WriteToCsv.writeToCsv(phoneBook);
        logger.info("write to csv complete!");
    }
}
