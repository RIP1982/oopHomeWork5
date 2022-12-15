package data;

import java.util.ArrayList;

public class PhoneBook {
    ArrayList<Contact> phoneBook;

    public PhoneBook(ArrayList<Contact> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public ArrayList<Contact> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(ArrayList<Contact> phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook +
                '}';
    }
}
