package data;

import java.util.ArrayList;

public class Contact extends Person{
    private ArrayList<String> personNumbers;
    public Contact(String name, String lastName, ArrayList<String> personNumbers) {
        super(name, lastName);
        this.personNumbers = personNumbers;
    }

    public ArrayList<String> getPersonNumbers() {
        return personNumbers;
    }

    public void setPersonNumbers(ArrayList<String> personNumbers) {
        this.personNumbers = personNumbers;
    }

    @Override
    public String toString() {
        return "\n{" + " lastName='" + super.getLastName() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", personNumbers=" + personNumbers +
                "}";
    }
}
