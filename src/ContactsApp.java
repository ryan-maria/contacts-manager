import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactsApp {

    private static Path p = Paths.get("src","contacts.txt");

    private static Input input = new Input(new Scanner(System.in));
//    private Map<String, Integer> contacts = new HashMap<>();

    private static List<Contact> contacts = new ArrayList<>();

    private static void populateContacts(){
        List<String> contactStrings = new ArrayList<>();
        try {
            contactStrings = Files.readAllLines(p);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String contactString : contactStrings){
            List<String> contactInfo = new ArrayList<>(Arrays.asList(contactString.split(" ")));
//            contacts = new ArrayList<>();
            contacts.add(new Contact(contactInfo.get(0), contactInfo.get(1), Integer.parseInt(contactInfo.get(2))));//add contact object
        }

    }

    private static void menu(){
        String output = "1. view\n"
                + "2. add \n"
                + "3. search\n"
                + "4. delete\n"
                + "5. exit";
        System.out.println(output);
    }

    public static void init(){
        if (!Files.exists(p)) {
            try {
                Files.createFile(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        menu();
        //Take a moment to appreciate how cool this is~
        if(action(input.getInt(1, 5, "Enter an option\n"))){
            init();
        }

    }

    private static boolean action(int choice){
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
                if(input.yesNo("Are you sure you want to exit?")){
                    continueRunning = false;
//                    rewrite();
                }
                break;
        }
        return continueRunning;
    }

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

    private static void view() {
        List<String> outputs = new ArrayList<>();
        try {
            outputs = Files.readAllLines(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Name      | Phone");
        System.out.println("-----------------");
        for(String output : outputs){
            System.out.println(output + "\n");
        }
    }

    private static void add() {
        String firstName = input.getString("What is the first name of the contact?");
        String lastName = input.getString("What is the last name of the contact?");
        Integer phone = input.getInt("What is the phone number?");

        Contact newContact = new Contact(firstName.trim(), lastName.trim(), phone);
        System.out.println("              ____ \n" +
                "    .__      /_   |\n" +
                "  __|  |___   |   |\n" +
                " /__    __/   |   |\n" +
                "    |__|      |___|\n" +
                "                   ");
        contacts.add(newContact);
        rewrite();

    }

    private static void search(String keyName) {

        System.out.println("                                          ╓æφ@@α. ,╦æ╣░  ░─\n" +
                "                                      ,╤φ╪░        `▓▓▓▄ -   è\n" +
                "                                   «φ░░'         ,▄¥╦▐▓▓▓▌█δ║▒▌\n" +
                "                               ,æ╣░░          ╓▒▀╠╦▒▌ç  ╙▓▓▓▓▓▀        «@░ ░\n" +
                "                             ╓╣╬╣▒╣╗░≥     ╓▒▀╠φ╣╬╫▓▓█╙- ┴╩ ,,▓▓▓▓▌#e▒▀▀▒╗     ≡\n" +
                "                        ╓æφ▒░\"╟▓▓▌▒▌▒▒╗░  ▓▀@░╧▄▌▓▀╙       ⌐▓▓▓▓█▀▄▄'      ▓▄ ╔╦▒\n" +
                "                   ╓æ▒╪░░'     ▀▓▓▓▓▌▌▒▒╬║▓▓█╦  `▒╦.    ⌐.\"▄▓▓▀Å╠≥\" .   ⌐   ╙▓▌▒▓▓\n" +
                "               ╓æ╣░░░░'        ▀▓▓▓▓▓▓▌▒▒▒╬▓▓▓▀#▒Å  ▌▒▄Q▄╬▌▀▒╬╣╛     ─  ,─   ╤▀▓▓▓\n" +
                "           ╓æ╣░░░░░'         ,╠▌▓▓▓▓▓▓▓▌╬▒▒╫▓▓░░░║╦▓▓▄▐▀▀Å;░░     ⌐   ⌐  ,═╛,░╣▀▀\n" +
                "        ┌╣▀▒▒╬╪░░~       ,░░╠╢╣▓▓▓▓▓▓▓▓▌▒▒▒╣▀▀░ⁿ   ▀▓▓╠░░░░░,,=        ε┘,-╣▒╬╬▌æ\n" +
                "      ≡╔▄▄▄░╚░  `░ ⌐⌐░░░░╠╬╣▒▌▓▓▓▓▓┘   \"^      \"╞  ╔▓░░░░░░░╠╠╬╬╬φ╕    ╔Σ╣╠╗╬▀▀╣▓╕\n" +
                "      ║▓▓▓█▓▌,\", »╠╬╠╠╬╣▒▒▌▓▓▓▓▓▓┘                   '╪░░░░╠╬╬▒▒▒▒▀▒▒╦|░╦╣▒▀▒▒▓▓▓▀\n" +
                "      ╚▓▓▓▓▓▓▄╣,╚╠╬╬▌▒▒▌▓▓▓▓▓▓▓\"                       \"░░░╨╜╙\"  `\"╚╙▀▒▄╠╬╣▒█▌▓▓'\n" +
                "       ╚▓▓▓▓▓▓▌░░╙▒▒▌▓▓▓▓▓▓▓▓`                        ╓φ╪'           %φ╠╣▒▌▌▓▓▌\n" +
                "        \"▓▓▓▓▒▀▓▄░╙▓▓▓▓▓▓▓▌                       «φφ░            ░░╦╬▀▌▌▓▓▓▓`\n" +
                "          ╚█╬╝╬╦▒█▌▀▓▓▓▓┘                     .æ▒░░             ░░╠╣╣▒▌▓▓▓▓`\n" +
                "            ╘╚▀▌▌▄░╫▓┘                     ╒é╬░░░'          ,░░╠╬╣▒▒▌▓▓▓█\n" +
                "               `\"─\"                     .é╣╬╬░░\"\"-      .░░░╠╬╣▒▒▌▌▓▓▓╜\n" +
                "                                       ╣▄▄R▄▄      @Q░░╠╠╬╬╣▒▒▌▌▓▓▓▓▌\n" +
                "                                      ╞▓▓▓▌▓▓▌δ╕`╦░╦╠▌▄▒╣▒▒▌▓▓▓▓▓▓█\n" +
                "                                       █▓▓▓▌▓▓▄░░ ╚▒▒╬▀▓▌▓▓▓▓▓▓▓▓`\n" +
                "                                       ╘▓▓▓▓▓▓▓▌░░░╙▌▌▌▓▓▓▓▓▓▓▓┘\n" +
                "                                        '▓▓▓▓▓▌▓▓▄, ⌡▓▓▓▓▓▓▓▓┘\n" +
                "                                          ╘▓▓▀▒░»▀█▓▓▐▓▓▓▓█'\n" +
                "                                            ╘╬#▄╗J░\"─░▓▓╜\n" +
                "                                               \"╧╨╙╙░╝`\n");

        for (Contact contact : contacts) {
            if (contact.getName().trim().equals(keyName)) {
//                System.out.println("Found");
                System.out.printf("%s %d%n", contact.getName(), contact.getPhone());
            } else {
                System.out.println("Contact not found!");
            }
        }
    }

    private static void delete(String keyName) {
        int index = -1;
        for (Contact contact : contacts) {
            if (contact.getName().trim().equals(keyName)) {
                index = contacts.indexOf(contact);
//                contacts.remove(contacts.indexOf(contact));

            }
        }
        System.out.println("     _.-^^---....,,--       \n" +
                " _--                  --_  \n" +
                "<                        >)\n" +
                "|                         | \n" +
                " \\._                   _./  \n" +
                "    ```--. . , ; .--'''       \n" +
                "          | |   |             \n" +
                "       .-=||  | |=-.   \n" +
                "       `-=#$%&%$#=-'   \n" +
                "          | ;  :|     \n" +
                " _____.,-#%&$@%#&#~,._____");
        System.out.println("ELIMINATED");
        contacts.remove(index);
        rewrite();
    }

    public static void main(String[] args) {
        populateContacts();
        init();

    }
}
