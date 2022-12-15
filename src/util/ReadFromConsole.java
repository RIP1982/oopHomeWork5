package util;

import client.ConsoleView;
import data.Contact;
import view.View;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadFromConsole {
    View ui;
    public ReadFromConsole() {ui = new ConsoleView();}
    public Contact readFromConsole() {
        System.out.printf("Enter the name: ");
        String name = (new Scanner(System.in).nextLine());
        System.out.printf("Enter the last name: ");
        String lastName = (new Scanner(System.in).nextLine());
        ArrayList<String> personNumbers = new ArrayList<>();

        StringBuilder sb = new StringBuilder()
                .append("\n ==== \n")
                .append("1 - add new number\n")
                .append("0 - exit\n");

        while (true) {
            ui.set(sb.toString());
            switch (ui.get()) {
                case "1":
                    System.out.printf("Enter the numberPhone: ");
                    String numberPhone = (new Scanner(System.in).nextLine());
                    personNumbers.add(numberPhone);
                    break;
                case "0":
                    return new Contact(name, lastName, personNumbers);
            }
        }
    }
}

