import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactsApp {

    private static Path p = Paths.get("src/contacts.txt");

    private static Input input = new Input(new Scanner(System.in));
//    private Map<String, Integer> contacts = new HashMap<>();

    private static List<Contact> contacts = new ArrayList<>();

    private static void rewrite() {

        ArrayList<String> printContacts = new ArrayList<>();

        for (Contact contact : contacts) {
            printContacts.add(contact.getName() + " " + contact.getPhone());
        }

        try {
            Files.write(p, printContacts);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void menu(){
        String output = "1. view\n"
                + "2. add \n"
                + "3. search\n"
                + "4. delete\n"
                + "5. exit";
        System.out.println(output);
    }

    public static void init(){
        menu();
        if (!Files.exists(p)) {
            try {
                Files.createFile(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        action(input.getInt(1, 5, "Enter an option"));

    }

    public static boolean action(int choice){
        boolean continueRunning = true;
        switch(choice){
            case 1:
                view();
                break;
            case 2:
                add();
                break;
            case 3:
                search(input.getString("Enter contact name"));
                break;
            case 4:
                delete(input.getString("Enter contact name to delete"));
                break;
            case 5:
                if(!input.yesNo("Continue running?")){
                    continueRunning = false;
                }
                break;
        }
        return continueRunning;
    }

    public static void view() {

        try {
            System.out.println(Files.readAllLines(p));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void add() {
        String name = input.getString("What is the name of the contact?");
        Integer phone = input.getInt("What is the phone number?");

        Contact newContact = new Contact(name, phone);
        contacts.add(newContact);
        rewrite();

    }

    public static void search(String keyName) {



        for (Contact contact : contacts) {
            if (contact.getName().equals(keyName)) {
                System.out.println(contact.getName() + " " + contact.getPhone());
            } else {
                System.out.println("Contact not found!");
            }
        }
    }

    public static void delete(String keyName) {

        for (Contact contact : contacts) {
            if (contact.getName().equals(keyName)) {
                contacts.remove(contacts.indexOf(contact));
            }
        }

        rewrite();


    }

    public static void main(String[] args) {

        init();

    }
}
