package client;

import com.opencsv.exceptions.CsvException;
import data.Contact;
import service.ContactService;
import service.IContact;
import view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class App {
    View ui;
    IContact phoneBook = new ContactService();
    ArrayList<Contact> contacts = new ArrayList<>();
    Logger logger = Logger.getAnonymousLogger();

    public App() {
        ui = new ConsoleView();
    }

    public void start()  throws IOException, CsvException {
        StringBuilder sb = new StringBuilder()
                .append("\n ==== \n")
                .append("1 - add contact\n")
                .append("2 - remove contact\n")
                .append("3 - show all\n")
                .append("4 - write to csv\n")
                .append("5 - read from csv\n")
                .append("0 - exit\n");


        while (true) {
            ui.set(sb.toString());
            switch (ui.get()) {
                case "1":
                    logger.info(phoneBook.addContact(contacts).toString());
                    break;
                case "2":
                    phoneBook.removeContact(contacts);
                    break;
                case "3":
                    phoneBook.showAll(contacts);
                    break;
                case "4":
                    phoneBook.writeToCsv(contacts);
                    break;
                case "5":
                    contacts = phoneBook.readFromCsv();
                    break;
                case "0":
                    return;
            }
        }
    }
}
